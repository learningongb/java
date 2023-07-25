package ru.gb.api.seminar2.hw;

class Answer {
    public static StringBuilder answer(String QUERY, String PARAMS){
        // Напишите свое решение ниже
        StringBuilder stringBuilder = new StringBuilder(QUERY);
        String[] parts = PARAMS.split("[,{}]");
        String[] keyValue;
        boolean hasParams = false;
        for (String item: parts) {
            keyValue = item.split(":");
            if (keyValue.length == 2 && !keyValue[1].equals("\"null\"")) {
                if (hasParams) stringBuilder.append(" and ");
                else hasParams = true;
                stringBuilder.append(keyValue[0].trim().replace("\"", ""));
                stringBuilder.append("='");
                stringBuilder.append(keyValue[1].trim().replace("\"", ""));
                stringBuilder.append("'");
            }
        }
        return stringBuilder;
    }
}

public class Task1 {

    public static void main(String[] args) {
        String QUERY = "";
        String PARAMS = "";

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            QUERY = "select * from students where ";
            PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"18\"} ";
        }
        else{
            QUERY = args[0];
            PARAMS = args[1];
        }

        Answer ans = new Answer();
        System.out.println(ans.answer(QUERY, PARAMS));
    }
}
