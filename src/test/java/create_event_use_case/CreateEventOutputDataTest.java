package create_event_use_case;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Create Event Output Data Test Cases.
 * @author Raghav Arora, Anna Myllyniemi
 */
class CreateEventOutputDataTest {
    CreateEventOutputData outputData = new CreateEventOutputData(
            "Sample Event", LocalTime.parse("09:00"),
            LocalTime.parse("10:00"), 0
    );

    CreateEventOutputData outputDataDefault = new CreateEventOutputData();

    @Test
    void testGetTitle() {
        assertEquals("Sample Event", outputData.getTitle());
    }

    @Test
    void testGetTitleDefault() {
        assertNull(outputDataDefault.getTitle());
    }

    @Test
    void testGetStartTime() {
        assertEquals(LocalTime.parse("09:00"), outputData.getStartTime());
    }

    @Test
    void testGetStartTimeDefault() {
        assertNull(outputDataDefault.getStartTime());
    }

    @Test
    void testGetEndTime() {
        assertEquals(LocalTime.parse("10:00"), outputData.getEndTime());
    }

    @Test
    void testGetEndTimeDefault() {
        assertNull(outputDataDefault.getEndTime());
    }

    @Test
    void testGetDayIndex() {
        assertEquals(0, outputData.getDayIndex());
    }

    @Test
    void testGetDayIndexDefault() {
        assertEquals(0, outputDataDefault.getDayIndex());
    }

    @Test
    void testGetIsSuccessfullyCreated() {
        assertFalse(outputData.isSuccess());
    }

    @Test
    void testGetIsSuccessfullyCreatedDefault() {
        assertFalse(outputDataDefault.isSuccess());
    }

    @Test
    void testSetSuccessfullyCreated() {
        outputData.setSuccess(true);
        assertTrue(outputData.isSuccess());
    }

    @Test
    void testGetErrorMessage() {
        assertEquals("", outputData.getErrorMessage());
    }

    @Test
    void testSetErrorMessage() {
        outputData.setErrorMessage("Error Message");
        assertEquals("Error Message", outputData.getErrorMessage());
    }
}