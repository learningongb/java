package ru.gb.api.seminar6.hw;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class NotebookList {

    private List<Notebook> list = new LinkedList<>();
    private Map<String, Object> filter = new HashMap<>();

    /**
     * @apiNote Добавляет новый элемент в список ноутбуков
     * @param vendor
     * @param ram
     * @param diskSize
     * @param diskType
     * @param os
     * @param color
     */
    public void add(String vendor, int ram, int diskSize, String diskType, String os, String color) {
        list.add(new Notebook(vendor, ram, diskSize, diskType, os, color));
    }

    /**
     * @apiNote Добавляет значение фильтра по переданному ключу
     * @param key
     * @param value
     */
    public void addFilter(String key, Object value) {
        filter.put(key, value);
    }

    /**
     * @apiNote Удаляет один ключ фильтра
     * @param key
     */
    public void removeFilter(String key) {
        filter.remove(key);
    }

    /**
     * @apiNote Очищает фильтр
     */
    public void removeFilter() {
        filter.clear();
    }

    @Override
    public String toString() {
        return filterToString() + listToString();
    }

    /**
     * @apiNote Формирует тестовое представление списка
     * @return
     */
    private String listToString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (list.size() == 0)
            stringBuilder.append("Список ноутбуков пуст");
        else {
            stringBuilder.append("Список ноутбуков:");
            for (Notebook notebook : list) {
                if (meetsFilter(notebook)) {
                    stringBuilder.append(notebook);
                    stringBuilder.append("\n");
                }
            }
        }
        return stringBuilder.toString();
    }

    /**
     * @apiNote Формирует текстовое представление фильтра
     * @return
     */
    private String filterToString() {
        if (filter.isEmpty()) {
            return "Фильтр не установлен\n";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Установленный фильтр:\n");
        for (String key : filter.keySet()) {
            stringBuilder.append(key);
            if (filter.get(key) instanceof Integer)
                stringBuilder.append(" >= ");
            else
                stringBuilder.append(" = ");
            stringBuilder.append(filter.get(key));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    /**
     * @apiNote Выводит фильтр в консоль
     */
    public void printFilter() {
        System.out.println(filterToString());
    }

    /**
     * @apiNote Проверяет, что текущий элемент списка удовлетворяет установленному фильтру
     * @param notebook
     * @return
     */
    private boolean meetsFilter(Notebook notebook) {
        for (String key : filter.keySet()) {
            Object value = filter.get(key);
            switch (key) {
                case "vendor":
                    if (!notebook.vendor.equals(value))
                        return false;
                    break;
                case "ram":
                    if (notebook.ram < (int) value)
                        return false;
                    break;
                case "diskSize":
                    if (notebook.diskSize < (int) value)
                        return false;
                    break;
                case "diskType":
                    if (!notebook.diskType.equals(value))
                        return false;
                    break;
                case "os":
                    if (!notebook.os.equals(value))
                        return false;
                    break;
                case "color":
                    if (!notebook.color.equals(value))
                        return false;
                    break;
            }
        }
        return true;
    }

    class Notebook {
        private String vendor;
        private int ram;
        private int diskSize;
        private String diskType;
        private String os;
        private String color;

        public Notebook(String vendor, int ram, int diskSize, String diskType, String os, String color) {
            this.vendor = vendor;
            this.ram = ram;
            this.diskSize = diskSize;
            this.diskType = diskType;
            this.os = os;
            this.color = color;
        }

        @Override
        public String toString() {
            return String.format("%s/%dGb/%s %dGb/%s/%s", vendor, ram, diskType, diskSize, os, color);
        }
    }
}
