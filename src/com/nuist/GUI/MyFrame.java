/** Component |
 *     Container |
 *          Window |
 *              Frame
* */
package com.nuist.GUI;

import java.awt.*;

public class MyFrame {
    public static void main(String[] args) {
//        创建窗体对象
        Frame frame = new Frame();
//       设置标题
        frame.setTitle("HelloJava");
//        设置窗体可见
        frame.setVisible(true);
//       设置窗体大小
        frame.setSize(400,300);
//        设置为位置
        frame.setLocation(400,200);
//        设置窗体背景色
        frame.setBackground(Color.white);

    }
}
