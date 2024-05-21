package com.lazyxu.renamehelp;

import java.util.HashMap;
import java.util.Map;

/**
 * 传入一个路径，路径下面全部文件名，统一添加，统一换成特定前缀
 */
public class RenameTxt {


    private static String folderPath = "D:\\work\\unified_wifi";


    public static void main(String[] args) {
//        HashMap<String, String> map = new HashMap<String, String>();
//        map.put("review_user_center_fragment.xml", "sh_fragment_user_mine.xml");
//        map.put("hwmain_fragment.xml", "sh_fragment_main.xml");
//        map.put("hw_group_bk.xml", "sh_shape_nav_bg.xml");
//        map.put("shape_circle_7dp.xml", "sh_shape_white_7dp.xml");
//        map.put("svg_hw_about_us.xml", "sh_svg_about_us.xml");
//        map.put("svg_hw_clear_cache.xml", "sh_svg_clear_cache.xml");
//        map.put("svg_hw_contact_us.xml", "sh_svg_contact_us.xml");
//        map.put("svg_hw_tab1.xml", "sh_svg_tab1.xml");
//        map.put("svg_hw_tab1_p.xml", "sh_svg_tab1_p.xml");
//        map.put("svg_hw_tab2.xml", "sh_svg_tab2.xml");
//        map.put("svg_hw_tab2_p.xml", "sh_svg_tab2_p.xml");
//        map.put("svg_hw_tab3.xml", "sh_svg_tab3.xml");
//        map.put("svg_hw_tab3_p.xml", "sh_svg_tab3_p.xml");
//        map.put("svg_hw_tab4.xml", "sh_svg_tab4.xml");
//        map.put("svg_hw_tab4_p.xml", "sh_svg_tab4_p.xml");
//        map.put("selector_tab_color.xml", "sh_selector_tab_color.xml");
//        map.put("hw_user_center_bg.webp", "mine_usercenter_bg.webp");
//        map.put("light_yellow_bg.png", "dialog_light_bg.png");
//        map.put("password_invisible.png", "password_close.png");
//        map.put("password_visible.png", "password_open.png");
//        map.put("check_false.png", "wifi_chose_false.png");
//        map.put("check_true.png", "wifi_chose_true.png");
//        map.put("top_receive_bg.png", "dialog_backtop_bg.png");
//        map.put("pointer.png", "net_pointer.png");
//        map.put("speedometer.png", "net_speed.png");
//        map.put("close_black_bg.webp", "dialog_connect_close.webp");
//        map.put("icon_head_man.webp", "user_man.webp");
//        map.put("icon_head_woman.webp", "user_woman.webp");
//        map.put("bg_security_center_soft_one.webp", "sw_check_bg.webp");
//        map.put("home_net_test.webp", "network_test.webp");
//        map.put("home_safe_test.webp", "network_safe.webp");
//        map.put("home_wifi.webp", "icon_wifi.webp");
//        map.put("ic_gold_head.webp", "notify_head_suc.webp");
//        map.put("ic_pointer_netspeed.webp", "wifi_pointer_netspeed.webp");
//        map.put("ic_verline_netspeed.webp", "line_netspeed.webp");
//        map.put("network_signal.webp", "icon_4g.webp");
//        map.put("qyny_wifi_level_1.png", "wifi_lev1.png");
//        map.put("qyny_wifi_level_1_key.png", "wifi_lev1_lock.png");
//        map.put("qyny_wifi_level_2.png", "wifi_lev2.png");
//        map.put("qyny_wifi_level_2_key.png", "wifi_lev2_lock.png");
//        map.put("qyny_wifi_level_3.png", "wifi_lev3.png");
//        map.put("qyny_wifi_level_3_key.png", "wifi_lev3_lock.png");
//        map.put("wifi_circle.png", "home_circle.png");
//        map.put("wifi_connect_back.png", "wifi_connected_bg.png");
//        map.put("wifi_connect_fail.png", "wifi_connected_error.png");
//        map.put("wifi_connect_ok.png", "wifi_connected_suc.png");
//        map.put("wifi_error_nopermission.webp", "wifi_nopermission.webp");
//        map.put("wifi_finder.png", "wifi_finding.png");
//        map.put("wifi_key.png", "wifi_uncon_key.png");
//        map.put("wifi_level_3_key.png", "wifi_lev3_key.png");
//        map.put("wifi_refresh.webp", "wifi_main_refresh.webp");
//        map.put("wifi_scan_rotate.png", "wifi_rotating.png");
//        map.put("wifi_search.png", "wifi_uncon_search.png");
//        map.put("dialog_back_title.webp", "wifi_uncon_search.webp");
//        map.put("dialog_back_title.webp", "dialog_back_top.webp");
//        map.put("app_launcher.png", "icon_launcher.png");
//        map.put("launcher.webp", "splash.webp");

        HashMap<String, String> mapwifi = new HashMap<String, String>();
//        mapwifi.put("selector_tab_color.xml", "selector_wi_tab_color.xml");
//        mapwifi.put("hw_menu1.xml", "sh_wf_menu1.xml");
//        mapwifi.put("hw_menu2.xml", "sh_wf_menu2.xml");
//        mapwifi.put("hw_menu3.xml", "sh_wf_menu3.xml");
//        mapwifi.put("hw_menu4.xml", "sh_wf_menu4.xml");
//        mapwifi.put("shape_circle_7dp.xml", "shape_white_7dp.xml");
//        mapwifi.put("svg_hw_about_us.xml", "sh_svg_wi_about_us.xml");
//        mapwifi.put("svg_hw_clear_cache.xml", "sh_svg_wi_clear_cache.xml");
//        mapwifi.put("svg_hw_contact_us.xml", "sh_svg_wi_contact_us.xml");
//        mapwifi.put("svg_hw_tab1.xml", "sh_svg_wi_tab1.xml");
//        mapwifi.put("svg_hw_tab1_p.xml", "sh_svg_wi_tab1_p.xml");
//        mapwifi.put("svg_hw_tab2.xml", "sh_svg_wi_tab2.xml");
//        mapwifi.put("svg_hw_tab2_p.xml", "sh_svg_wi_tab2_p.xml");
//        mapwifi.put("svg_hw_tab3.xml", "sh_svg_wi_tab3.xml");
//        mapwifi.put("svg_hw_tab3_p.xml", "sh_svg_wi_tab3_p.xml");
//        mapwifi.put("svg_hw_tab4.xml", "sh_svg_wi_tab4.xml");
//        mapwifi.put("svg_hw_tab4_p.xml", "sh_svg_wi_tab4_p.xml");
//        mapwifi.put("review_user_center_fragment.xml", "wi_fragment_mycenter.xml");
//        mapwifi.put("hwmain_fragment.xml", "wi_fragment_mainhome.xml");
//        mapwifi.put("hlwf_pointer.png", "hlwf_wi_pointer.png");
//        mapwifi.put("hlwf_speedometer.png", "hlwf_wi_speedmeter.png");
//        mapwifi.put("hw_user_center_bg.webp", "wi_usercenter_bg.webp");
//        mapwifi.put("password_invisible.png", "wi_password_close.png");
//        mapwifi.put("password_visible.png", "wi_password_open.png");
//        mapwifi.put("pointer.png", "wi_pointer.png");
//        mapwifi.put("speedometer.png", "wi_speedter.png");
//        mapwifi.put("top_receive_bg.png", "wi_topreceive_bg.png");
//        mapwifi.put("check_false.png", "check_wi_false.png");
//        mapwifi.put("check_true.png", "check_wi_true.png");
//        mapwifi.put("close_black_bg.webp", "close_wf_blackbg.webp");
//        mapwifi.put("icon_camera.webp", "wi_camera.webp");
//        mapwifi.put("icon_head_man.webp", "wi_headman.webp");
//        mapwifi.put("icon_head_woman.webp", "wi_headwoman.webp");
//        mapwifi.put("mine_menu_next.webp", "menu_next.webp");
//        mapwifi.put("dialog_back_title.webp", "wi_baoxiang_title.webp");
//        mapwifi.put("light_yellow_bg.png", "wi_lightyellow_bg.png");

        mapwifi.put("bg_security_center_soft_one.webp", "wf_wi_securitycenter_bg.webp");
        mapwifi.put("hlwf_home_net_test.webp", "wi_home_nettest.webp");
        mapwifi.put("hlwf_home_safe_test.webp", "wi_home_safetest.webp");
        mapwifi.put("hlwf_home_wifi.webp", "hlwf_wi_homewifi.webp");

        mapwifi.put("hlwf_network_signal.png", "wi_network_4g.png");
        mapwifi.put("hlwf_safe_result.webp", "safe_wi_result.webp");
        mapwifi.put("hlwf_wifi_home_bg.webp", "hlwf_wi_homebg.webp");
        mapwifi.put("hlwf_wifi_tips.webp", "hlwf_wi_tips.webp");
        mapwifi.put("home_net_test.webp", "home_wi_nettest.webp");
        mapwifi.put("home_safe_test.webp", "home_wi_safetest.webp");
        mapwifi.put("home_wifi.webp", "home_wi_wifi.webp");
        mapwifi.put("home_wifi_fast.webp", "home_wi_fast.webp");
        mapwifi.put("ic_gold_head.webp", "gold_wi_head.webp");
        mapwifi.put("ic_pointer_netspeed.webp", "pointer_wi_netspeed.webp");
        mapwifi.put("ic_verline_netspeed.webp", "verline_wi_netspeed.webp");
        mapwifi.put("network_signal.png", "net_wi_4g.png");
        mapwifi.put("qyny_wifi_level_1.png", "wi_level1.png");
        mapwifi.put("qyny_wifi_level_1_key.png", "wi_level1_key.png");
        mapwifi.put("qyny_wifi_level_2.png", "wi_level2.png");
        mapwifi.put("qyny_wifi_level_2_key.png", "wi_level2_key.png");
        mapwifi.put("qyny_wifi_level_3.png", "wi_level3.png");
        mapwifi.put("qyny_wifi_level_3_key.png", "wi_level3_key.png");
        mapwifi.put("pointer1.webp", "wi_pointerone.webp");
        mapwifi.put("speedometer1.webp", "wi_speedmeter1.webp");
        mapwifi.put("hw_user_center_bg.webp", "wi_usercenter_bg.webp");
        mapwifi.put("check_true.png", "check_wi_true.png");
        mapwifi.put("check_false.png", "check_wi_false.png");
        mapwifi.put("wifi_circle.png", "wi_circle.png");
        mapwifi.put("wifi_connect_back.png", "connect_wi_back.png");
        mapwifi.put("wifi_connect_fail.png", "connect_wi_fail.png");
        mapwifi.put("wifi_connect_ok.png", "connect_wi_ok.png");
        mapwifi.put("wifi_connecting.png", "wi_connecting.png");
        mapwifi.put("wifi_error_nopermission.webp", "error_wi_nopermiss.webp");
        mapwifi.put("wifi_finder.png", "wi_finder.png");
        mapwifi.put("wifi_home_bg.webp", "home_wi_bg.webp");
        mapwifi.put("wifi_key.png", "wi_key.png");
        mapwifi.put("wifi_level_3_key.png", "level3_wi_key.png");
        mapwifi.put("wifi_refresh.webp", "wi_refresh.webp");
        mapwifi.put("wifi_scan_rotate.png", "scan_wi_rotate.png");
        mapwifi.put("wifi_search.png", "wi_searcher.png");







        for (Map.Entry<String, String> entry : mapwifi.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
            boolean hasTargetFile = FileUtils.renameTxtInFolder(folderPath, key, value);
            System.out.println("是否找到目标文件" + key + "：" + hasTargetFile);
        }
    }
}