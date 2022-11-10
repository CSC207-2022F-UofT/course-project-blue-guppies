package entities;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class EventFactoryTest {

    @Test
    void createEventTest() {
        EventFactory factory = new EventFactory();
        Event festival = factory.createEvent("festival", LocalTime.parse("01:23:20"),
                LocalTime.parse("16:40"));
        assertEquals("festival", festival.getTitle());
        assertEquals(LocalTime.parse("01:23:20"), festival.getStartTime());
        assertEquals(LocalTime.parse("16:40"), festival.getEndTime());
    }
}