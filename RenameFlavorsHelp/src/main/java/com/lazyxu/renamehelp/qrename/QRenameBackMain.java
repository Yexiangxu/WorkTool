package com.lazyxu.renamehelp.qrename;

import java.awt.EventQueue;

/**
 * 传入一个路径，路径下面全部文件名，统一添加，统一换成特定前缀
 */
public class QRenameBackMain {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                RenameJFrame readRFFile = new RenameJFrame();
                readRFFile.initialize();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}