package com.lazyxu.renamehelp;

import java.io.File;

public class FileUtils {

    /**
     * 检查某个文件是否存在
     */
    public static long count = 0;

    public static void checkAllFileInWithVoice(String path){
        if(path != null && path != ""){
            File dir = new File(path);
            if(dir.exists() && dir.isDirectory()){
                File[] files = dir.listFiles();
                if(files != null && files.length > 0){
                    int count = 0;
                    for(File file : files){
                        if(file.exists() && file.isFile()){
                            String filePath = file.getParentFile().getAbsolutePath();
                            file.renameTo(new File(filePath + File.separator + "article_" + count + ".mp3"));
                        }
                        count ++;
                    }
                }
            }
        }
    }

    public static void checkAllFileInWithArticleImage(String path){
        if(path != null && path != ""){
            File dir = new File(path);
            if(dir.exists() && dir.isDirectory()){
                File[] files = dir.listFiles();
                if(files != null && files.length > 0){
                    for(File file : files){
                        if(file.exists() && file.isFile()){
                            String filePath = file.getParentFile().getAbsolutePath();
                            String fileName = file.getName().replace(" 984乘558", "");
                            fileName = fileName.replace(" 1080乘1926", "");
                            fileName = fileName.replace("-", "_");
                            file.renameTo(new File(filePath + File.separator + "article_image_" + fileName));
                        }
                        count ++;
                    }
                }
            }
        }
    }

    /**
     * 扫描文件夹下面全部文件 -换成_
     * @param path
     */
    public static void checkAllFileInFlold2(String path){
        if(path != null && path != ""){
            File dir = new File(path);
            if(dir.exists() && dir.isDirectory()){
                File[] files = dir.listFiles();
                if(files != null && files.length > 0){
                    for(File file : files){
                        if(file.exists() && file.isFile()){
                            String filePath = file.getParentFile().getAbsolutePath();
                            file.renameTo(new File(filePath + File.separator + file.getName().replace("I", "i")));
                        }
                    }
                }
            }
        }
    }


    /**
     * 根据前缀找文件
     * @param path
     * @param startWith
     */
    public static void checkFile(String path, String startWith){
        if(path != null && path != "") {
            File dir = new File(path);
            if(dir.exists() && dir.isDirectory()){
                File[] files = dir.listFiles();
                if(files != null && files.length > 0){
                    for(File file : files) {
                        if(file.isFile()) {
                            if (file.getName().startsWith(startWith)) {
                                System.out.println("找到文件：" + file.getAbsolutePath());
                            }
                            count ++;
                        } else{
                            checkFile(file.getAbsolutePath(), startWith);
                        }
                    }
                }
            }
        }
    }

    /**
     * 扫描文件夹下面全部文件 添加/替换 前缀
     * @param path
     */
    public static void checkAllFileInFlold(String path){
        if(path != null && path != ""){
            File dir = new File(path);
            if(dir.exists() && dir.isDirectory()){
                File[] files = dir.listFiles();
                if(files != null && files.length > 0){
                    for(File file : files){
                        if(file.exists() && file.isFile()){
                            String filePath = file.getParentFile().getAbsolutePath();
                            String oldPrefix = isReplacePrefix(file);
                            if(oldPrefix != null && oldPrefix != ""){
                                file.renameTo(new File(filePath + File.separator + file.getName().replace(oldPrefix, PrefixPool.prefix)));
                            } else{
                                file.renameTo(new File(filePath + File.separator + PrefixPool.prefix + "_" + file.getName()));
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 是否需要替换前缀，如果不需要，则直接在前面添加前缀，
     * 如果需要，则把老的前缀换成新的
     * @return
     */
    public static String isReplacePrefix(File file){
        String fileName = file.getName();
        if(fileName.contains("_")){
            String oldPrefix = fileName.substring(0, fileName.indexOf("_"));
            System.out.println("老的前缀：" + oldPrefix);
            if(PrefixPool.getPrefixList().contains(oldPrefix)){
                return oldPrefix;
            }
        }
        return null;
    }
}
