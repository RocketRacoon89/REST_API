package fileManager.services;

import fileManager.model.Event;
import fileManager.repository.repo.EventRepo;

import java.util.List;

public class EventService {
    private EventRepo eventRepo = new EventRepo();

    public Event saveEvent(Event event) {
        return eventRepo.createEvent(event);
    }

    public Event updateEvent(Event event) {
        return eventRepo.updateEvent(event);
    }

    public void deleteEvent(Integer id) {
        eventRepo.deleteEvent(id);
    }

    public Event getByIdEvent(Integer id) {
        return eventRepo.getByIdEvent(id);
    }

    public List<Event> getAllEvents() {
        return eventRepo.getAllEvents();
    }
}
