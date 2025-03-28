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



        if (Helper.isNullorEmpty(eventId) ||
                Helper.isNullorEmpty(title) || Helper.isNullorEmpty(date)
                || Helper.isNullorEmpty(location) || targetAmount <= 0 ||
                currentAmount <= 0 ) {
            return null;
        }
        return new Event.Builder()
                .setEventId(eventId)
                .setTitle(title)
                .setDate(date)
                .setLocation(location)
                .setTargetAmount(targetAmount)
                .setCurrentAmount(currentAmount)
                .build();
    }

    public static Event createEventAllAttributes(String eventId, String title, String date, String location, int targetAmount, int currentAmount) {
        if (Helper.isNullorEmpty(eventId) ||
                Helper.isNullorEmpty(title)
                || Helper.isNullorEmpty(date) || Helper.isNullorEmpty(location) ||
                targetAmount <= 0 || currentAmount <= 0 ) {
            return null;
        }
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