package com.yk1;

public class SortBubbleThread implements Runnable {

    private int[] unsortArray;
    private int[] sortedArray;

    public SortBubbleThread(int[] unsortArray, int[] sortedArray) {
        this.unsortArray = unsortArray;
        this.sortedArray = sortedArray;
    }

    @Override
    public void run() {
        bubbleSort(unsortArray, sortedArray);
    }

    public static void bubbleSort(int[] unsortArray, int[] sortedArray) {

        System.arraycopy(unsortArray, 0, sortedArray, 0, unsortArray.length);

        int counter;
        do {
            counter = 0;
            for (int i = 0; i < sortedArray.length - 1; i++) {
                if (sortedArray[i] > sortedArray[i + 1]) {
                    int temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    counter++;
                }
            }
        } while (counter > 0);
    }
}
