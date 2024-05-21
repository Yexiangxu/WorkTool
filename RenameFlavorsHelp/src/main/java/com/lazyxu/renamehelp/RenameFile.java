package com.lazyxu.renamehelp;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 传入一个路径，路径下面全部文件名，统一添加，统一换成特定前缀
 */
public class RenameFile {


    private static String folderPath = "D:\\work\\unified_clean\\lib_flavors\\src";


    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();

        map.put("com" + File.separator + "zm" + File.separator+"sport_zy", "com"+ File.separator + "songh"+ File.separator + "sh");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
            boolean hasTargetFile = FileUtils.renameFile(folderPath, key,value);
            System.out.println("是否找到目标文件"+key+"：" + hasTargetFile);
        }
    }
}