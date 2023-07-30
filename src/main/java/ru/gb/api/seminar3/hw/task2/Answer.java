package ru.gb.api.seminar3.hw.task2;

import java.util.ArrayList;
import java.util.Arrays;

public class Answer {
    public static void removeEvenNumbers(Integer[] arr) {
        // Введите свое решение ниже

        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(arr));
        a.removeIf(n -> (n % 2 == 0));
        System.out.println(a);

    }

}
