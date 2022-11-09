package entities;

import org.junit.jupiter.api.Test;

import java.sql.Time;

import static org.junit.jupiter.api.Assertions.*;

class EventFactoryTest {

    @Test
    void createEventTest() {
        EventFactory factory = new EventFactory();
        Event festival = factory.createEvent("festival", new Time(5000000), new Time(60000000));
        assertEquals("festival", festival.getTitle());
        assertEquals(5000000, festival.getStartTime().getTime());
        assertEquals(60000000, festival.getEndTime().getTime());
    }
}