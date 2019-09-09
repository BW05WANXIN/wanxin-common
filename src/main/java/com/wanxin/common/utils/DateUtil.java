/**
 * 
 */
package com.wanxin.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 926474
 *
 */
public class DateUtil {

	/**
	 * 计算年龄
	 * @param birthday
	 * @return
	 */
	public static int getAge(Date birthday) {
		// 日历类 calendar
		Calendar instance = Calendar.getInstance();
		instance.setTime(birthday);
		
		// 得到出生的年月日
		int birthYear = instance.get(Calendar.YEAR);
		int birthMonth = instance.get(Calendar.MONTH);
		int birthDate = instance.get(Calendar.DAY_OF_MONTH);
		
		// 获取当前的年月日
		instance.setTime(new Date());
		int currentYear = instance.get(Calendar.YEAR);
		int currentMonth = instance.get(Calendar.MONTH);
		int currentDate = instance.get(Calendar.DAY_OF_MONTH);
		
		// 开始计算
		int age = currentYear-birthYear;
		if (currentMonth<birthMonth) {
			age--;
		}else if(currentMonth==birthMonth && currentDate<birthDate) {
			age--;
		}
		
		return age;
		
	}
	
	
	/**
	 * 判断剩余天数
	 * @param futureDate
	 * @return
	 */
	public static int getRemainDatys(Date futureDate) {
		return (int)(futureDate.getTime()-new Date().getTime())/1000/3600/24;
		
	}
	
	
	/**
	 *  判断是否是当天
	 * @param date
	 * @return
	 */
	public static boolean isToday(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd");
		String dateStr=simpleDateFormat.format(date);
		String todayStr = simpleDateFormat.format(new Date());
		return dateStr.equals(todayStr);
	}
	
	
	
	/**
	 * 判断是否是当月
	 * @param date
	 * @return
	 */
	public static boolean isCurrentMonth(Date date) {
		return false;
	}
	
	
	/**
	 * 给定时间对象，初始化到该月初的1日0时0分0秒0毫秒
	 * @param date
	 * @return
	 * @throws ParseException 
	 */
	public static Date getMonthStart(Date date) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
		String format = simpleDateFormat.format(date);
		String monthStart = format + "01 00:00:00";
		simpleDateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		return simpleDateFormat.parse(monthStart);
	}
	
	
	/**
	 * 给定时间对象，初始化到该月初的30日23时59分59秒59毫秒
	 * @param date
	 * @return
	 */
	public static Date getMonthEnd(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.add(Calendar.SECOND, -1);
		return calendar.getTime();
	}
}
