package ru.gb.api.seminar3.hw.task1;

import java.util.Arrays;

public class MergeSort {
    public static int[] mergeSort(int[] a) {
        // Напишите свое решение ниже

        if (a.length <= 1) return a;

        int[] left = Arrays.copyOfRange(a, 0, (a.length + 1) / 2);
        int[] right = Arrays.copyOfRange(a, ((a.length + 1) / 2) , a.length);

        left = mergeSort(left);
        right = mergeSort(right);

        int indexResult = 0;
        int indexLeft = 0;
        int indexRight = 0;

        while (indexLeft < left.length && indexRight < right.length) {
            if (left[indexLeft] <= right[indexRight]) {
                a[indexResult++] = left[indexLeft++];
            } else {
                a[indexResult++] = right[indexRight++];
            }
        }
        while (indexLeft < left.length) {
            a[indexResult++] = left[indexLeft++];
        }
        while (indexRight < right.length) {
            a[indexResult++] =  right[indexRight++];
        }


        return a;

    }

}
