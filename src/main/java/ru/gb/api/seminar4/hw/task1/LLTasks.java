package ru.gb.api.seminar4.hw.task1;

import java.util.LinkedList;

public class LLTasks {
    public static LinkedList<Object> revert(LinkedList<Object> ll) {
        // Напишите свое решение ниже

        LinkedList<Object> newLl = new LinkedList<Object>();

        for (Object item : ll) {
            newLl.addFirst(item);
        }

        return newLl;
    }

}
