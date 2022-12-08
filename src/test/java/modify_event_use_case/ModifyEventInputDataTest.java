package modify_event_use_case;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ModifyEventInputData test cases.
 * @author Daniel Livshits
 */
class ModifyEventInputDataTest {
    final ModifyEventInputData inputData = new ModifyEventInputData("207 tutorail", 1, "207 tutorial",
            "10:00:00", "12:00:00");

    @Test
    void testGetTitle() {
        assertEquals("207 tutorail", inputData.getTitle());
    }

    @Test
    void testGetDayIndex() {
        assertEquals(1, inputData.getDayIndex());
    }

    @Test
    void testGetNewTitle() {
        assertEquals("207 tutorial", inputData.getNewTitle());
    }

    @Test
    void testGetNewStartTime() {
        assertEquals("10:00:00", inputData.getNewStartTime());
    }

    @Test
    void testGetNewEndTime() {
        assertEquals("12:00:00", inputData.getNewEndTime());
    }
}
