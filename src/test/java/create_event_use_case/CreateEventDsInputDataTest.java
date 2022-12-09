package create_event_use_case;

import entities.Event;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Create Ds Input Data Test Cases.
 * @author Raghav Arora, Anna Myllyniemi
 */
class CreateEventDsInputDataTest {
    static final Event EVENT = new Event("Sample Event", LocalTime.parse("09:00"),
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