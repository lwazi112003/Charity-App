package za.ac.cput.Repository;
/* Event.java
   EventRepository class
   Author: Simphiwe Thwabuse(220246009)
   Date: 27 March 2025
 */
import za.ac.cput.Domain.Event;

import java.util.ArrayList;
import java.util.List;

public class EventRepository implements IEventRepository  {

    private static EventRepository repository = null;

    private List<Event> eventList;

    private EventRepository() { eventList = new ArrayList<>(); }

    public static IEventRepository getRepository() {
        if (repository == null) {
            repository = new EventRepository();
        }
        return repository;

    }

    public Event create(Event event) {
        boolean sucess = eventList.add(event);

        if (sucess) {
            return event;
        }
        return null;
    }

    public Event read(String eventId) {
        for (Event event : eventList) {
            if (event.getEventId().equals(eventId)) {
                return event;
            }
        }
        return null;
    }

    public Event update(Event event) {
        String id = event.getEventId();
        Event eventOld = read(id);
        if (eventOld == null) {
            return null;
        }
        boolean sucess = delete(id);
        if (sucess) {
            if( eventList.add(event)) {
                return event;
            }
        }
        return null;
    }
    public boolean delete(String eventId) {
        Event eventToDelete = read(eventId);
        if (eventToDelete == null) {
            return false;
        }
        return eventList.remove(eventToDelete);
    }

    public List<Event> getEventList() {
        return eventList;
    }
}