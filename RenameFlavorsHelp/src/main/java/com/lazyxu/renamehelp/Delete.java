package com.lazyxu.renamehelp;

import java.util.HashMap;
import java.util.Map;

/**
 * 传入一个路径，路径下面全部文件名，统一添加，统一换成特定前缀
 */
public class Delete {


    private static String folderPath = "D:\\work\\unified_wifi";//\lib_flavors\src


    public static void main(String[] args) {
//        HashMap<String, String> map = new HashMap<String, String>();
//        map.put("Activity-alias.xml", "test");
//        map.put("agconnect-services.json", "test");
//        map.put("ic_redrain_close.png", "ic_redrain_close11.webp");
//        map.put("light_blue_bg.png", "light_blue_bg11.webp");
//        map.put("bg_home_item1.webp", "light_blue_bg11.webp");
//        map.put("bg_home_item2.webp", "light_blue_bg11.webp");
//        map.put("bg_home_item3.webp", "light_blue_bg11.webp");
//        map.put("bg_home_item4.webp", "light_blue_bg11.webp");
//        map.put("lock.png", "light_blue_bg11.webp");
//        map.put("wifi_lock.png", "light_blue_bg11.webp");
//        map.put("bg_bling.webp", "light_blue_bg11.webp");
//        map.put("bling_bg.webp", "light_blue_bg11.webp");
//        map.put("close_white_bg.png", "light_blue_bg11.webp");
//        map.put("icon_camera.webp", "light_blue_bg11.webp");
//        map.put("feedback_edit_bg.webp", "light_blue_bg11.webp");
//        map.put("home_wifi_fast.webp", "light_blue_bg11.webp");
//        map.put("network_signal.png", "icon_4g.webp");
//        map.put("wifi_home_bg.webp", "icon_4g.webp");
//        map.put("network.png", "test");
//        map.put("mine_menu_next.webp", "test");

        HashMap<String, String> mapwifi = new HashMap<String, String>();
//        mapwifi.put("hlwf_speedometer.png", "11.webp");
//        mapwifi.put("ic_redrain_close.png", "11.png");
//        mapwifi.put("lock.png", "11.png");
//        mapwifi.put("network.png", "11.png");
//        mapwifi.put("wifi_lock.png", "wi_lock.png");
//        mapwifi.put("bg_bling.webp", "bg_bling.webp");
//        mapwifi.put("bling_bg.webp", "bling_bg.webp");
//        mapwifi.put("close_white_bg.png", "close_white_bg.png");
//        mapwifi.put("default_image.webp", "default_image.webp");
//        mapwifi.put("loading_read_webp.webp", "loading_read_webp.webp");
//        mapwifi.put("mine_menu_arrow.webp", "mine_menu_arrow.webp");
//        mapwifi.put("shoes_light_bg.webp", "shoes_light_bg.webp");

        mapwifi.put("light_blue_bg.png", "light_blue_bg.png");
        mapwifi.put("bg_home_item1.webp", "bg_home_item1.webp");
        mapwifi.put("bg_home_item2.webp", "bg_home_item1.webp");
        mapwifi.put("bg_home_item3.webp", "bg_home_item1.webp");
        mapwifi.put("bg_home_item4.webp", "bg_home_item1.webp");
        mapwifi.put("cir_bg.webp", "cir_bg.webp");
        mapwifi.put("cir_top.webp", "cir_top.webp");
        mapwifi.put("feedback_edit_bg.webp", "feedback_edit_bg.webp");
        mapwifi.put("ic_logo_small.webp", "ic_logo_small.webp");
        mapwifi.put("ic_logo_toolbar.webp", "ic_logo_toolbar.webp");
        mapwifi.put("ic_notify_manager2.webp", "ic_notify_manager2.webp");
        mapwifi.put("ic_real_protect2.webp", "ic_real_protect2.webp");
        mapwifi.put("ic_soft_manager2.webp", "ic_soft_manager2.webp");
        mapwifi.put("icon_badge_logo.png", "icon_badge_logo.png");
        mapwifi.put("icon_garbage_not_found.webp", "icon_garbage_not_found.webp");
        mapwifi.put("icon_login.webp", "icon_login.webp");
        mapwifi.put("icon_video_play.png", "icon_video_play.png");

        for (Map.Entry<String, String> entry : mapwifi.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
            boolean hasTargetFile = FileUtils.deleteFileInFolder(folderPath, key);
            System.out.println("是否找到目标文件"+key+"：" + hasTargetFile);
        }
    }
}