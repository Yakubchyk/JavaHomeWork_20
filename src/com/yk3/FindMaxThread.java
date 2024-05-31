package com.yk3;

public class FindMaxThread implements Runnable {

    int[] numArr;
    int max;

    public FindMaxThread(int[] numArr) {
        this.numArr = numArr;
    }

    @Override
    public void run() {
        max = findMax(numArr);
    }

    public int findMax(int[] numArr) {
        int max = numArr[0];
        for (int i = 1; i < numArr.length; i++) {
            if (numArr[i] > max) {
                max = numArr[i];
            }
        }
        return max;
    }

    public int getMax() {
        return max;
    }

}
