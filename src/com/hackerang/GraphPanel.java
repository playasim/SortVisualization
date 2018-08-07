package com.hackerang;

import com.hackerang.sort.BubbleSort;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphPanel extends JPanel {
    private int rows;

    private int cols;

    private int blockHeight = 30;

    private int blockWidth = 30;

    private JLabel[][] labels;

    private JButton generateArr;

    private JButton startSorting;

    private JTextField textField;

    private BubbleSort bubbleSort;

    private int[] tempList;
    
    public GraphPanel(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.setLayout(null);
        this.setVisible(true);
        this.setOpaque(true);
        initializeLables();
        initializeTextField();
        initializeButtion();

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
        startSorting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bubbleSortTimer.start();
            }
        });
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
        tempList = new int[arrays.length];
        for (int i = 0; i < arrays.length; i++) {
            int value = Integer.valueOf(arrays[i]);
            tempList[i] = value;
            for (int j = 0; j < rows; j++) {
                if (j >= rows - tempList[i]) {
                    labels[j][i].setBackground(Color.ORANGE);
                } else {
                    labels[j][i].setBackground(Color.WHITE);

                }
            }
        }

        bubbleSort = new BubbleSort(tempList);
        bubbleSort.setSorted(false);

    }

    private final Timer bubbleSortTimer = new Timer(300, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (bubbleSort.isSorted()) {
                System.out.println("Quit timer mode");
                bubbleSortTimer.stop();
                return;

            }
            System.out.println("Timer start...");
            bubbleSort.startSort();
            tempList = bubbleSort.getTempList();
            bubbleSort.startSort();
            System.out.println("tempList :" + Arrays.toString(tempList));

            startPaint();
        }

        private void startPaint() {
            System.out.println("Start painting...");
            for (int i = 0; i < tempList.length; i++) {
                for (int j = 0; j < rows; j++) {
                    if (j >= rows - tempList[i]) {
                        labels[j][i].setBackground(Color.ORANGE);
                    } else {
                        labels[j][i].setBackground(Color.WHITE);

                    }
                }
            }
        }
    });




}
