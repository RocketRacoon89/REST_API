package servlet1.v1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fileManager.controller.FileController;
import fileManager.model.File;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileRestControllerV1 extends HttpServlet {

    private static final Gson GSON = new GsonBuilder().create();

    private String message;

    public void init() throws ServletException {
        message = "This is simple servlet message";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strId1 = request.getRequestURI();
        strId1 = strId1.substring("/api/v1/file/".length());
        int id_file = 0;
        if(strId1.length()>0) {
            id_file = Integer.parseInt(strId1);
        }


        FileController fileController = new FileController();
        fileManager.model.File file = new File();
        List<fileManager.model.File> files = new ArrayList<>();
        if(id_file>0) {
            file = fileController.getByIdFile(id_file);
        } else {
            files = fileController.getAllFiles();
        }
        response.setStatus(200);
        response.setHeader("Content-Type", "application/json");

        if(id_file>0) {
            response.getOutputStream().println(file.getFilePath());
        } else {
            for(File f:files) {
                response.getOutputStream().println(f.getFilePath());
            }
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //парсим тело запроса
        BufferedReader toParse = request.getReader();
        String parse = toParse.readLine();
        System.out.println("line1 "+parse);
        String req = "";
        while (parse!=null) {
            req+=String.valueOf(parse);
            parse = toParse.readLine();
            System.out.println("line2 "+parse);
        }
        System.out.println(req);
        String testName = req.substring(req.indexOf("\"name\"")+6);
        testName = testName.substring(0, testName.indexOf("-"));
        String testFilePath = req.substring(req.indexOf("\"filePath\"")+10);
        testFilePath = testFilePath.substring(0, testFilePath.indexOf("-"));
        System.out.println(testName);
        System.out.println(testFilePath);

        String name = testName;
        String filePath = testFilePath;
        FileController fileController = new FileController();
        File file = fileController.createFile(name, filePath);

        response.setStatus(201);
        response.setHeader("Content-Type", "application/json");
        response.getOutputStream().println(GSON.toJson(file));

    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //парсим тело запроса
        BufferedReader toParse = request.getReader();
        String parse = toParse.readLine();
        System.out.println("line1 "+parse);
        String req = "";
        while (parse!=null) {
            req+=String.valueOf(parse);
            parse = toParse.readLine();
            System.out.println("line2 "+parse);
        }

        String strId = req.substring(req.indexOf("\"id_file\"")+9);
        strId = strId.substring(0, strId.indexOf("-"));
        int id_file = Integer.parseInt(strId);
        String name = req.substring(req.indexOf("\"name\"")+6);
        name = name.substring(0, name.indexOf("-"));
        String filePath = req.substring(req.indexOf("\"filePath\"")+10);
        filePath = filePath.substring(0, filePath.indexOf("-"));
        System.out.println(id_file);
        System.out.println(name);
        System.out.println(filePath);


        FileController fileController = new FileController();
        fileController.updateFile(id_file, name, filePath);

        File file = fileController.getByIdFile(id_file);

        response.setStatus(201);
        response.setHeader("Content-Type", "application/json");
        response.getOutputStream().println(GSON.toJson(file));
    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strId1 = request.getRequestURI();
        int id_file = Integer.parseInt(strId1.substring("/api/v1/file/".length()));

        FileController fileController = new FileController();
        fileController.deleteFile(id_file);

        response.setStatus(201);
        response.setHeader("Content-Type", "application/json");
        response.getOutputStream().println("File ID: "+(id_file)+" DELETED!");
    }

    public void destroy() {

    }
}
