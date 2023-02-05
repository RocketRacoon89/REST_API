package servlet1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fileManager.controller.FileController;
import fileManager.model.File;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileRestControllerV1 extends HttpServlet {

    private static final Gson GSON = new GsonBuilder().create();
    private final String user_file_path = "src//main//resources//User.json";

    private String message;

    public void init() throws ServletException {
        message = "This is simple servlet message";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strId = request.getParameter("id_file");
        FileController fileController = new FileController();
        fileManager.model.File file = new File();
        List<fileManager.model.File> files = new ArrayList<>();
        if(strId!=null) {
            file = fileController.getByIdFile(Integer.parseInt(strId));
        } else {
            files = fileController.getAllFiles();
        }
        response.setStatus(200);
        response.setHeader("Content-Type", "application/json");
//        response.getOutputStream().println(GSON.toJson(user));

        if(strId!=null) {
            response.getOutputStream().println(GSON.toJson(file));
        } else {
            response.getOutputStream().println(GSON.toJson(files));
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String filePath = request.getParameter("filePath");
        FileController fileController = new FileController();
        File file = fileController.createFile(name, filePath);

        response.setStatus(201);
        response.setHeader("Content-Type", "application/json");
        response.getOutputStream().println(GSON.toJson(file));

    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_file = request.getParameter("id_file");
        String name = request.getParameter("name");
        String filePath = request.getParameter("filePath");

        FileController fileController = new FileController();
        fileController.updateFile(Integer.parseInt(id_file), name, filePath);

        File file = fileController.getByIdFile(Integer.parseInt(id_file));

        response.setStatus(201);
        response.setHeader("Content-Type", "application/json");
        response.getOutputStream().println(GSON.toJson(file));
    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_file = request.getParameter("id_file");

        FileController fileController = new FileController();
        fileController.deleteFile(Integer.parseInt(id_file));

        response.setStatus(201);
        response.setHeader("Content-Type", "application/json");
//        response.getOutputStream().println(GSON.toJson(user));
        response.getOutputStream().println("File ID: "+Integer.parseInt(id_file)+" DELETED!");
    }

    public void destroy() {

    }
}
