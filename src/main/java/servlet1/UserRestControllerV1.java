package servlet1;

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
        String strId = request.getParameter("id_user");
        UserController userController = new UserController();
        User user = new User();
        List<User> users = new ArrayList<>();
        if(strId!=null) {
            user = userController.getByIdUser(Integer.parseInt(strId));
        } else {
            users = userController.getAllUsers();
        }
        response.setStatus(200);
        response.setHeader("Content-Type", "application/json");
//        response.getOutputStream().println(GSON.toJson(user));

        if(strId!=null) {
            response.getOutputStream().println(GSON.toJson(user));
        } else {
            response.getOutputStream().println(GSON.toJson(users));
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        UserController userController = new UserController();
        User user = userController.createUser(name);

        response.setStatus(201);
        response.setHeader("Content-Type", "application/json");
        response.getOutputStream().println(GSON.toJson(user));

    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_user = request.getParameter("id_user");
        String name = request.getParameter("name");

        UserController userController = new UserController();
        userController.updateUser(Integer.parseInt(id_user), name);

        User user = userController.getByIdUser(Integer.parseInt(id_user));

        response.setStatus(201);
        response.setHeader("Content-Type", "application/json");
        response.getOutputStream().println(GSON.toJson(user));
    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_user = request.getParameter("id_user");

        UserController userController = new UserController();
        userController.deleteUser(Integer.parseInt(id_user));

        response.setStatus(201);
        response.setHeader("Content-Type", "application/json");
//        response.getOutputStream().println(GSON.toJson(user));
        response.getOutputStream().println("User ID: "+Integer.parseInt(id_user)+" DELETED!");
    }

    public void destroy() {

    }

}