package za.ac.cput.Factory;
/* Event.java
   EventFactory class
   Author: Simphiwe Thwabuse(220246009)
   Date: 27 March 2025
 */
import za.ac.cput.Domain.Event;
import za.ac.cput.util.Helper;

public class EventFactory {

    public static Event createEvent(String eventId, String title, String date, String location, int targetAmount, int currentAmount) {
        // Validate inputs
        if (Helper.isNullOrEmpty(eventId) ||
                Helper.isNullOrEmpty(title) ||
                Helper.isNullOrEmpty(date) ||
                Helper.isNullOrEmpty(location) ||
                targetAmount <= 0 ||
                currentAmount < 0) { // Allow currentAmount to be 0
            throw new IllegalArgumentException("Invalid input for creating an event.");
        }

        // Create and return the Event object using the Builder pattern
        return new Event.Builder()
                .setEventId(eventId)
                .setTitle(title)
                .setDate(date)
                .setLocation(location)
                .setTargetAmount(targetAmount)
                .setCurrentAmount(currentAmount)
                .build();
    }
}