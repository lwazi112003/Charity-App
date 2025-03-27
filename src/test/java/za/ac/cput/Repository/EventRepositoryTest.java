package za.ac.cput.Repository;

/* Event.java
   EventRepositoryTest class
   Author: Simphiwe Thwabuse(220246009)
   Date: 27 March 2025
 */
import  org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Event;
import za.ac.cput.Factory.EventFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EventRepositoryTest {
    private static IEventRepository repository = EventRepository.getRepository();

    private Event event = EventFactory.createEvent("E1001", "Equipment donation", "2025-04-15", "Foreshore", 250, 50);

    @Test
    void create() {
        Event created = repository.create(event);
        assertNotNull(created);
        assertEquals(event.getEventId(), created.getEventId());
        System.out.println(created.toString());
    }

    @Test
    void read() {

        Event read = repository.read(event.getEventId());
        assertNotNull(read);
        assertEquals(event.getEventId(), read.getEventId());
        System.out.println(read.toString());
    }

    @Test
    void update() {
        Event updatedEvent = new Event.Builder().copy(event).setTitle("Food parcels").build();
        Event updated = repository.update(updatedEvent);
        assertNotNull(updated);
        assertEquals(updatedEvent.getTitle(), updated.getTitle());
        System.out.println(updated.toString());
    }

    @Test
    void delete() {
        // Test deleting an event
        assertTrue(repository.delete(event.getEventId()));
        System.out.println("Event deleted");
    }

    @Test
    void getAll() {
     repository.create(event);
        List<Event> eventList = repository.getEventList();
        assertNotNull(eventList);
        assertTrue(eventList.size() > 0);
       System.out.println("All Events: " + eventList);
    }

}