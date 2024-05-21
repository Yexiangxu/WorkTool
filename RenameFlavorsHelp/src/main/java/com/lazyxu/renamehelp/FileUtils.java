package com.lazyxu.renamehelp;

import com.lazyxu.renamehelp.qrename.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {
    /**
     * txt中内容 替换
     * @param folderPath
     * @param before
     * @param after
     */
    public static void replaceTextInFile(String folderPath, String before, String after) {
        File folder = new File(folderPath);
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (!isExcludedFolder(file)) {
                        if (file.isDirectory()) {
                            // 递归调用替换函数
                            replaceTextInFile(file.getAbsolutePath(),before,after);
                        } else {
                            // 替换文件内容
                            replaceTextInFile(file,before,after);
                        }
                    }else {
//                        Log.show("过滤掉 "+file);
                    }
                }
            }
        } else {
            Log.show("指定路径不是一个有效的文件夹。");
        }
    }
    private static boolean isExcludedFolder(File folder) {
        String folderName = folder.getName();
        return folderName.startsWith(".") || folderName.equals("gradle");
    }
    private static void replaceTextInFile(File file,String before,String after) {
        try {
            // 读取文件内容
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder content = new StringBuilder();
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                if (line.contains(before)) {
                    found = true;
                    line = line.replaceAll(before, after);
                }
                content.append(line).append(System.lineSeparator());
            }
            reader.close();
            // 如果找到了 才替换文件内容
            if (found) {
                Log.show("找到了file="+file+" 替换前="+before+" ,替换后="+after);
                // 写入替换后的内容到文件
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write(content.toString());
                writer.close();
            }
        } catch (IOException e) {
            Log.show("发生IO异常: " + e.getMessage());
        }
    }
    /**
     * 文件名 重命名
     * @param folderPath
     * @param targetFileName
     * @param newName
     * @return
     */
    public static boolean renameFileTxt(String folderPath, String targetFileName, String newName) {
        File folder = new File(folderPath);
        if (!folder.isDirectory()) {
            Log.show("给定的路径不是一个文件夹");
            return false;
        }
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    if (renameFileTxt(file.getAbsolutePath(), targetFileName, newName)) {
                        return true;
                    }
                } else {
                    if (file.getName().equals(targetFileName)) {
                        Log.show("找到了要重命名的文件 filepath=" + file.getAbsolutePath()+",newName="+newName);
                        file.renameTo(new File(file.getParent(), newName));
                    }
                }
            }
        }
        return false;
    }










    public static boolean renameFile(String folderPath, String targetFileName, String newName) {
        File folder = new File(folderPath);
        if (!folder.isDirectory()) {
            System.out.println("给定的路径不是一个文件夹");
            return false;
        }
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    if (file.getAbsolutePath().contains(targetFileName)){
                        System.out.println("oldfile="+file.getAbsolutePath());
                        File newfilename=new File(file.getParentFile().getParentFile().getParentFile().getAbsolutePath()+ File.separator +newName);
                        file.renameTo(newfilename);
                        System.out.println("newfile="+newfilename);
                        if (file.renameTo(newfilename)){
                            System.out.println("Folder renamed successfully");
                        }else {
                            System.out.println("Failed to rename folder");
                        }
                        continue;
                    }
                    renameFile(file.getAbsolutePath(), targetFileName, newName);
                } else {
//                    System.out.println("该文件夹到底了");
                }
            }
        }
        return false;
    }

    public static boolean renameTxtInFolder(String folderPath, String targetFileName, String newName) {
        File folder = new File(folderPath);
        if (!folder.isDirectory()) {
            System.out.println("给定的路径不是一个文件夹");
            return false;
        }
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    if (renameTxtInFolder(file.getAbsolutePath(), targetFileName, newName)) {
                        return true;
                    }
                } else {
                    if (file.getName().equals(targetFileName)) {
                        System.out.println("filepath=" + file.getAbsolutePath());
                        file.renameTo(new File(file.getParent(), newName));
                        continue;
                    }
                }
            }
        }
        return false;
    }
    public static boolean deleteFileInFolder(String folderPath, String targetFileName) {
        File folder = new File(folderPath);
        if (!folder.isDirectory()) {
            System.out.println("给定的路径不是一个文件夹");
            return false;
        }
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    if (deleteFileInFolder(file.getAbsolutePath(), targetFileName)) {
                        return true;
                    }
                } else {
                    if (file.getName().equals(targetFileName)) {
                        System.out.println("filepath=" + file.getAbsolutePath());
                        file.delete();
                        continue;
                    }
                }
            }
        }
        return false;
    }

}
