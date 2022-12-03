package modify_event_use_case;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ModifyEventDsInputData test cases.
 * @author Daniel Livshits
 */
class ModifyEventDsInputDataTest {
    ModifyEventDsInputData dsInputData = new ModifyEventDsInputData(2, "MAT224 Lecture", "Lunch",
            LocalTime.parse("13:00:00"), LocalTime.parse("14:00:00"));

    @Test
    void testGetDayIndex() {
        assertEquals(2, dsInputData.getDayIndex());
    }

    @Test
    void testGetTitle() {
        assertEquals("MAT224 Lecture", dsInputData.getTitle());
    }

    @Test
    void testGetNewTitle() {
        assertEquals("Lunch", dsInputData.getNewTitle());
    }

    @Test
    void testGetNewStartTime() {
        assertEquals(LocalTime.parse("13:00:00"), dsInputData.getNewStartTime());
    }

    @Test
    void testGetNewEndTime() {
        assertEquals(LocalTime.parse("14:00:00"), dsInputData.getNewEndTime());
    }
}
