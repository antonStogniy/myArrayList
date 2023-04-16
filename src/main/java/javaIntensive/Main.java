package javaIntensive;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        MyArrayList<String> test = new MyArrayList<>();
        test.add("Б");
        test.add("А");
        test.add("Е");
        test.add("Г");
        test.add("Д");
        test.add("В");
        test.quickSort(Comparator.naturalOrder());
        test.display();
    }
}