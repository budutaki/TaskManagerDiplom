package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    protected int port;
    protected Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public Task jsonToData(String json) throws ParseException {
        JSONParser jp = new JSONParser();
        GsonBuilder gb = new GsonBuilder();
        Gson gson = gb.create();
        JSONObject jsonObject = (JSONObject) jp.parse(json);
        return gson.fromJson(String.valueOf(jsonObject), Task.class);
    }


    public void start() throws RuntimeException {
        System.out.println("Starting server at " + port + "...");
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter out = new PrintWriter(socket.getOutputStream())) {

                    final String json = in.readLine();
                    final Task result = jsonToData(json);

                    switch (result.getType()) {
                        case ADD:
                            todos.addTask(result.getTask());
                            break;
                        case REMOVE:
                            todos.removeTask(result.getTask());
                            break;
                    }
                    out.println(todos.getAllTasks());
                }
            }
        } catch (IOException | ParseException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }


    }
}
