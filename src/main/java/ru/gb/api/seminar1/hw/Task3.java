package ru.gb.api.seminar1.hw;

public class Task3 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate('+', 5, 3));
        System.out.println(calculator.calculate('-', 5, 3));
        System.out.println(calculator.calculate('*', 5, 3));
        System.out.println(calculator.calculate('/', 6, 3));
    }

}
class Calculator {
    /**
     * @apiNote Напишите класс Calculator, который будет выполнять математические операции (+, -, *, /) над двумя числами и возвращать результат. В классе должен быть метод calculate, который принимает оператор и значения аргументов и возвращает результат вычислений.
     *
     * При неверно переданном операторе, программа должна вывести сообщение об ошибке "Некорректный оператор: 'оператор'".
     * @param op математическиий оператор
     * @param a первый параметр
     * @param b второй параметр
     * @return результат вычисления
     */
    public int calculate(char op, int a, int b) {
        // Введите свое решение ниже

        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
//            default:
//                throw "Некорректный оператор: 'оператор" + op + "'";
        }
        return 0;
    }
}

