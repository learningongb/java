package ru.gb.api.seminar1.hw;

public class Task2 {
    public static void main(String[] args) {
        Answer answer = new Answer();
        answer.printPrimeNums();
    }
}

class Answer {
    /**
     * @apiNote Напишите функцию printPrimeNums, которая выведет на экран все простые числа от 1 до 1000, каждое на новой строке.
     */
    public void printPrimeNums(){
        for (int i = 1; i < 1001; i++) {
            if (i == 1) {
                System.out.println(i);
            } else {
                boolean isPrime = true;
                for (int j = 2; j < (i / 2) + 1; j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    System.out.println(i);
                }
            }
        }
    }
}

