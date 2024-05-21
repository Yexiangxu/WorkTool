package com.lazyxu.renamehelp;


/**
 * 传入一个路径，路径下面全部文件名，统一添加，统一换成特定前缀
 */
public class MainUse {


    private static final String name =   "xjwf2";

    private static final String packageName = "com.mx.xunjwf";

    public static void main(String[] args) {
        FileUtils.createDictionaryFile(name,packageName);
    }
}