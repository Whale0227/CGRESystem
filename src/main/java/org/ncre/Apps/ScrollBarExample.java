package org.ncre.Apps;

import javax.swing.*;
import java.awt.*;


import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class ScrollBarExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Scroll Bar Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // 创建包含大量标签的面板
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        // 向面板中添加一些标签
        for (int i = 0; i < 20; i++) {
            panel.add(new JLabel("Label " + i));
        }

        // 创建垂直滚动条
        JScrollBar verticalScrollBar = new JScrollBar(JScrollBar.VERTICAL, 0, 1, 0, panel.getComponentCount());

        // 监听滚动条的数值变化事件
        verticalScrollBar.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                int value = e.getValue();
                panel.setLocation(panel.getX(), -value * 20); // 以标签高度为单位滚动
            }
        });

        // 添加面板和滚动条到内容面板中
        Container contentPane = frame.getContentPane();
        contentPane.add(panel);
        contentPane.add(verticalScrollBar, BorderLayout.EAST);

        frame.setVisible(true);
    }
}