package com.yk1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] unsortArray = {2, 5, 1, 3, 6, 4, 8, 7, 9, 10};
        int init = unsortArray.length;
        int[] sortedArray = new int[init];
        int[] insertSortedArray = new int[init];

        System.out.println("Не отсортированный массив: " + Arrays.toString(unsortArray));

        SortChoiseThread sortChoiseThread = new SortChoiseThread(unsortArray);
        SortBubbleThread sortBubbleThread = new SortBubbleThread(unsortArray, sortedArray);
        SortInsertThread sortInsertThread = new SortInsertThread(unsortArray, insertSortedArray);
        Thread bubbleThread = new Thread(sortBubbleThread);
        Thread sortThread = new Thread(sortChoiseThread);
        Thread insertThread = new Thread(sortInsertThread);
        sortThread.start();
        bubbleThread.start();
        insertThread.start();

        try {
            sortThread.join();
            bubbleThread.join();
            insertThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Сортировка выбором : " + Arrays.toString(unsortArray));
        System.out.println("Сортировка пузырьком : " + Arrays.toString(sortedArray));
        System.out.println("Сортировка вставкой : " + Arrays.toString(insertSortedArray));
    }
}

/*
Задача 2:
Сортировка массива цифр в нескольких потоках различными алгоритмами:
 сортировка вставками;
 сортировка выбором;
 сортировка пузырьком.
Каждый вид сортировки должен запускаться в отдельном потоке. После вывести
результат отсортированных массивов в консоль.
 */
