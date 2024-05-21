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
public class FileUtils {
//    private static String importPath="com.bytedance.sdk.ss.stub.MLandActivity";//商业化   590
//    private static String activityName="MLandActivity";

//    private static String importPath="com.bytedance.sdk.no.StandActivity";//商业化 5.9.2  商业化 5.9.4
//    private static String activityName="StandActivity";
//    private static String themeName="EmOqyStyle";

//    private static String importPath="com.bytedance.sdk.wy.StandWyActivity";//商业化 5.9.2  商业化 5.9.4
//    private static String activityName="StandWyActivity";
//    private static String themeName="EmWyyStyle";

//    private static String importPath="com.bytedance.sdk.wy.StandWyActivity";//商业化 5.9.7
//    private static String activityName="StandWyActivity";
//    private static String themeName="EmWyyStyle";

//    private static String importPath="com.bytedance.sdk.ik.StandIkActivity";//商业化 603
//    private static String activityName="StandIkActivity";
//    private static String themeName="EmIkyStyle";


    private static String importPath="com.bytedance.sdk.uw.StandUwActivity";//商业化 609
    private static String activityName="StandUwActivity";
    private static String themeName="EmUwyStyle";






    public static void createDictionaryFile(String name, String packageName) {
        String path = "lib_flavors" + File.separator + "src" + File.separator + name + File.separator + "java" + File.separator + packageName.replace('.', File.separatorChar)+ File.separator + "activity";
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
//            File fileAndroidManifest = new File("D:\\worktools\\MyTest\\AndroidManifest.xml");
            File fileAndroidManifest = new File("lib_flavors" + File.separator + "src" + File.separator + name + File.separator + "java" + File.separator + "AndroidManifest.xml");
            boolean fileAndroidManifestExit = fileAndroidManifest.exists();
            FileWriter writerAndroidManifest = new FileWriter(fileAndroidManifest);
            if (!fileAndroidManifestExit) {
                fileAndroidManifest.mkdirs();
                androidManifestItmesBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<manifest xmlns:android=\"http://schemas.android.com/apk/res/android\">\n" +
                        "    <application>\n");
            }
            // 在文件夹内创建20个文件
            for (int i = 0; i < 50; i++) {
                String xxxActivity = generateXxx() + "Activity";
                String fileName = xxxActivity + ".java";
                fileNameAll.append(xxxActivity).append(",");

                File file = new File(directory, fileName);
                file.createNewFile();
                String fileContent = "package " + packageName + ".activity;\n\n" +
                        "import "+importPath+";\n\n" +
                        "public class " + xxxActivity + " extends "+activityName+" {\n\n" +
                        "}\n";

                // 创建文件并写入内容
                FileWriter writerActivity = new FileWriter(file);
                writerActivity.write(fileContent);
                writerActivity.close();


                String androidManifestItme=
                        "        <activity\n" +
                                "            android:name=\"" + packageName + ".activity." + xxxActivity + "\"\n" +
                                "            android:exported=\"true\"\n" +
                                "            android:theme=\"@style/"+themeName+"\"\n" +
                                "            android:taskAffinity=\"" + packageName + ".activity." + capitalizeFirstLetter(name) + "Activity\"\n" +
                                "            android:windowSoftInputMode=\"adjustResize|stateHidden\" />\n";
                androidManifestItmesBuilder.append(androidManifestItme);
            }
            if (!fileAndroidManifestExit) {
                androidManifestItmesBuilder.append("    </application>\n" +
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
            writerAndroidManifest.write(androidManifestItmesBuilder.toString());
            writerAndroidManifest.close();
            printActivityNames(fileNameAll);
        } catch (IOException e) {
            System.out.println("error=" + e);
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
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private static void printActivityNames(StringBuilder fileNameAll) {
        if (fileNameAll.length() > 0) {
            fileNameAll.deleteCharAt(fileNameAll.length() - 1);
        }
        System.out.println("SYH_ACTIVITY_NAME=" + "\"" + fileNameAll + "\"");
    }

    private static String generateXxx() {
        Random random = new Random();
        int length = random.nextInt(4) + 4;
        StringBuilder xxxBuilder = new StringBuilder();
        xxxBuilder.append((char) (random.nextInt(26) + 'A')); // 第一个字母为大写字母
        for (int i = 1; i < length; i++) {
            char c = (char) random.nextInt(36); // 生成小写字母或数字
            if (c < 10) {
                xxxBuilder.append((char) (c + '0')); // 数字
            } else {
                xxxBuilder.append((char) (c - 10 + 'a')); // 小写字母
            }
        }
        return xxxBuilder.toString();
    }

}
