package com.tools.dictionary.creator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {

	private static DateUtils dateUtils;
	private int MIN_CLICK_TIME = 0;
	private long lastClickTime;

	public static synchronized DateUtils getInstance(){
		if(dateUtils == null){
			dateUtils = new DateUtils();
		}
		return dateUtils;
	}

	public static boolean isTimeOut(){
		return true;
	}

	public static String getDate(){
		return longToDate(System.currentTimeMillis());
	}

	/**
	 * 判断一个时间戳是否是今天
	 * @return
	 */
	public static boolean isToDay(long s){
		String toDayString = stampToDate(System.currentTimeMillis());
		if(toDayString.equals(stampToDate(s))){
			return true;
		}
		return false;
	}

	/**
	 * 判断一个时间是否是今天(格式为：MM-dd的时间)
	 * @return
	 */
	public static boolean dateIsToDay(String s){
		String toDayString = stampToDate(System.currentTimeMillis());
		if(toDayString.equals(s)){
			return true;
		}
		return false;
	}

	/**
	 * 判断一个时间戳是否是昨天
	 * @return bool
	 */
	public static boolean isYesterday(long timestamp) {
		Calendar c = Calendar.getInstance();
		clearCalendar(c, Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND, Calendar.MILLISECOND);
		c.add(Calendar.DAY_OF_MONTH, -1);
		long firstOfDay = c.getTimeInMillis(); // 昨天最早时间
		c.setTimeInMillis(timestamp);
		clearCalendar(c, Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND, Calendar.MILLISECOND); // 指定时间戳当天最早时间
		return firstOfDay == c.getTimeInMillis();
	}

	private static void clearCalendar(Calendar c, int... fields) {
		for (int f : fields) {
			c.set(f, 0);
		}
	}

	/**
	 * 时间戳转成"mm-dd"
	 * @return String
	 */
	public static String stampToDate(long lt){
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(lt);
		res = simpleDateFormat.format(date);
		return res;
	}

	/**
	 * 时间戳转成"yyyy-MM-dd hh:mm"
	 * @return String
	 */
	public static String longToDate(long time){
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(time);
		res = simpleDateFormat.format(date);
		return res;
	}

	/**
	 * 时间戳转成"yyyy-MM-dd hh:mm"
	 * @return String
	 */
	public static String longToDateL(long time){
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		Date date = new Date(time);
		res = simpleDateFormat.format(date);
		return res;
	}

	public static String longToDateYMD(long time){
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(time);
		res = simpleDateFormat.format(date);
		return res;
	}

	/**
	 * 传一个时间戳转成MM-dd，判断是否是昨天
	 * @return bool
	 */
	public static boolean isSameYesterday(String dateMMDD){
		long yesterdayTime = System.currentTimeMillis() - 86400000;
		if(yesterdayTime > 0){
			if(dateMMDD.equals(stampToDate(yesterdayTime))){
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断两个时间戳是否是同一天
	 * @return bool
	 */
	public static boolean isSameDay(long stamp, long stamp2){
		if(stampToDate(stamp).equals(stampToDate(stamp2))){
			return true;
		}
		return false;
	}

	/**
	 * 获取当前时间的int数组：年，月，日，小时，分钟，秒，毫秒
	 * @return
	 */
	public static ArrayList<Integer> getDateDetails(){
		Calendar c = Calendar.getInstance();
		c.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		int millisecond = c.get(Calendar.MILLISECOND);
		ArrayList<Integer> timeList = new ArrayList<Integer>();
		timeList.add(year);
		timeList.add(month);
		timeList.add(day);
		timeList.add(hour);
		timeList.add(minute);
		timeList.add(second);
		timeList.add(millisecond);
		Log.show("时间详情：" + timeList);
		return timeList;
	}

	/**
	 * 是否短时间内点击同一个地方
	 * @param minTime 限制的时间差（毫秒）
	 * @return bool 返回true为在限制的时间内点击了多次
	 */
	public boolean isShortTimeToClick(int minTime){
		MIN_CLICK_TIME = minTime;
		long nowTime = System.currentTimeMillis();
		if(nowTime - lastClickTime >= MIN_CLICK_TIME){
			lastClickTime = nowTime;
			return false;
		}
		return true;
	}
}

