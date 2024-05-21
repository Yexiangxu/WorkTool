package com.lazyxu.renamehelp.qrename;

import com.lazyxu.renamehelp.FileUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * User:Lazy_xu
 * Date:2024/05/21
 * Description:
 * FIXME
 */
public class QRenameUtils {
    public static void renameBack(String folderPath) {
        HashMap<String, String> mapContent = new HashMap<String, String>();
        mapContent.put("com.songh.clean", "com.ys.peaswalk");
        mapContent.put("com.songh.common", "com.zm.module");
        mapContent.put("com.songh.module", "com.zm.common");
        mapContent.put("anim_loading", "loading_rotate");

        mapContent.put("tab_title", "tab_name");
        mapContent.put("sh_tab_icon", "king_tab_icon");
        mapContent.put("sh_selector_menu1", "hw_menu1");
        mapContent.put("sh_selector_menu2", "hw_menu2");
        mapContent.put("sh_selector_menu3", "hw_menu3");
        mapContent.put("sh_selector_menu4", "hw_menu4");
        mapContent.put("sh_fragment_name", "king_fragment_name");
        mapContent.put("sh_svg_about_us", "svg_hw_about_us");
        mapContent.put("sh_svg_clear_cache", "svg_hw_clear_cache");
        mapContent.put("sh_svg_contact_us", "svg_hw_contact_us");
        mapContent.put("@drawable/menu_next", "@drawable/mine_menu_next");
        mapContent.put("shape_mine_user_bg", "shape_user_head");
        for (Map.Entry<String, String> entry : mapContent.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            Log.show("查找需要替换的txt内容，替换前: " + key + ", 替换后: " + value);
            FileUtils.replaceTextInFile(folderPath, key, value);
        }

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("selector_tab_color.xml", "sh_selector_tab_color.xml");
        map.put("hw_group_bk.xml", "sh_shape_nav_bg.xml");
        map.put("shape_circle_7dp.xml", "sh_shape_white_7dp.xml");
        map.put("svg_hw_about_us.xml", "sh_svg_about_us.xml");
        map.put("svg_hw_clear_cache.xml", "sh_svg_clear_cache.xml");
        map.put("svg_hw_contact_us.xml", "sh_svg_contact_us.xml");
        map.put("svg_hw_tab1.xml", "sh_svg_tab1.xml");
        map.put("svg_hw_tab1_p.xml", "sh_svg_tab1_p.xml");
        map.put("svg_hw_tab2.xml", "sh_svg_tab2.xml");
        map.put("svg_hw_tab2_p.xml", "sh_svg_tab2_p.xml");
        map.put("svg_hw_tab3.xml", "sh_svg_tab3.xml");
        map.put("svg_hw_tab3_p.xml", "sh_svg_tab3_p.xml");
        map.put("svg_hw_tab4.xml", "sh_svg_tab4.xml");
        map.put("svg_hw_tab4_p.xml", "sh_svg_tab4_p.xml");
        map.put("review_user_center_fragment.xml", "sh_fragment_user_mine.xml");
        map.put("hwmain_fragment.xml", "sh_fragment_main.xml");


        map.put("top_receive_bg.png", "dialog_backtop_bg.png");
        map.put("hw_user_center_bg.webp", "mine_usercenter_bg.webp");
        map.put("pointer.png", "net_pointer.png");
        map.put("speedometer.png", "net_speed.png");
        map.put("password_invisible.png", "password_close.png");
        map.put("password_visible.png", "password_open.png");
        map.put("check_false.png", "wifi_chose_false.png");
        map.put("check_true.png", "wifi_chose_true.png");

        map.put("close_black_bg.webp", "dialog_connect_close.webp");
        map.put("mine_menu_next.webp", "menu_next.webp");
        map.put("icon_head_man.webp", "user_man.webp");
        map.put("icon_head_woman.webp", "user_woman.webp");

        map.put("wifi_circle.png", "home_circle.png");
        map.put("home_wifi.webp", "icon_wifi.webp");
        map.put("ic_verline_netspeed.webp", "line_netspeed.webp");
        map.put("home_safe_test.webp", "network_safe.webp");
        map.put("home_net_test.webp", "network_test.webp");
        map.put("ic_gold_head.webp", "notify_head_suc.webp");
        map.put("bg_security_center_soft_one.webp", "sw_check_bg.webp");
        map.put("wifi_connect_back.png", "wifi_connected_bg.png");
        map.put("wifi_connect_fail.png", "wifi_connected_error.png");
        map.put("wifi_connect_ok.png", "wifi_connected_suc.png");
        map.put("wifi_finder.png", "wifi_finding.png");
        map.put("qyny_wifi_level_1.png", "wifi_lev1.png");
        map.put("qyny_wifi_level_1_key.png", "wifi_lev1_lock.png");
        map.put("qyny_wifi_level_2.png", "wifi_lev2.png");
        map.put("qyny_wifi_level_2_key.png", "wifi_lev2_lock.png");
        map.put("qyny_wifi_level_3.png", "wifi_lev3.png");
        map.put("qyny_wifi_level_3_key.png", "wifi_lev3_lock.png");
        map.put("wifi_level_3_key.png", "wifi_lev3_key.png");
        map.put("wifi_refresh.webp", "wifi_main_refresh.webp");
        map.put("wifi_error_nopermission.webp", "wifi_nopermission.webp");
        map.put("ic_pointer_netspeed.webp", "wifi_pointer_netspeed.webp");
        map.put("wifi_scan_rotate.png", "wifi_rotating.png");
        map.put("wifi_key.png", "wifi_uncon_key.png");
        map.put("wifi_search.png", "wifi_uncon_search.png");

        map.put("light_yellow_bg.png", "dialog_light_bg.png");
        map.put("dialog_back_title.webp", "dialog_back_top.webp");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Key: " + value + ", Value: " + key);
            boolean hasTargetFile = FileUtils.renameFileTxt(folderPath, value, key);
            Log.show("是否找到目标文件" + value + "：" + hasTargetFile);
        }
    }

}
