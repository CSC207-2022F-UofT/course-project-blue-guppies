/**
 * Task Modification Input Data Test Cases.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 26, 2022
 * Last Modified: Nov 26, 2022
 */
package modify_task_use_case;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ModifyTaskInputDataTest {
    private final static ModifyTaskInputData inputData = new ModifyTaskInputData(
            0, "New Title", "Title"
    );

    @Test
    void testGetNewTitle() {
        assertEquals("New Title", inputData.getNewTitle());
    }

    @Test
    void testGetDayID() {
        assertEquals(0, inputData.getDayID());
    }

    @Test
    void testGetTitle() {
        assertEquals("Title", inputData.getTitle());
    }

    @Test
    void testSetTitle() {
        inputData.setTitle("Very New Title");
        assertEquals("Very New Title", inputData.getTitle());
    }
}
