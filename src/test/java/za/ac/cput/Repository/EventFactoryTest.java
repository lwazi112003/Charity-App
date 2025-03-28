package za.ac.cput.Factory;
/* Event.java
   EventFactoryTest class
   Author: Simphiwe Thwabuse(220246009)
   Date: 27 March 2025
 */


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Event;

import static org.junit.jupiter.api.Assertions.*;

class EventFactoryTest {
    private static Event e1 = EventFactory.createEvent("E1001", "Equipment donation", "2025-04-15", "Foreshore", 250, 50);
    private static Event e2 = EventFactory.createEvent("E1002", "Food parcels", "2025-05-20", "Woodstock", 200, 100);
    private static Event e3 = EventFactory.createEvent("E1003", "Clothing donations", "2025-06-25", "Observatory", 40, 0);

    @Test
    @Order(1)
    public void testCreateEvent() {
        assertNotNull(e1);
        System.out.println(e1.toString());
    }

    @Test
    @Order(2)
    public void testCreateEventWithAllAttributes() {
        assertNotNull(e2);
        System.out.println(e2.toString());
    }

    @Test
    @Order(3)
    public void testCreateEventWithNoFunds() {
        assertNotNull(e3);
        System.out.println(e3.toString());
    }

    @Test
    @Disabled
    @Order(4)
    public void testNotImplementedYet() {
    }
}