package com.yk1;

public class SortInsertThread implements Runnable {
    private int[] unsortArray;
    private int[] insertSortedArray;

    public SortInsertThread(int[] unsortArray, int[] insertSortedArray) {
        this.unsortArray = unsortArray;
        this.insertSortedArray = insertSortedArray;
    }

    @Override
    public void run() {
        insertSort(unsortArray, insertSortedArray);
    }

    public static void insertSort(int[] unsortArray, int[] insertSortedArray) {
        System.arraycopy(unsortArray, 0, insertSortedArray, 0, unsortArray.length);

        for (int i = 1; i < insertSortedArray.length; i++) {
            int element = insertSortedArray[i];
            int index = i;
            while (index > 0 && insertSortedArray[index - 1] > element) {
                insertSortedArray[index] = insertSortedArray[index - 1];
                index--;
            }
            insertSortedArray[index] = element;
        }
    }
}
