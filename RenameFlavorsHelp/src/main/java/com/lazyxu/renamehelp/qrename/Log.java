package com.lazyxu.renamehelp.qrename;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {

	private static final String tag = "-- RenameLog --";

	public static void show(String content) {
		if (content == null || content.isEmpty()) {
			content = getStackTraceInfo("Null Value");
		}
		content = getTimeStamp() + tag + "--ThreadId："
				+ Thread.currentThread().getId() + "--" + content;
		showInUI(content);
		System.out.println(content);
	}

	public static String getStackTraceInfo(String tag) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		RuntimeException here = new RuntimeException(Thread.currentThread()
				.getId() + tag);
		here.fillInStackTrace().printStackTrace(pw);
		pw.close();
		try {
			sw.close();
		} catch (IOException e1) {
		}
		return sw.toString();

	}

	public static void showInThread(String content) {
		content = getTimeStamp() + tag + "--ThreadId："
				+ Thread.currentThread().getId() + "--" + content;
		System.out.println(content);
	}

	public static void showStackTrace(Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		t.printStackTrace(pw);
		pw.close();
		try {
			sw.close();
		} catch (IOException e1) {
			// ignore
		}
		show("异常信息：" + sw.toString());
	}

	private static String getTimeStamp() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss SSS");
		String timaStamp = simpleDateFormat.format(new Date(System
				.currentTimeMillis()));
		return timaStamp;
	}

	private static void showInUI(String content) {
		if (RenameJFrame.logText != null) {
			// 添加文本且滚动到最后一行
			RenameJFrame.logText.append(content+"\n");
			RenameJFrame.logText.selectAll();
			if(RenameJFrame.logText.getSelectedText() != null){
				RenameJFrame.logText.setCaretPosition(RenameJFrame.logText.getSelectedText().length());
			}
			RenameJFrame.logText.requestFocus();
		}
	}
}
