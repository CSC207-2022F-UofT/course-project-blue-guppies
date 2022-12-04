package create_event_use_case;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Create Event Input Data Test Cases.
 * @author Raghav Arora, Anna Myllyniemi
 */
class CreateEventInputDataTest {
    private final static CreateEventInputData INPUT_DATA = new CreateEventInputData(
            "Sample Event", "09:00", "10:00", "Sunday"
    );

    @Test
    void testGetTitle() {
        assertEquals("Sample Event", INPUT_DATA.getTitle());
    }

    @Test
    void testGetStartTime() {
        assertEquals("09:00", INPUT_DATA.getStartTime());
    }

    @Test
    void testGetEndTime() {
        assertEquals("10:00", INPUT_DATA.getEndTime());
    }

    @Test
    void testGetDayIndexSunday() {
        assertEquals(0, INPUT_DATA.getDayIndex());
    }

    @Test
    void testGetDayIndexMonday() {
        CreateEventInputData inputData1 = new CreateEventInputData(
                "Sample Event", "09:00", "10:00", "Monday"
        );
        assertEquals(1, inputData1.getDayIndex());
    }

    @Test
    void testGetDayIndexTuesday() {
        CreateEventInputData inputData1 = new CreateEventInputData(
                "Sample Event", "09:00", "10:00", "Tuesday"
        );
        assertEquals(2, inputData1.getDayIndex());
    }

    @Test
    void testGetDayIndexWednesday() {
        CreateEventInputData inputData1 = new CreateEventInputData(
                "Sample Event", "09:00", "10:00", "Wednesday"
        );
        assertEquals(3, inputData1.getDayIndex());
    }

    @Test
    void testGetDayIndexThursday() {
        CreateEventInputData inputData1 = new CreateEventInputData(
                "Sample Event", "09:00", "10:00", "Thursday"
        );
        assertEquals(4, inputData1.getDayIndex());
    }

    @Test
    void testGetDayIndexFriday() {
        CreateEventInputData inputData1 = new CreateEventInputData(
                "Sample Event", "09:00", "10:00", "Friday"
        );
        assertEquals(5, inputData1.getDayIndex());
    }

    @Test
    void testGetDayIndexSaturday() {
        CreateEventInputData inputData1 = new CreateEventInputData(
                "Sample Event", "09:00", "10:00", "Saturday"
        );
        assertEquals(6, inputData1.getDayIndex());
    }
}