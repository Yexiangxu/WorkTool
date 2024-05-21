package com.tools.dictionary.creator;

public class Log {

	private static final String TAG = "dc";
	
	public static void show(String msg){
		System.out.println(msg);
	}
	
	public static void showWithTag(String msg){
		System.out.println(TAG + ">> " + msg);
	}
	
	public static void showOneLine(String msg){
		System.out.print(msg);
	}
}
