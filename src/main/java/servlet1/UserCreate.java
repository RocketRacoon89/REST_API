package servlet1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fileManager.model.User;
import fileManager.repository.repo.UserRepo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class UserCreate extends HttpServlet {

    private static final Gson GSON = new GsonBuilder().create();
    private final String user_file_path = "src//main//resources//User.json";

    private String message;

    public void init() throws ServletException {
        message = "This is simple servlet message";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        User user = new User();
        user.setName(name);
        UserRepo userRepo = new UserRepo();
        userRepo.createUser(user);


        FileReader reader = new FileReader(user_file_path);
        FileWriter writer = new FileWriter(user_file_path);
        GSON.newBuilder().setPrettyPrinting().create();
        GSON.toJson(user, writer);

        User user1 = GSON.fromJson(reader, User.class);
        response.setStatus(201);
        response.setHeader("Content-Type", "application/json");
        response.getOutputStream().println(GSON.toJson(user1));

    }

    public void destroy() {

    }

}