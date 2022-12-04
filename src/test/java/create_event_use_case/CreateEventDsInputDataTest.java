package create_event_use_case;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Create Ds Input Data Test Cases.
 * @author Raghav Arora
 */
class CreateEventDsInputDataTest {
    private final static CreateEventDsInputData dsInputData = new CreateEventDsInputData(
            "Sample Event",
            LocalTime.parse("09:00"),
            LocalTime.parse("10:00"),
            0
    );

    @Test
    void testGetTitle() {
        assertEquals("Sample Event", dsInputData.getTitle());
    }

    @Test
    void testSetTitle() {
        dsInputData.setTitle("Not Sample Event");
        assertEquals("Not Sample Event", dsInputData.getTitle());
    }

    @Test
    void testGetStartTime() {
        assertEquals(LocalTime.parse("09:00"), dsInputData.getStartTime());
    }

    @Test
    void testSetStartTime() {
        dsInputData.setStartTime(LocalTime.parse("09:30"));
        assertEquals(LocalTime.parse("09:30"), dsInputData.getStartTime());
    }

    @Test
    void testGetEndTime() {
        assertEquals(LocalTime.parse("10:00"), dsInputData.getEndTime());
    }

    @Test
    void testSetEndTime() {
        dsInputData.setEndTime(LocalTime.parse("10:30"));
        assertEquals(LocalTime.parse("10:30"), dsInputData.getEndTime());
    }

    @Test
    void testGetDayIndex() {
        assertEquals(0, dsInputData.getDayIndex());
    }

    @Test
    void testSetDayIndex() {
        dsInputData.setDayIndex(1);
        assertEquals(1, dsInputData.getDayIndex());
    }
}