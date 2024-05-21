package com.tools.dictionary.creator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ProguardDictionary {


	public static void main(String[] args){
		ProguardDictionary.createDictionaryFile();
	}

	//每个代理包都需要把这个前缀改成自己独有的
	//商业化:syh
//	public static final String prefix = "bkhlc";

//	public static final String prefix = "king_qmck_audit";
//	public static final String prefix = "llch";

//	public static final String prefix = "test0Oo";
//	public static final String prefix = "gpc";
//	public static final String prefix = "syh";
//	public static final String prefix = "bkhl";

	//播放：psk  录制：rsk  二维码:qsk  控制器：ctr
//	public static final String prefix = "psk";
//	public static final String prefix = "rsk";
//	public static final String prefix = "qsk";
//	public static final String prefix = "ctr";
//	public static final String prefix = "imt";

//	public static final String prefix = "cnyd";
//	public static final String prefix = "hhk";

	//deviceUtils
//	public static final String prefix = "deut";

	//b68
//	public static final String prefix = "bse";
	//新版动态加载SDK
//	public static final String prefix = "nyc";


//	public static final String prefix = "pwh";//hw-hwp003（You Wallpaper）
//	public static final String prefix = ".,hjb";//hw-HJB005（Energy Steps）
//	public static final String prefix = ".,wpb";//hw-HJB005（Energy Steps）
//	public static final String prefix = "qcrc.,";//hw-HSC008（Energy Steps）
//	public static final String prefix = "qpsg";//hw-HSC009（Energy Steps）
	public static final String prefix = "dddl";//hw-HSC010（Energy Steps）

	public static final boolean isApp = false;


	public static final int version = 1;
// prefix + "_packageDictionary.txt";
	private static final String packageFileName =  "packageDictionary.txt"; //建议生成500个三个字符的字符串
	private static final String classFileName = "classDictionary.txt"; //建议生成500个四个字符的字符串
	private static final String methodFileName =  "methodDictionary.txt"; //建议生成5000个五个字符的字符串（包括方法、常量以及变量）

	private static final int packageCount = isApp ? 1000 : 500;
	private static final int classCount = isApp ? 3000 : 1000;
	private static final int methodCount = 5000;

	private static final String path = "./dictionary";//C:\Users\admin\Desktop\混淆操作目录\混淆文件生成

	//普通方式
	private static final String KEY = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final Object[] packageNums = new Object[]{packageFileName, packageCount, 5};
	private static final Object[] classNums = new Object[]{classFileName, classCount, 6};
	private static final Object[] methodNums = new Object[]{methodFileName, methodCount, 7};

	//0Oo方式
//	private static final String KEY = "0Oo";
//	private static final Object[] packageNums = new Object[]{packageFileName, packageCount, 8};
//	private static final Object[] classNums = new Object[]{classFileName, classCount, 15};
//	private static final Object[] methodNums = new Object[]{methodFileName, methodCount, 20};

	private static ArrayList<String> results = new ArrayList<String>();

	public static void createDictionaryFile(){
		new Thread(){
			@Override
			public void run() {
				createDictionaryFile(packageNums);
				createDictionaryFile(classNums);
				createDictionaryFile(methodNums);
				System.out.println("文件生成完毕，输出日志：" + path);
			}
		}.start();
	}

	public static void createDictionaryFile(final Object[] obj){
		int count = 0;
		String fileNameString = "";
		while (count < (Integer)obj[1]) {
			String date = DateUtils.longToDateL(System.currentTimeMillis());
			fileNameString = date.substring(0, 4) + "年/" + date.substring(5, 7) + "月/" + prefix + "/" + version + "/" + obj[0];
			String rdString = "";
			while(true){
				rdString = createDictionaryChar(obj);
				if(rdString != null && !rdString.isEmpty()){
					break;
				}
			}
//			saveLogToCache(path, fileNameString, getTopString() + rdString);
			saveLogToCache(path, fileNameString, prefix + rdString);
			count ++;
		}
	}

	private static String getTopString(){
		String string = "";
		for(int i=0; i<3; i++){
			String [] a = new String[]{"0", "O", "o", "Q", "q"};
			string += a[new Random().nextInt(a.length)];
		}
		return string;
	}

	/**
	 * 写本地数据文件(此方法不能使用Log日志打印，会造成死循环)
	 * @param name
	 * @param content
	 * @throws Exception
	 */
	public static void saveLogToCache(String path, String name, String content){
		FileOutputStream outStream = null;
		try {
			if(name == null || name.isEmpty()) {
				String date = DateUtils.longToDateYMD(System.currentTimeMillis());
				name = date.substring(0, 4) + "年/" + date.substring(5, 7) + "月/" + date + "-log.txt";
			}
			//存储到C:\CCPC\date-log.txt
			File file = new File(path, name);
			File parenFile = file.getParentFile();
			if(!parenFile.exists()){
				parenFile.mkdirs();
			}
			if (!file.exists()) {
				file.createNewFile();
			}
			outStream = new FileOutputStream(file, true);
			//写入文件
			outStream.write((content + "\n").getBytes());
			outStream.flush();
			outStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				outStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static String createDictionaryChar(Object[] obj){
		String result = "";
		List<Character> lsit = upSet();
		for(int i = (Integer)obj[2]; i > 0; i--){
			result += lsit.get(i);
		}
		if(result.isEmpty() || result.length() != (Integer)obj[2] || results.contains(result)){
			return "";
		}
		results.add(result);
		System.out.println("对比个数：" + results.size());
//		System.out.println(results.size() + "正常字段：" + result);
		return result;
	}

	private static List<Character> upSet() {
		char[] c = KEY.toCharArray();
		List<Character> lst = new ArrayList<Character>();
		for (int i = 0; i < c.length; i++) {
			lst.add(c[i]);
		}
		Collections.shuffle(lst);
//        System.out.println(lst);
		return lst;
	}
}
