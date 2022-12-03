package delete_event_use_case;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteEventInputDataTest {
    DeleteEventInputData inputData = new DeleteEventInputData(1, "CSC317 Kinematics");

    @Test
    void testGetTitle() {
        assertEquals("CSC317 Kinematics", inputData.getEventTitle());
    }

    @Test
    void testGetDayIndex() {
        assertEquals(1, inputData.getDayIndex());
    }
}
