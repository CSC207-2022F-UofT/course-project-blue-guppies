/**
 * @author : Name
 * @created: November 19th 2022
 * @since : 2022-11-28, Mon.
 **/

package delete_event_use_case;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

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
