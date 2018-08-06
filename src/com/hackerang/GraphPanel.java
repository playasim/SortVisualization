package com.hackerang;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class GraphPanel extends JPanel {
    private int rows;

    private int cols;

    private int blockHeight = 30;

    private int blockWidth = 30;

    private JLabel[][] labels;

    private JButton generateArr;

    private JButton startSorting;

    private JTextField textField;

    private Timer timer;

    public GraphPanel(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.setLayout(null);
        this.setVisible(true);
        this.setOpaque(true);
        initializeLables();
        initializeTextField();
        initializeButtion();

        timer = new Timer(100, sortActionListener);
    }

    private void initializeLables() {
        labels = new JLabel[rows][cols];
        this.setSize(blockWidth * cols + 100, blockHeight * rows + 100);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                JLabel label = new JLabel();
                label.setOpaque(true);
                label.setBounds(j * blockWidth, i * blockHeight, blockWidth, blockHeight);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                label.setBackground(Color.WHITE);
                labels[i][j] = label;
                this.add(label);
            }
        }
    }

    private void initializeButtion() {
        generateArr = new JButton("Generate Arrays");
        generateArr.setBounds(blockWidth * cols / 5, blockHeight * rows + 30, 130, 30);
        generateArr.setText("Generate Arrays");
        generateArr.setHorizontalAlignment(SwingConstants.LEFT);
        this.add(generateArr);
        generateArr.addActionListener(e -> {
            System.out.println("Generate Button Clicked.");
            generateArrays();
        });

        startSorting = new JButton("Start");
        startSorting.setBounds(blockWidth * cols / 5, blockHeight * rows + 70, 130, 30);
        startSorting.setHorizontalAlignment(SwingConstants.LEFT);
        this.add(startSorting);
        startSorting.addActionListener(sortActionListener);
    }

    private void initializeTextField() {
        textField = new JTextField();
        textField.setBounds(blockWidth * cols / 2, blockHeight * rows + 30, 200, 30);
        textField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(textField);
    }

    private void generateArrays() {
        System.out.println("textfield text:" + textField.getText());
        if ("".equals(textField.getText()) || textField.getText() == null) {
            return;
        }
        String[] arrays = textField.getText().split(",");
        for (int i = 0; i < arrays.length; i++) {
            int value = Integer.valueOf(arrays[i]);
            for (int j = 0; j < value; j++) {
                labels[cols - 1 - j][i].setBackground(Color.ORANGE);
                labels[cols - 1 - j][i].repaint();
            }
        }
    }

    ActionListener sortActionListener = e -> {
        timer.start();
        System.out.println("Processing..............");

    };



}
