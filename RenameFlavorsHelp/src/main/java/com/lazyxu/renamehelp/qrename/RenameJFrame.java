package com.lazyxu.renamehelp.qrename;

import com.lazyxu.renamehelp.FileUtils;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;

/**
 * User:Lazy_xu
 * Date:2024/05/21
 * Description:
 * FIXME
 */
public class RenameJFrame {

    public static JTextArea logText;
    private JButton backBtn;
    private JButton cleanBtn;
    private JTextField qTextField;

    /**
     * 初始化框架的内容。
     */
    public void initialize() {
        JFrame frame = new JFrame("q系列马甲包从修改资源文件名恢复到不修改");
        frame.setSize(1200, 800);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//用于指定当用户点击窗口的关闭按钮（通常是窗口右上角的 "X" 按钮）时程序应该执行的操作
        frame.setLocationRelativeTo(null);//在电脑屏幕居中

        JPanel qPathPanel = new JPanel();
        qPathPanel.setSize(1200, 100);
//        qPathPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel path = new JLabel("q系列马甲包文件路径：");
        path.setFont(new Font("宋体", 0, 15));

        qTextField = new JTextField(60);
        qTextField.setFont(new Font("宋体", 0, 16));
//        qTextField.setForeground(Color.GRAY);
        frame.setDropTarget(new DropTarget(qTextField, new DropTargetAdapter() {
            @Override
            public void drop(DropTargetDropEvent event) {
                event.acceptDrop(DnDConstants.ACTION_COPY);
                try {
                    // 获取拖放的文件路径
                    java.util.List<File> droppedFiles = (java.util.List<File>) event.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
                    if (droppedFiles.size() > 0) {
                        String path = droppedFiles.get(0).getAbsolutePath();
                        qTextField.setText(path);
                    }
                } catch (Exception e) {
                }

            }
        }));

        backBtn = new JButton("恢复");
        backBtn.setFont(new Font("宋体", 0, 12));
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startRenameBackRunningProcess();
            }
        });
        qPathPanel.add(path);
        qPathPanel.add(qTextField);
        qPathPanel.add(backBtn);

        cleanBtn = new JButton("清除");
        cleanBtn.setFont(new Font("宋体", 0, 12));
        cleanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                qTextField.setText("");
                logText.setText("日志：\n");
            }
        });
        qPathPanel.add(path);
        qPathPanel.add(qTextField);
        qPathPanel.add(backBtn);
        qPathPanel.add(cleanBtn);
        JPanel logPanel = new JPanel();
        logPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        logPanel.setSize(900, 500);

        logText = new JTextArea(28, 190);
        logText.setCaretPosition(logText.getDocument().getLength());//将插入符移动到文本的末尾
        logText.setAlignmentX(20);
        logText.setFocusable(false);
        logText.setBorder(new EmptyBorder(5, 5, 5, 5));
        logText.setLineWrap(true); // 自动换行
        logText.setWrapStyleWord(true);// 换行时按单词边界换行
        logText.setEditable(false);
        Font x1 = new Font("宋体", 0, 12);
        logText.setFont(x1);
        logText.setText("日志：\n");

        JScrollPane jScrollPane = new JScrollPane(logText);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        logPanel.add(jScrollPane);


        frame.add(qPathPanel);
        frame.add(logPanel);
        frame.setVisible(true);
    }

    private void btnEnable(boolean isenable){
        cleanBtn.setEnabled(isenable);
        backBtn.setEnabled(isenable);//禁止按钮重复点击
    }
    private void startRenameBackRunningProcess() {
        btnEnable(false);
        SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() throws Exception {
                QRenameUtils.renameBack(qTextField.getText().trim());
                return null;
            }

            @Override
            protected void process(java.util.List<String> chunks) {
            }

            @Override
            protected void done() {
                btnEnable(true);
                logText.append("Process completed.\n");
            }

        };
        worker.execute();
    }
}
