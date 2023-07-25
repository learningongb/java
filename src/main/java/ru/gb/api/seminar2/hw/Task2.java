package ru.gb.api.seminar2.hw;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.text.SimpleDateFormat;
import java.util.Date;

class BubbleSort {

    private static File log;
    private static FileWriter fileWriter;

    BubbleSort() {
        assignFile("log.txt");
    }

    BubbleSort(String fileName) {
        assignFile(fileName);
    }

    private static void assignFile(String fileName) {
        log = new File(fileName);
        try {
            fileWriter = new FileWriter(log);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * @apiNote Сортировка пузырьком
     * @param mas массив
     */
    public static void sort(int[] mas) {

        boolean isSorted;
        for (int i = 0; i < mas.length; i++) {
            isSorted = true;
            for (int j = 0; j < mas.length - 1 - i; j++) {
                if (mas[j] > mas[j+1]) {
                    int tmp = mas[j];
                    mas[j] = mas[j+1];
                    mas[j+1] = tmp;
                    isSorted = false;
                }
            }
            writeToLog(mas);
            if (isSorted) break;
        }
    }

    /**
     * @apiNote Делает запись текущего состояния массива в лог файл
     * @param mas массив
     */
    private static void writeToLog(int[] mas) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String message = simpleDateFormat.format(date) + " " + masToString(mas) + "\n";
        try {
            fileWriter.write(message);
            fileWriter.flush();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * @apiNote Переводит массив int[] в массив String[]
     * @param mas массив
     * @return массив
     */
    private static String masToString(int[] mas) {
        String[] result = Arrays.stream(mas)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        return Arrays.toString(result);
    }
}

public class Task2 {
    public static void main(String[] args) {
        int[] arr;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            //arr = new int[]{9, 4, 8, 3, 1};
            arr = Arrays.stream("9, 3, 4, 8, 2, 5, 7, 1, 6, 10".split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        else{
            arr = Arrays.stream(args[0].split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        BubbleSort ans = new BubbleSort();
        ans.sort(arr);

        try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
