package ru.gb.api.seminar4.hw.task3;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {

    private ArrayDeque<Integer> results;

    public Calculator() {
        results = new ArrayDeque<Integer>();
    }

    public int calculate(char op, int a, int b) {
        // Введите свое решение ниже

        int result = 0;
        if (op == '+')
            result = a + b;
        else if (op == '-')
            result =  a - b;
        else if (op == '*')
            result =  a * b;
        else if (op == '/')
            result =  a / b;

        if (op == '<') {
            results.removeLast();
            result = results.removeLast();

            /* Вариант без удаления элементов
            Integer beforeLast = null;
            Integer last = null;
            for (Integer item : results) {
                beforeLast = last;
                last = item;
            }
            result = beforeLast;
             */
        } else
            results.add(result);


        return result;
    }
}
