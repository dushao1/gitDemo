package com.avicsafety.webapp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author shili Last Modifiy : 2010-07-02
 */
public class DateTime {

	public enum Format {
		full, md, mmdd, sfull, yymd, yymmdd, yyyymd, yyyymmdd
	};
	
	
	/**
	 * 判断当前字符串是否为标准时间类型  包含 yyyy-mm-dd hh-MM-SS 和 yyyy-m-d h-M-S
	 * 
	 * @param date
	 *            时间
	 * @param format
	 *            
	 *            
	 * @return
	 */
	public static boolean checkDate(String date) {
		if(date==null||date.length()==0){
			return false;
		}
		String format = "((19|20)[0-9]{2})-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01]) "
				+ "([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]";
		Pattern pattern = Pattern.compile(format);
		Matcher matcher = pattern.matcher(date);
		return matcher.matches();
	}

	/**
	 * 验证时间格式是否正确
	 * 
	 * @param date
	 *            时间
	 * @param format
	 *            时间格式 例如:yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static boolean checkDate(String date, Format f) {
		SimpleDateFormat df = new SimpleDateFormat(getDateTimeFormat(f));
		Date d = null;
		try {
			d = df.parse(date);
		} catch (Exception e) {
			return false;
		}
		String s1 = df.format(d);
		return date.equals(s1);
	}
	
	/**
	 * 返回指定格式的当前时间
	 * 
	 * @param format
	 *            时间日期格式
	 * @return 一个Date类型时间
	 */
	public static Date getDate() {
			return getDate(null);
	}

	/**
	 * 返回指定格式的当前时间
	 * 
	 * @param format
	 *            时间日期格式
	 * @return 一个Date类型时间
	 */
	public static Date getDate(Format f) {
		if (f == null) {
			return new Date();
		} else {
			SimpleDateFormat df = new SimpleDateFormat(getDateTimeFormat(f));
			Date d = new Date();
			try {
				d = df.parse(d.toString());
			} catch (Exception e) {
			}
			return d;
		}
	}

	/**
	 * 给出一个字符串 返回时间类型数据
	 * 
	 * @param f
	 *            枚举时间格式
	 * @param _dateTime
	 *            时间字符串
	 * @return 一个时间日期类型;
	 */
	public static Date getDate(Format f, String _dateTime) {
		Date temp_d;
		SimpleDateFormat df = new SimpleDateFormat(getDateTimeFormat(f));
		try {
			temp_d = df.parse(_dateTime);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
			temp_d = null;
		}
		return temp_d;
	}

	/**
	 * 对枚举类型进行格式转换
	 * 
	 * @param f
	 * @return
	 */
	private static String getDateTimeFormat(Format f) {
		if (f.equals(Format.full)) {
			return "yyyy-MM-dd HH:mm:ss";
		}

		if (f.equals(Format.sfull)) {
			return "yyyy-M-d H:m:s";
		}

		if (f.equals(Format.yyyymmdd)) {
			return "yyyy-MM-dd";
		}

		if (f.equals(Format.yyyymd)) {
			return "yyyy-M-d";
		}

		if (f.equals(Format.yymmdd)) {
			return "yy-MM-dd";
		}

		if (f.equals(Format.yymd)) {
			return "yy-M-d";
		}

		if (f.equals(Format.mmdd)) {
			return "MM-dd";
		}

		if (f.equals(Format.md)) {
			return "M-d";
		}

		return "";
	}

	/**
	 * 获取当前时间的日期
	 * 
	 * @return
	 */
	public static int getDay() {
		Calendar c = Calendar.getInstance();
		return c.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获取一个时间日期的日期
	 * 
	 * @param date
	 *            一个时间
	 * @return
	 */
	public static int getDay(Date date) {

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 通过年和月来获取当月有多少天
	 * 
	 * @param _year
	 *            给定的年份四位 如2002
	 * @param _month
	 *            给定的年份 如3
	 * @return 返回一个整形
	 */
	public static int getDayCountByMonth(int _year, int _month) {
		int monthDay[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if ((_year % 4 == 0 && _year % 100 != 0) || _year % 400 == 0)
			monthDay[1]++;
		return monthDay[_month - 1];
	}

	/**
	 * 获取当前时间的小时数
	 * 
	 * @return 小时数
	 */
	public static int getHour() {
		Calendar c = Calendar.getInstance();
		// int a = c.get(Calendar.HOUR_OF_DAY);
		return c.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 获取一个时间日期的小时数
	 * 
	 * @param date
	 *            一个时间
	 * @return 小时数
	 */
	public static int getHour(Date date) {

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 获取当前时间的豪秒数
	 * 
	 * @return 豪秒数
	 */
	public static int getMillisecond() {
		Calendar c = Calendar.getInstance();
		// int a = c.get(Calendar.HOUR_OF_DAY);
		return c.get(Calendar.MILLISECOND);
	}

	/**
	 * 获取当前时间的分钟数
	 * 
	 * @return 分钟数
	 */
	public static int getMinute() {
		Calendar c = Calendar.getInstance();
		// int a = c.get(Calendar.HOUR_OF_DAY);
		return c.get(Calendar.MINUTE);
	}

	/**
	 * 获取当前时间的月份
	 * 
	 * @return
	 */
	public static int getMonth() {
		Calendar c = Calendar.getInstance();
		c.setTime(getDate(Format.full));
		return c.get(Calendar.MONTH) + 1;
	}

	/**
	 * 获取一个时间日期的月份
	 * 
	 * @param date
	 *            一个时间
	 * @return
	 */
	public static int getMonth(Date date) {

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MONTH) + 1;
	}

	/**
	 * 获取当前时间的秒数
	 * 
	 * @return 秒数
	 */
	public static int getSecond() {
		Calendar c = Calendar.getInstance();
		// int a = c.get(Calendar.HOUR_OF_DAY);
		return c.get(Calendar.SECOND);
	}
	
	
	/**
	 * 返回一个给定的[时间]的字符串
	 * 
	 * @param DateTime
	 *            .Format.full 枚举时间格式
	 * @return 时间字符串 例:2010-03-01 1-2-3
	 */
	public static String getStrDate(Format f) {
		SimpleDateFormat df = new SimpleDateFormat(getDateTimeFormat(f));
		return df.format(getDate());
	}

	/**
	 * 返回一个给定的[时间]的字符串
	 * 
	 * @param DateTime
	 *            .Format.full 枚举时间格式
	 * @param _datetime
	 *            相关时间
	 * @return 时间字符串 例:2010-03-01
	 */
	public static String getStrDate(Format f, Date _datetime) {
		SimpleDateFormat df = new SimpleDateFormat(getDateTimeFormat(f));
		return df.format(_datetime);
	}

	/**
	 * 返回一个给定的[时间]的字符串
	 * 
	 * @param DateTime
	 *            .Format.full 输出的格式
	 * @param DateTime
	 *            .Format.full 输入的格式
	 * @param _datetime
	 *            相关时间字符串
	 * @return 时间字符串 如果转换出错 则返回""空字符串
	 */
	public static String getStrDate(Format f, Format sourcef, String _datetime) {
		SimpleDateFormat df = new SimpleDateFormat(getDateTimeFormat(sourcef));
		SimpleDateFormat df2 = new SimpleDateFormat(getDateTimeFormat(f));
		String _dateTime = "";

		Date _date = null;
		_date = getDate(sourcef, _datetime);

		return df2.format(_date);
	}

	/**
	 * 返回一个给定的[时间间隔]的字符串
	 * 
	 * @param DateTime
	 *            .Format.full 枚举时间格式
	 * @param Interval
	 *            间隔的天数 1为明天
	 * @return 时间字符串 例:2010-03-01
	 */
	public static String getStrDate(Format f, int Interval) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, Interval);
		SimpleDateFormat df = new SimpleDateFormat(getDateTimeFormat(f));
		return df.format(c.getTime());
	}

	/**
	 * 返回从 时间d1 到 时间d2 相差的秒数
	 * 
	 * @param d1
	 *            开始时间
	 * @param d2
	 *            结束时间
	 * @return
	 */
	public static int getTimeDiff(Date d1, Date d2) {
		long _diff = d2.getTime() - d1.getTime();
		int _temp = Math.round(_diff / 1000);
		return _temp;
	}

	/**
	 * 返回从 时间d1 到 时间d2 相差的秒数
	 * 
	 * @param d1
	 *            开始时间字符串 2010-01-01 01:02:33
	 * @param d2
	 *            结束时间字符串 2010-02-01 01:02:33
	 * @return 返回秒数 格式有错误则返回-1;
	 */
	public static int getTimeDiff(String d1, String d2) {
		int _temp = 0;
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date _d1 = df.parse(d1);
			Date _d2 = df.parse(d2);
			long _diff = _d2.getTime() - _d1.getTime();
			_temp = Math.round(_diff / 1000);
		} catch (java.text.ParseException e) {
			_temp = -1;
			e.printStackTrace();

		}
		return _temp;
	}

	/**
	 * 获取当前时间的年份
	 * 
	 * @return
	 */
	public static int getYear() {
		Calendar c = Calendar.getInstance();
		c.setTime(getDate(Format.full));
		return c.get(Calendar.YEAR);
	}

	/**
	 * 获取一个给定的时间日期的年份
	 * 
	 * @param date
	 *            一个时间
	 * @return
	 */
	public static int getYear(Date date) {

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.YEAR);
	}
	/**
	 * 获得一个f格式的当前时间的字符串
	 * 
	 * @param f 
	 * @return
	 */
	public static String getNowDate(Format f) {
		SimpleDateFormat df = new SimpleDateFormat(getDateTimeFormat(f));
		return df.format(getDate(f));
	}
	/**
	 * 	// string类型转换为date类型
 	// strTime要转换的string类型的时间，formatType要转换的格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日
 	// HH时mm分ss秒，
 	// strTime的时间格式必须要与formatType的时间格式相同
	 * @param strTime
	 * @param f
	 * @return
	 * @throws ParseException
	 */
 	public static Date stringToDate(String strTime, Format f) throws ParseException
 			 {
 		SimpleDateFormat formatter = new SimpleDateFormat(getDateTimeFormat(f));
 		Date date = null;
 		date = formatter.parse(strTime);
 		return date;
 	}
	 	
 // 
  	/**
  	 * String类型转换为long类型
  	 * @param strTime
  	 * 时间字符串
  	 * @param f
  	 * 时间类型格式
  	 * @return
  	 */
 	public static long stringToLong(String strTime, Format f) throws ParseException 
 			 {
 		Date date = stringToDate(strTime, f); // String类型转成date类型
 		if (date == null) {
 			return 0;
 		} else {
 			long currentTime = dateToLong(date); // date类型转成long类型
 			return currentTime;
 		}
 	}
	 	
	// 
 	/**
 	 * date类型转换为long类型
 	 * @param date
 	 * 日期型时间类型
 	 * @return
 	 */
 	public static long dateToLong(Date date) {
 		return date.getTime();
 	}
 	
 	
// 	//获得本周一 00:00:00
// 	public  static Date getMondayDayOfWeek(Date date){
//   	 Calendar calendar = Calendar.getInstance();
//	        calendar.setTime(date);
//	        calendar.set(Calendar.HOUR_OF_DAY, 0);
//	        calendar.set(Calendar.MINUTE, 0);
//	        calendar.set(Calendar.SECOND, 0);
//	        calendar.set(Calendar.MILLISECOND, 0);
//	        calendar.setFirstDayOfWeek(Calendar.MONDAY);
////	        calendar.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
//	        
//	        int week = calendar.get(Calendar.DAY_OF_WEEK);
//	        calendar.add(Calendar.DAY_OF_WEEK, 1 - week);
//			return calendar.getTime();
//
//	        
//   }
// 	//获得本周天 23:59:59
//   public  static Date getSunDayOfWeek(Date date){
//   	 Calendar calendar = Calendar.getInstance();
//	        calendar.setTime(date);
//	        calendar.set(Calendar.HOUR_OF_DAY, 23);
//	        calendar.set(Calendar.MINUTE, 59);
//	        calendar.set(Calendar.SECOND, 59);
//	        calendar.set(Calendar.MILLISECOND,0);
//	        calendar.setFirstDayOfWeek(Calendar.MONDAY);
//	        calendar.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
//	       
//	        return calendar.getTime();
//	        
//   }
   
   public static String longToString(long millis, Format f) {
	   Calendar cal = Calendar.getInstance();
	   cal.setTimeInMillis(millis);
	   SimpleDateFormat df = new SimpleDateFormat(getDateTimeFormat(f));
		return df.format(cal.getTime());
   }
   
   
   /**
    * 得到本周周一
    * 
    * @return yyyy-MM-dd
    */
   public static Date getMondayDayOfWeek() {
    Calendar c = Calendar.getInstance();
    int dayofweek = c.get(Calendar.DAY_OF_WEEK) - 1;
    if (dayofweek == 0)
     dayofweek = 7;
    c.add(Calendar.DATE, -dayofweek + 1);
    c.set(Calendar.HOUR_OF_DAY, 0);
    c.set(Calendar.MINUTE, 0);
    c.set(Calendar.SECOND, 0);
    c.set(Calendar.MILLISECOND, 0);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    return c.getTime();
   }
 	
   /**
    *得到本周周日 
    * @return yyyy-MM-dd
    */
   public static Date getSunDayOfWeek() {
    Calendar c = Calendar.getInstance();
    int dayofweek = c.get(Calendar.DAY_OF_WEEK) - 1;
    if (dayofweek == 0)
     dayofweek = 7;
    c.add(Calendar.DATE, -dayofweek + 7);
    c.set(Calendar.HOUR_OF_DAY, 23);
    c.set(Calendar.MINUTE, 59);
    c.set(Calendar.SECOND, 59);
    c.set(Calendar.MILLISECOND,0);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    return c.getTime();
   }
   
   /**
    *得到一个字符串 时间固定 + 随机
    * @return yyyy-MM-dd
    */
   public static String getFullStringByTime() {
	   String format = "yyyyMMddHHmmss";
       Date date = new Date();
       date.setTime(System.currentTimeMillis());
       SimpleDateFormat sdf = new SimpleDateFormat(format);
       return sdf.format(date)+new Random().nextInt(1000);
   }
}
