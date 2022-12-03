package modify_event_use_case;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ModifyEventOutputData test cases.
 * @author Daniel Livshits
 */
class ModifyEventOutputDataTest {
    ModifyEventOutputData outputData = new ModifyEventOutputData("207 tutorail", 1, "207 tutorial",
            LocalTime.parse("10:00:00"), LocalTime.parse("12:00:00"));

    @Test
    void testGetTitle() {
        assertEquals("207 tutorail", outputData.getTitle());
    }

    @Test
    void testGetDayIndex() {
        assertEquals(1, outputData.getDayIndex());
    }

    @Test
    void testGetNewTitle() {
        assertEquals("207 tutorial", outputData.getNewTitle());
    }

    @Test
    void testGetNewStartTime() {
        assertEquals(LocalTime.parse("10:00:00"), outputData.getNewStartTime());
    }

    @Test
    void testGetNewEndTime() {
        assertEquals(LocalTime.parse("12:00:00"), outputData.getNewEndTime());
    }

    @Test
    void testGetSuccessfullyModified() {
        assertTrue(outputData.getSuccessfullyModified());
    }

    @Test
    void testSetSuccessfullyModified() {
        outputData.setSuccessfullyModified(false);
        assertFalse(outputData.getSuccessfullyModified());
    }

    @Test
    void testGetFailureType() {
        assertNull(outputData.getFailureMessage());
    }

    @Test
    void testSetFailureType() {
        outputData.setFailureMessage("Title");
        assertEquals("Title", outputData.getFailureMessage());
        outputData.setFailureMessage("Time");
        assertEquals("Time", outputData.getFailureMessage());
    }
}
