package ru.strebkov;

import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        PhoneBook phoneBook = PhoneBook.getINSTANCE();
        Map<String, String> book = new TreeMap<>();

        book.put(null, "79990000001");



    }
}