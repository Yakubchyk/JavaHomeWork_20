package com.yk3;

public class FindMinThread implements Runnable {

    private int[] numArr;
    private int min;

    public FindMinThread(int[] numArr) {
        this.numArr = numArr;
    }

    @Override
    public void run() {
        min = findMin(numArr);
    }

    public int findMin(int[] numArr) {
        int min = numArr[0];
        for (int i = 1; i < numArr.length; i++) {
            if (numArr[i] < min) {
                min = numArr[i];
            }
        }
        return min;
    }

    public int getMin() {
        return min;
    }
}
