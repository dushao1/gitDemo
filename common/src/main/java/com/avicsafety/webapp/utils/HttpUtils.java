package com.avicsafety.webapp.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public final class HttpUtils {  
	

	
	public static String AuthHttpPost(String url) {
		RequestConfig config = RequestConfig.custom().setConnectTimeout(60000).setSocketTimeout(15000).build();
	    CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
	        
		String result = "";
        HttpPost httpPost = new HttpPost(url);       // 拼接参数
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        //list.add(new BasicNameValuePair("grant_type", "password"));
        System.out.println("==== 提交参数 ======" + list);
        CloseableHttpResponse response = null;
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(list));
            response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                httpPost.abort();
                result = "{'error':'invalid_grant'}";
                //throw new RuntimeException("HttpClient,error status code :" + statusCode);

            }else {
            	System.out.println("========HttpResponseProxy：========" + statusCode);
                HttpEntity entity = response.getEntity();
                
                if (entity != null) {
                    result = EntityUtils.toString(entity, "UTF-8");
                    System.out.println("========接口返回=======" + result);
                }
                EntityUtils.consume(entity);
            }
   
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;  
	}
	

	

  
}