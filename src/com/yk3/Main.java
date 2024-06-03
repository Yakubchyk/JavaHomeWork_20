package com.yk3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Заполните массив целыми числами через пробел: ");
        String userInput = scanner.nextLine();
        String strArr[] = userInput.split(" ");
        int numArr[] = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
        }
        FindMinThread findMinThread = new FindMinThread(numArr);
        FindMaxThread findMaxThread = new FindMaxThread(numArr);
        Thread maxThread = new Thread(findMaxThread);
        Thread minThread = new Thread(findMinThread);

        minThread.start();
        maxThread.start();

        try {
            minThread.join();
            maxThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Минимальное значение массива: " + findMinThread.getMin());
        System.out.println("Максимальное значение массива: " + findMaxThread.getMax());
    }
}
/*
Задача 1:
Пользователь вводит с клавиатуры значение в массив. После чего запускаются два
потока. Первый поток находит максимум в массиве, второй — минимум. Результаты
вычислений возвращаются в метод main().
 */
