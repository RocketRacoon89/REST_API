package servlet1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fileManager.controller.EventController;
import fileManager.controller.FileController;
import fileManager.controller.UserController;
import fileManager.model.Event;
import fileManager.model.File;
import fileManager.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class EventRestControllerV1 extends HttpServlet {

    private static final Gson GSON = new GsonBuilder().create();
    private final String user_file_path = "src//main//resources//User.json";

    private String message;

    public void init() throws ServletException {
        message = "This is simple servlet message";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strId = request.getParameter("id_event");
        EventController eventController = new EventController();
        Event event = new Event();
        List<Event> events = new ArrayList<>();
        if(strId!=null) {
            event = eventController.getByIdEvent(Integer.parseInt(strId));
        } else {
            events = eventController.getAllEvents();
        }
        response.setStatus(200);
        response.setHeader("Content-Type", "application/json");
//        response.getOutputStream().println(GSON.toJson(user));

        if(strId!=null) {
            response.getOutputStream().println(GSON.toJson(event));
        } else {
            response.getOutputStream().println(GSON.toJson(events));
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_user = request.getParameter("id_user");
        String id_file = request.getParameter("id_file");

        EventController eventController = new EventController();

        Event event = eventController.createEvent(Integer.parseInt(id_user), Integer.parseInt(id_file));

        response.setStatus(201);
        response.setHeader("Content-Type", "application/json");
        response.getOutputStream().println(GSON.toJson(event));

    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_event = request.getParameter("id_event");
        String id_user = request.getParameter("id_user");
        String id_file = request.getParameter("id_file");

        EventController eventController = new EventController();
        eventController.updateEvent(Integer.parseInt(id_file), Integer.parseInt(id_user), Integer.parseInt(id_file));

        Event event = eventController.getByIdEvent(Integer.parseInt(id_event));

        response.setStatus(201);
        response.setHeader("Content-Type", "application/json");
        response.getOutputStream().println(GSON.toJson(event));
    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_event = request.getParameter("id_event");

        EventController eventController = new EventController();
        eventController.deleteEvent(Integer.parseInt(id_event));

        response.setStatus(201);
        response.setHeader("Content-Type", "application/json");
//        response.getOutputStream().println(GSON.toJson(user));
        response.getOutputStream().println("Event ID: "+Integer.parseInt(id_event)+" DELETED!");
    }


    public void destroy() {

    }
}
