package com.hackerang;

import javax.swing.*;

public class MainApp extends  JFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        GraphPanel panel = new GraphPanel(20, 20);
        frame.add(panel);
        frame.setSize(panel.getWidth() + 100,panel.getHeight() + 100);
        frame.setVisible(true);
    }
}
