package com.lazyxu.renamehelp;


/**
 * 传入一个路径，路径下面全部文件名，统一添加，统一换成特定前缀
 */
public class MainUse1 {


    private static final String name =   "lldc";

    private static final String packageName = "com.yls.linglandc";

    public static void main(String[] args) {
        FileUtils1.createDictionaryFile(name,packageName,50,"EmptyAcStyle");
    }
}