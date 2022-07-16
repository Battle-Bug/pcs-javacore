package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TodosTests {
    // ваши тесты для класса Todos
    @Test
    void addTodosTest() {
        Todos todos = new Todos( );
        String s = "Сходить погулять";
        String s1 = "Убрать конуру";
        String s2 = "Пошпилить в Dota2";
        String s3 = "Полежать отдохнуть";

        todos.addTask(s);
        todos.addTask(s1);
        todos.addTask(s2);
        todos.addTask(s3);


        String expected = "Полежать отдохнуть Пошпилить в Dota2 Сходить погулять Убрать конуру";
        String result = todos.getAllTasks( );


        Assertions.assertEquals(expected, result);
    }
    @Test
    void removeTodosTest() {
        Todos todos = new Todos( );
        String s = "Сходить погулять";
        String s1 = "Посмотреть телевизор";
        String s2 = "Пошпилить в Dota2";
        String s3 = "Полежать отдохнуть";

        todos.addTask(s);
        todos.addTask(s1);
        todos.addTask(s2);
        todos.addTask(s3);
        todos.removeTask(s3);


        String expected = "Посмотреть телевизор Пошпилить в Dota2 Сходить погулять";
        String result = todos.getAllTasks( );


        Assertions.assertEquals(expected, result);
    }
    @Test
    void removeTodosTestException() {
        Todos todos = new Todos( );
        String s = "Сходить погулять";
        String s1 = "Убрать конуру";
        String s2 = "Пошпилить в Dota2";
        String s3 = "Полежать отдохнуть";
        String s4 = "Потестить JUnit";

        todos.addTask(s);
        todos.addTask(s1);
        todos.addTask(s2);
        todos.addTask(s3);

        Assertions.assertThrows(IllegalArgumentException.class, () -> todos.removeTask(s4));
    }

}
