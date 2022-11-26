package modify_event_use_case;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class ModifyEventInputDataTest {
    ModifyEventInputData inputData = new ModifyEventInputData("207 tutorail", 1, "207 tutorial",
            LocalTime.parse("10:00:00"), LocalTime.parse("12:00:00"));

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
        assertEquals(LocalTime.parse("10:00:00"), inputData.getNewStartTime());
    }

    @Test
    void testGetNewEndTime() {
        assertEquals(LocalTime.parse("12:00:00"), inputData.getNewEndTime());
    }
}
