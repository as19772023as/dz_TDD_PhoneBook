package ru.strebkov;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты на проверку работы телефонной-книги: ")
class PhoneBookTest {
    private static PhoneBook phoneBook;

    @BeforeAll
    static void beforeAll() {
        phoneBook = PhoneBook.getINSTANCE();
    }

    @AfterEach
    void tearDown() {
        System.out.println("END Test !  Конец теста\n");
    }

    public static Stream<Arguments> argumentsForAddTest() {
        return Stream.of(Arguments.of("Bob", "79990000001", 1),
                Arguments.of("Pop", "79990000002", 2),
                Arguments.of("Bob", "79990000003", 2),
                Arguments.of("Djop", "79990000004", 3),
                Arguments.of(null, "79990000005", 4));
    }


    @ParameterizedTest
    @MethodSource("argumentsForAddTest")
    @DisplayName("Тест на проверку на добавления имени и номера телефона")
    void addTest(String name, String namberPhone, int expected) {
        int countNamber = phoneBook.add(name, namberPhone);

        assertEquals(expected, countNamber);

    }

    @ParameterizedTest
    @MethodSource("argumentsForAddTest")
    @DisplayName("Тест значение имени == null")
    void addTestOnNull(String expected, String namberPhone, int count) {
        int countNamber = phoneBook.add(expected, namberPhone);

        assertNotNull(expected);

    }
}