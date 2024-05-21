package com.lazyxu.renamehelp;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class PrefixPool {

    public static String prefix1 = "raa";
    public static String prefix2 = "xyz";
    public static String prefix3 = "123";
    private static String prefix4 = "456";
    private static String prefix5 = "abc";
    private static String prefix6 = "rbb";
    private static String prefix7 = "rcc";
    private static String prefix8 = "rdd";
//    public static String prefix = "lll";
//    public static String prefix = "pt";
//    public static String prefix = "en";
    public static String prefix = "rff";

    public static ArrayList<String> getPrefixList(){
        ArrayList<String> list = new ArrayList<>();
        Field[] fields = PrefixPool.class.getDeclaredFields();
        if(fields != null && fields.length > 0){
            for(Field field : fields){
                try {
                    list.add(String.valueOf(field.get(null)));
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("使用过的前缀列表：" + list);
        return list;
    }
}
