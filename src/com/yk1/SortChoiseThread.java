package com.yk1;

public class SortChoiseThread implements Runnable {

    private int[] unsortArray;

    public SortChoiseThread(int[] unsortArray) {
        this.unsortArray = unsortArray;
    }

    @Override
    public void run() {
        choisSort(unsortArray);

    }

    public static void choisSort(int[] unsortArray) {

        int indexMin;
        for (int i = 0; i < unsortArray.length - 1; i++) {
            indexMin = i;
            for (int j = i; j < unsortArray.length; j++) {
                if (unsortArray[indexMin] > unsortArray[j]) {
                    indexMin = j;
                }
            }
            int temp = unsortArray[i];
            unsortArray[i] = unsortArray[indexMin];
            unsortArray[indexMin] = temp;

        }
    }
}


