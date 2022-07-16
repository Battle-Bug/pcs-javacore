package ru.netology.javacore;

import java.util.*;
import java.util.concurrent.LinkedTransferQueue;
import java.util.stream.Collectors;

public class Todos {
    //...
    List<String> taskList;


    public Todos() {
        taskList = new ArrayList<>( );
    }

    public void addTask(String task) {
        //...
        taskList.add(task);
    }

    public void removeTask(String task) {
        //...
        if (taskList.contains(task)) {
            taskList.remove(task);
        } else {
            throw new IllegalArgumentException("Такой задачи нет в списке задач");
        }
    }

    public String getAllTasks() {
        //...
        StringBuilder stringBuilder = new StringBuilder( );
        Collections.sort(taskList);
        for (String s : taskList) {
            stringBuilder.append(s + " ");
        }
        return stringBuilder.toString( ).trim( );
    }

}
