package create_event_use_case;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Create Event Input Data Test Cases.
 * @author Raghav Arora
 */
class CreateEventInputDataTest {
    private final static CreateEventInputData inputData = new CreateEventInputData(
            "Sample Event", "09:00", "10:00", "Sunday"
    );

    @Test
    void testGetTitle() {
        assertEquals("Sample Event", inputData.getTitle());
    }

    @Test
    void testGetStartTime() {
        assertEquals("09:00", inputData.getStartTime());
    }

    @Test
    void testGetEndTime() {
        assertEquals("10:00", inputData.getEndTime());
    }

    @Test
    void testGetDayIndex() {
        assertEquals(0, inputData.getDayIndex());
    }
}