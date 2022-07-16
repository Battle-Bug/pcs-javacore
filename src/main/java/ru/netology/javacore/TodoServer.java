package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.*;
import java.lang.reflect.Type;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLOutput;
import java.util.*;

public class TodoServer {
    //...
    private int port;
    private Todos todos;

    public TodoServer(int port, Todos todos) {
        //...
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Starting server at " + port + "...");
            //...
            JSONParser jsonParser = new JSONParser();
            while (true) {
                try (Socket socket = serverSocket.accept();
                     PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    String json = bufferedReader.readLine();
                    Object obj = jsonParser.parse(json);
                    JSONObject jsonObj = (JSONObject) obj;
                    String typeTodos = (String) jsonObj.get("type");
                    if (typeTodos.equals("ADD")) {
                        String addTodos = (String) jsonObj.get("task");
                        todos.addTask(addTodos);
                    } else {
                        String deleteTodos = (String) jsonObj.get("task");
                        todos.removeTask(deleteTodos);
                    }
                    String s = todos.getAllTasks();
                    printWriter.println(s);
                }
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
