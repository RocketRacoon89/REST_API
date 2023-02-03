package fileManager.controller;

import fileManager.model.Event;
import fileManager.model.File;
import fileManager.model.User;
import fileManager.services.EventService;
import fileManager.services.FileService;
import fileManager.services.UserService;

import java.util.List;

public class EventController {
    EventService eventService = new EventService();
    UserService userService = new UserService();
    FileService fileService = new FileService();

    public Event createEvent(Integer idUser, Integer idFile) {
        User user = userService.getByIdUser(idUser);
        File file = fileService.getByIdFile(idFile);

        Event event = new Event();
        event.setUser(user);
        event.setFile(file);
        return eventService.saveEvent(event);
    }

    public Event updateEvent(Integer idEvent, Integer idUser, Integer idFile) {
        User user = userService.getByIdUser(idUser);
        File file = fileService.getByIdFile(idFile);

        Event event = new Event();
        event.setId(idEvent);
        event.setUser(user);
        event.setFile(file);
        return eventService.updateEvent(event);
    }

    public void deleteEvent(Integer id) {
        eventService.deleteEvent(id);
    }

    public Event getByIdEvent(Integer id) {
        return eventService.getByIdEvent(id);
    }

    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }
}
