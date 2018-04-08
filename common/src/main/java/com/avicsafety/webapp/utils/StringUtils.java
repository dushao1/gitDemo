package com.avicsafety.webapp.utils;

public class StringUtils {
	public static String join(String c, String[] array){
		StringBuffer sb = new StringBuffer("");
		for(String s:array){
			if(sb.length()>0) sb.append(c);
			sb.append(s);
		}
		return sb.toString();
	}
	
	public static boolean isBlank(String s){
		if(s==null||s.trim().length()==0){
			return true;
		}else{
			return false;
		}
	}
	
	public static String add(Object... array){
		StringBuffer sb = new StringBuffer("");
		for(Object s:array){
			sb.append(s);
		}
		return sb.toString();
	}
	
	public static boolean sql_inj(String str)
	{
	   String inj_str = "'|and|exec|insert|select|delete|update|count|*|%|chr|mid|master|truncate|char|declare|;|or|-|+|,|script";
	   String[] inj_stra=inj_str.split("\\|");
	   for (int i=0 ; i < inj_stra.length ; i++ )
	   {
	       if (str.toUpperCase().indexOf(inj_stra[i].toUpperCase())>=0)
	       {
	           return true;
	       }
	   }
	   return false;
	}

}
