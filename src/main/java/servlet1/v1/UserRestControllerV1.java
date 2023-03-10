package servlet1.v1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fileManager.controller.UserController;
import fileManager.model.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserRestControllerV1 extends HttpServlet {

    private static final Gson GSON = new GsonBuilder().create();

    private String message;

    public void init() throws ServletException {
        message = "This is simple servlet message";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strId1 = request.getRequestURI();
        strId1 = strId1.substring("/api/v1/user/".length());

        int id_user = 0;
        if(strId1.length()>0) {
            id_user = Integer.parseInt(strId1);
        }

        UserController userController = new UserController();
        User user = new User();
        List<User> users = new ArrayList<>();
        if(id_user>0) {
            user = userController.getByIdUser(id_user);
        } else {
            users = userController.getAllUsers();
        }
        response.setStatus(200);
        response.setHeader("Content-Type", "application/json");

        if(id_user>0) {
            response.getOutputStream().println(GSON.toJson(user));
        } else {
            response.getOutputStream().println(GSON.toJson(users));
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //парсим тело запроса
        BufferedReader toParse = request.getReader();
        String parse = toParse.readLine();
        String req = "";
        while (parse!=null) {
            req+=String.valueOf(parse);
            parse = toParse.readLine();
        }

        String name = req.substring(req.indexOf("\"name\"")+6);
        name = name.substring(0, name.indexOf("-"));

        UserController userController = new UserController();
        User user = userController.createUser(name);

        response.setStatus(201);
        response.setHeader("Content-Type", "application/json");
        response.getOutputStream().println(GSON.toJson(user));

    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //парсим тело запроса
        BufferedReader toParse = request.getReader();
        String parse = toParse.readLine();
        String req = "";
        while (parse!=null) {
            req+=String.valueOf(parse);
            parse = toParse.readLine();
        }

        String strId = req.substring(req.indexOf("\"id_user\"")+9);
        strId = strId.substring(0, strId.indexOf("-"));
        int id = Integer.parseInt(strId);
        String name = req.substring(req.indexOf("\"name\"")+6);
        name = name.substring(0, name.indexOf("-"));

        UserController userController = new UserController();
        userController.updateUser(id, name);

        User user = userController.getByIdUser(id);

        response.setStatus(201);
        response.setHeader("Content-Type", "application/json");
        response.getOutputStream().println(GSON.toJson(user));
    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strId1 = request.getRequestURI();
        int id_user = Integer.parseInt(strId1.substring("/api/v1/user/".length()));

        UserController userController = new UserController();
        userController.deleteUser(id_user);

        response.setStatus(201);
        response.setHeader("Content-Type", "application/json");
        response.getOutputStream().println("User ID: "+id_user+" DELETED!");
    }

    public void destroy() {

    }

}