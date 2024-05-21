package com.lazyxu.renamehelp;

/**
 * 传入一个路径，路径下面全部文件名，统一添加，统一换成特定前缀
 */
public class MyClass {

    //    private static String path = "C:\\Users\\Administrator\\Desktop\\test\\drawable-xxhdpi";
//    private static String path = "F:\\ZMGit\\android-libs\\commonlauncher\\app\\build";
//    private static String path = "F:\\ZMGit\\android-libs\\commonlauncher";
//    private static String path = "F:\\ZMGit\\android-libs\\commonlauncher\\CommonLauncher\\src\\main\\res\\layout";
//    private static String path = "C:\\Users\\Administrator\\Desktop\\圣经素材\\内容\\博客\\圣经首页URL-重命名\\葡语--横竖";
//    private static String path = "C:\\Users\\Administrator\\Desktop\\圣经素材\\内容\\博客\\圣经首页URL-重命名\\英语-横竖";
//    private static String path = "F:\\ZMGit\\android-libs\\lib-realization\\lib_realization\\src\\main\\res\\drawable-xxhdpi";
//    private static String path = "C:\\Users\\Administrator\\Desktop\\圣经素材\\内容\\文章\\文章-英语-json.xls";
//    private static String path = "C:\\Users\\Administrator\\Desktop\\圣经素材\\内容\\文章\\文章-音频-重命名";
    private static String path = "D:\\work\\lib-realization\\lib_realization\\src\\main\\res\\drawable-xxhdpi";

//    private static String path = "C:\\Users\\Administrator\\Desktop\\圣经素材\\内容\\文章\\文章-图片-重命名";

    public static void main(String[] args) {
        FileUtils.checkAllFileInFlold(path);
//        FileUtils.checkAllFileInFlold2(path);
//        ExcelHelper.readExcel(path);
//        FileUtils.checkAllFileInWithArticleImage(path);
//        FileUtils.checkFile(path, "push_small");
//        System.out.println("文件计数：" + FileUtils.count);
    }
}