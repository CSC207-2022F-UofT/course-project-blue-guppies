package create_event_use_case;

import entities.Event;
import entities.EventFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Create Ds Input Data Test Cases.
 * @author Raghav Arora, Anna Myllyniemi
 */
class CreateEventDsInputDataTest {
    private final static EventFactory EVENT_FACTORY = new EventFactory();
    static Event EVENT = EVENT_FACTORY.createEvent("Sample Event", LocalTime.parse("09:00"),
            LocalTime.parse("10:00"));

    private final static CreateEventDsInputData DS_INPUT_DATA = new CreateEventDsInputData(0, EVENT);

    @Test
    void testGetTitle() {
        assertEquals("Sample Event", DS_INPUT_DATA.getTitle());
    }


    @Test
    void testGetStartTime() {
        assertEquals(LocalTime.parse("09:00"), DS_INPUT_DATA.getStartTime());
    }

    @Test
    void testGetEndTime() {
        assertEquals(LocalTime.parse("10:00"), DS_INPUT_DATA.getEndTime());
    }


    @Test
    void testGetDayIndex() {
        assertEquals(0, DS_INPUT_DATA.getDayIndex());
    }

    @Test
    void testGetNewEvent() {
        assertEquals(EVENT.getTitle(), DS_INPUT_DATA.getNewEvent().getTitle());
        assertEquals(EVENT.getStartTime(), DS_INPUT_DATA.getNewEvent().getStartTime());
        assertEquals(EVENT.getEndTime(), DS_INPUT_DATA.getNewEvent().getEndTime());
    }
}