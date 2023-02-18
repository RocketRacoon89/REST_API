package servlet1.v1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fileManager.controller.EventController;
import fileManager.model.Event;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EventRestControllerV1 extends HttpServlet {

    private static final Gson GSON = new GsonBuilder().create();

    private String message;

    public void init() throws ServletException {
        message = "This is simple servlet message";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strId1 = request.getRequestURI();
        strId1 = strId1.substring("/api/v1/event/".length());
        int id_event = 0;
        if(strId1.length()>0) {
            id_event = Integer.parseInt(strId1);
        }

        EventController eventController = new EventController();
        Event event = new Event();
        List<Event> events = new ArrayList<>();
        if(id_event>0) {
            event = eventController.getByIdEvent(id_event);
        } else {
            events = eventController.getAllEvents();
        }

        response.setStatus(200);
        response.setHeader("Content-Type", "application/json");

        if(id_event>0) {
            response.getOutputStream().println(GSON.toJson(event));
        } else {
            response.getOutputStream().println(GSON.toJson(events));
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
        String strIdUser = req.substring(req.indexOf("\"id_user\"")+9);
        strIdUser = strIdUser.substring(0, strIdUser.indexOf("-"));
        int id_user = Integer.parseInt(strIdUser);

        String strIdFile = req.substring(req.indexOf("\"id_file\"")+9);
        strIdFile = strIdFile.substring(0, strIdFile.indexOf("-"));
        int id_file = Integer.parseInt(strIdFile);

        EventController eventController = new EventController();
        Event event = eventController.createEvent(id_user, id_file);

        response.setStatus(201);
        response.setHeader("Content-Type", "application/json");
        response.getOutputStream().println(GSON.toJson(event));

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

        String strIdEvent = req.substring(req.indexOf("\"id_event\"")+10);
        strIdEvent = strIdEvent.substring(0, strIdEvent.indexOf("-"));
        int id_event = Integer.parseInt(strIdEvent);

        String strIdUser = req.substring(req.indexOf("\"id_user\"")+9);
        strIdUser = strIdUser.substring(0, strIdUser.indexOf("-"));
        int id_user = Integer.parseInt(strIdUser);

        String strIdFile = req.substring(req.indexOf("\"id_file\"")+9);
        strIdFile = strIdFile.substring(0, strIdFile.indexOf("-"));
        int id_file = Integer.parseInt(strIdFile);

        EventController eventController = new EventController();
        eventController.updateEvent(id_event, id_user, id_file);

        Event event = eventController.getByIdEvent(id_event);

        response.setStatus(201);
        response.setHeader("Content-Type", "application/json");
        response.getOutputStream().println(GSON.toJson(event));
    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strId1 = request.getRequestURI();
        int id_event = Integer.parseInt(strId1.substring("/api/v1/event/".length()));

        EventController eventController = new EventController();
        eventController.deleteEvent(id_event);

        response.setStatus(201);
        response.setHeader("Content-Type", "application/json");
        response.getOutputStream().println("Event ID: "+id_event+" DELETED!");
    }


    public void destroy() {

    }
}
