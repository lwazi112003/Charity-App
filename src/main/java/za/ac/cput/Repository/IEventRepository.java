package za.ac.cput.Repository;

import za.ac.cput.Domain.Event;

import java.util.List;

public interface IEventRepository extends IRepository<Event, String> {

    List<Event> getEventList();
}
