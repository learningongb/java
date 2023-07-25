package ru.gb.api.seminar1.hw;

public class Task1 {
    public static void main(String[] args) {
        System.out.println(countNTriangle(4));
        System.out.println(countNTriangle(5));
    }

    /**
     * @apiNote Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n).
     * @param n число
     * @return треугольное число
     */
        public static int countNTriangle(int n){
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += i;
        }
        return result;
    }

}
