package com.avicsafety.webapp.controller;

import com.avicsafety.webapp.entity.SafetyArticle;
import com.avicsafety.webapp.entity.WebAttachments;
import com.avicsafety.webapp.service.SafetyArticleService;
import com.avicsafety.webapp.service.WebAttachmentsService;
import com.avicsafety.webapp.utils.DateTime;
import com.avicsafety.webapp.utils.DateTime.Format;
import com.avicsafety.webapp.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


@RestController
public class SafetyArticleController {
 //缺少查全部方法
	@Autowired
	SafetyArticleService SafetyArticleManager;
	WebAttachmentsService WebAttachmentsManager;
	 
	 @RequestMapping(value="/api/safetyarticle/getsafetyarticle")
	 public SafetyArticle findOne(@RequestParam("id") int id) {
		 SafetyArticle safetyArticle= SafetyArticleManager.findSafetyArticleById(id);
		 return safetyArticle;
	 }
	 
	 /**  
     * 实现文件上传  
	 * @throws FileNotFoundException 
     * */  
    @RequestMapping(value="/api/file/imageUpload",method = RequestMethod.POST)  
    @ResponseBody   
    public String fileUpload(HttpServletRequest request){  
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;  
        MultipartFile file = null;  
            file = multipartRequest.getFile("file");// 获取上传文件名  
        if(file.isEmpty()){  
            return "false";  
        }  
        String fileName = file.getOriginalFilename();//获取保存文件的文件名
        System.out.println(fileName);
        String uploadPath = "D:\\vscodeworkspase\\html_client\\WebContent\\file\\imageUpload";
        String currentDateStr = DateTime.getStrDate(Format.yyyymmdd);
        String extension = fileName.substring(fileName.lastIndexOf("."));
        String savePath = StringUtils.add(uploadPath , File.separator , currentDateStr);

        if (".png".equals(extension) || ".jpg".equals(extension)
                || ".gif".equals(extension) || "jpeg".equals(extension)
                || "bmp".equals(extension)) {
            if(file.getSize()<(300*1024)){
            	File dest = new File((savePath+"/"+fileName).substring(0, (savePath+"/"+fileName).lastIndexOf(".")-13));
            	if(!dest.getParentFile().exists()){ //判断文件父目录是否存在  
                    dest.getParentFile().mkdir();  
                }
				dest = new File((savePath+"/"+fileName));
                try {  
                    file.transferTo(dest); //保存文件  
                    String path = StringUtils.add("upload/images/",currentDateStr,"/",fileName);
	                Long id = save(path);
                    return StringUtils.add("page/show_img?id=",id);  
                } catch (IllegalStateException e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                    return "上传失败";  
                } catch (IOException e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                    return "保存失败";  
                }  
            }else{
                 return "文件太大";  
            }
        } else {
             return "只允许上传png,jpg,jpeg类型的图片文件";  
        }  
    }  
	public long save(String path) {
		String extension = path.substring(path.lastIndexOf("."));
		WebAttachments model = new WebAttachments();
		model.setDel(false);
		model.setCreatedate(DateTime.getDate());
		model.setPath(path);
		model.setType(extension);
		if(extension.toUpperCase().equals(".JPG")||
				extension.toUpperCase().equals(".PNG")||
				extension.toUpperCase().equals(".GIF")||
				extension.toUpperCase().equals(".JPEG")||
				extension.toUpperCase().equals(".BMP")){
			model.setType("IMAGE");
		}else{
			model.setType("OTHER");
		}
		WebAttachmentsManager.save(model);
		Long id = WebAttachmentsManager.findWebAttachmentsByPath(path).getId();
		return id;
	}
	
	 @RequestMapping(value="/api/safetyarticle/save")
	 public SafetyArticle saveArticle(@RequestBody SafetyArticle safetyArticle) {
		 return SafetyArticleManager.saveSafetyArticle(safetyArticle);
	 }
	 @RequestMapping(value = "/api/safetyarticle/select")
	 public Page<SafetyArticle> find(@RequestParam("title") String title,@RequestParam(defaultValue = "0") int pageIndex,@RequestParam(defaultValue = "10") int pageSize) {
    	 Page<SafetyArticle> safetyArticle = SafetyArticleManager.findSafetyArticleByTitle(title,pageIndex,pageSize);
    	 return safetyArticle;
     }
	 @RequestMapping(value = "/api/safetyarticle/typelist")
	 public Page<SafetyArticle> findlistByType(@RequestParam("typeid") int typeid,@RequestParam(defaultValue = "0") int pageIndex,@RequestParam(defaultValue = "10") int pageSize) {
		 Page<SafetyArticle> safetyArticle = SafetyArticleManager.findlistByTypeId(typeid,pageIndex,pageSize);
		 return safetyArticle;
     }
	 @RequestMapping(value = "/api/safetyarticle/colidlist")
	 public Page<SafetyArticle> findlistByColId(@RequestParam("colid") int typeid,@RequestParam(defaultValue = "0") int pageIndex,@RequestParam(defaultValue = "10") int pageSize) {
		 Page<SafetyArticle> safetyArticle = SafetyArticleManager.findlistByColId(typeid,pageIndex,pageSize);
		 return safetyArticle;
     }
}
