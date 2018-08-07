package com.hackerang.sort;

public class BubbleSort{
    private int[] tempList;

    private int index = 0;

    private int cycles = 0;

    private boolean sorted = false;

    public BubbleSort(int[] tempList) {
        this.tempList = tempList;
    }

    public void startSort() {
        if (cycles >= tempList.length - 1) {
            sorted = true;
        }
        if (index + 1 >= tempList.length) {
            cycles ++;
            index = 0;


        }
        if (tempList[index] > tempList[index + 1]) {

            int temp = tempList[index];

            tempList[index] = tempList[index + 1];

            tempList[index + 1] = temp;
        }
        index ++;
    }

    public int[] getTempList() {
        return tempList;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isSorted() {
        return sorted;
    }

    public void setSorted(boolean sorted) {
        this.sorted = sorted;
    }
}
