package com.lazyxu.renamehelp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * User:Lazy_xu
 * Date:2024/04/24
 * Description:
 * FIXME
 */
public class FileUtils1 {


    private final static String PARENT_ACTIVITY = "StandAcActivity";
    private final static String PARENT_ACTIVITY_FILENAME = "com.bytedance.sdk.ac." + PARENT_ACTIVITY ;


    private static String themeName="EmAcyStyle";



    public static void createDictionaryFile(String name, String packageName, int activityNum, String themeName) {
        String packageNameFile = packageName + ".activity";
        String path = "lib_flavors" + File.separator + "src" + File.separator + name + File.separator + "java" + File.separator + packageNameFile.replace('.', File.separatorChar);
        File directory = new File(path);
        if (!directory.exists()) {
            boolean created = directory.mkdirs();
            if (!created) {
                System.out.println("Failed to create directory.");
                return;
            }
        } else {
            System.out.println("directory has exist");
            return;
        }
        StringBuilder fileNameAll = new StringBuilder();
        StringBuilder androidManifestItmesBuilder=new StringBuilder();

        try {
//            File fileAndroidManifest = new File("lib_flavors" + File.separator + "src" + File.separator + name + File.separator + "java" + File.separator + "AndroidManifest.xml");
            File fileAndroidManifest = new File("lib_flavors" + File.separator + "src" + File.separator + name + File.separator + "AndroidManifest.xml");
            boolean fileAndroidManifestExit = fileAndroidManifest.exists();
            FileWriter writerAndroidManifest = new FileWriter(fileAndroidManifest);
            if (!fileAndroidManifestExit) {
                fileAndroidManifest.mkdirs();
                androidManifestItmesBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<manifest xmlns:android=\"http://schemas.android.com/apk/res/android\">\n" +
                        "    <application>\n")
                        .append("\n\n\n\n");
            }
            String taskAffinity = capitalizeFirstLetter(name);
            // 在文件夹内创建20个文件
            for (int i = 0; i < activityNum; i++) {
                String xxxActivity = generateXxx() + "Activity";
                String fileName = xxxActivity + ".java";
                fileNameAll.append(xxxActivity).append(",");

                File file = new File(directory, fileName);
                file.createNewFile();
                String fileContent = "package " + packageNameFile + ";\n\n" +
                        "import " + PARENT_ACTIVITY_FILENAME + ";\n" +
//                        "import " + packageName + ".R;\n\n" +
                        "import com.ys.peaswalk.R;\n\n" +
                        "public class " + xxxActivity + " extends " + PARENT_ACTIVITY + " {\n\n" +
                        "    @Override\n" +
                        "    public int customTheme() {\n" +
                        "        return R.style." + themeName  + ";\n"+
                        "    }" +
                        "\n\n" +
                        "}\n";

                // 创建文件并写入内容
                FileWriter writerActivity = new FileWriter(file);
                writerActivity.write(fileContent);
                writerActivity.close();


                String androidManifestItme=
                        "        <activity\n" +
                                "            android:name=\"" + packageNameFile + "." + xxxActivity + "\"\n" +
                                "            android:exported=\"true\"\n" +
//                                "            android:theme=\"@style/EmptyAcStyle\"\n" +
                                "            android:taskAffinity=\"" + packageNameFile + "." + taskAffinity + "Activity\"\n" +
                                "            android:windowSoftInputMode=\"adjustResize|stateHidden\" />\n";
                androidManifestItmesBuilder.append(androidManifestItme);
            }
            if (!fileAndroidManifestExit) {
                androidManifestItmesBuilder.append("\n\n\n\n").append("    </application>\n" +
                        "</manifest>");
            }else {
                // 读取 AndroidManifest.xml 文件内容
                BufferedReader reader = new BufferedReader(new FileReader(fileAndroidManifest));
                String line;
                System.out.println("line=11"+reader.readLine() );



                boolean applicationTagFound = false;
                while ((line = reader.readLine()) != null) {
                    System.out.println("line=" + line);
                    androidManifestItmesBuilder.append(line).append("\n");
                    if (line.contains("<application")) {
                        applicationTagFound = true;
                    } else if (line.contains("</application>") && applicationTagFound) {
                        // 在 </application> 标签之前插入新的 activityContent
                        androidManifestItmesBuilder.insert(androidManifestItmesBuilder.length() - "</application>".length(), androidManifestItmesBuilder + "\n");
                        break;
                    }
                }
                reader.close();
            }

            androidManifestItmesBuilder.append("\n\n");
            androidManifestItmesBuilder.append("<!--");
            androidManifestItmesBuilder.append("\n\n");
            androidManifestItmesBuilder.append(appendActivityNames(fileNameAll));
            androidManifestItmesBuilder.append("\n\n");
            androidManifestItmesBuilder.append("-->");

            writerAndroidManifest.write(androidManifestItmesBuilder.toString());
            writerAndroidManifest.close();
        } catch (IOException e) {
            System.out.println("error=" + e);
        }

        createStyle(name, themeName);
    }


    private static void createStyle(String name, String themeName) {
        try {
            String path = "lib_flavors" + File.separator + "src" + File.separator + name + File.separator +  "res" + File.separator + "values" ;
            File directory = new File(path);
            if (!directory.exists()) {
                boolean created = directory.mkdirs();
                if (!created) {
                    System.out.println("Failed to create directory.");
                    return;
                }
            } else {
                System.out.println("directory has exist");
                return;
            }

            boolean isParent = true;
            File styleFile = new File(path , "styles.xml");
            boolean fileStyleExit = styleFile.exists();
            FileWriter writerStyleFile = new FileWriter(styleFile);
            StringBuilder styleBuilder = new StringBuilder();
            if (!fileStyleExit) {
                styleFile.mkdirs();
            }
            styleBuilder.append("<resources>\n");
            styleBuilder.append("\n\n");

            if (isParent) {
                styleBuilder.append("    <style name=" + "\"" + themeName + "\" " + "parent=\"EmptyAcStyle\" />");
            } else {
                styleBuilder.append("    <style name=" + "\"" + themeName + "\" " + "parent=\"android:Theme.Translucent\">\n" +
                        "        <item name=\"android:statusBarColor\">@color/transparent</item>\n" +
                        "        <item name=\"android:windowTranslucentNavigation\">true</item>\n" +
                        "        <item name=\"android:windowIsTranslucent\">true</item>\n" +
                        "        <item name=\"android:windowDisablePreview\">true</item>\n" +
                        "        <item name=\"android:windowBackground\">@color/transparent</item>\n" +
                        "        <item name=\"android:windowAnimationStyle\">@null</item>\n" +
                        "    </style>\n");
            }

            styleBuilder.append("\n\n\n\n");
            styleBuilder.append("\n" + "</resources>");

            writerStyleFile.write(styleBuilder.toString());
            writerStyleFile.close();
        } catch (Exception e) {
            System.out.println("createStyle error=" + e);
        }

    }


    /**
     * 将字符串首字母转大写
     *
     * @param str
     * @return
     */
    private static String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        int length = random.nextInt(2) + 4;
        StringBuilder sb = new StringBuilder();
        sb.append((char) (random.nextInt(26) + 'A')); // 第一个字母为大写字母
        for (int i = 1; i < length; i++) {
            char c = (char) random.nextInt(26); // 生成小写字母或数字
            sb.append((char) (c  + 'a')); // 小写字母
        }
        return sb.toString();
    }

    private static String appendActivityNames(StringBuilder fileNameAll) {
        if (fileNameAll.length() > 0) {
            fileNameAll.deleteCharAt(fileNameAll.length() - 1);
        }
        String s = "SYH_ACTIVITY_NAME=" + "\"" + fileNameAll + "\"";
        System.out.println(s);
        return s;
    }

    static Random random = new Random();
    private static String generateXxx() {
        int length = random.nextInt(7) + 4;
        StringBuilder xxxBuilder = new StringBuilder();
        xxxBuilder.append((char) (random.nextInt(26) + 'A')); // 第一个字母为大写字母
        for (int i = 1; i < length; i++) {
            char c = (char) random.nextInt(26); // 生成小写字母或数字
            xxxBuilder.append((char) (c  + 'a')); // 小写字母
        }
        return xxxBuilder.toString();
    }

}
