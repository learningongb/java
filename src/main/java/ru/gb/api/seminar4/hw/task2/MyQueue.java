package ru.gb.api.seminar4.hw.task2;

import java.util.LinkedList;

public class MyQueue<T> {

    private LinkedList<T> queue;

    public MyQueue() {
        this.queue = new LinkedList<T>();
    }

    public void enqueue(T element){
        // Напишите свое решение ниже
        this.queue.addLast(element);
    }

    public T dequeue(){
        // Напишите свое решение ниже
        T tmp = queue.getFirst();
        queue.removeFirst();
        return tmp;
    }

    public T first(){
        // Напишите свое решение ниже
        return queue.getFirst();
    }

    public LinkedList<T> getElements() {
        // Напишите свое решение ниже
        return queue;
    }

}
