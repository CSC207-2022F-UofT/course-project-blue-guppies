package modify_task_use_case;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ModifyTaskDsInputDataTest {
    private final static ModifyTaskDsInputData dsInputData = new ModifyTaskDsInputData(
            0, "New Task", "Old Task"
    );

    @Test
    void testGetNewTitle() {
        assertEquals("New Task", dsInputData.getNewTitle());
    }

    @Test
    void testGetDayID() {
        assertEquals(0, dsInputData.getDayID());
    }

    @Test
    void testGetTitle() {
        assertEquals("Old Task", dsInputData.getTitle());
    }

    @Test
    void testSetTitle() {
        dsInputData.setTitle("Very New Task");
        assertEquals("Very New Task", dsInputData.getTitle());
    }

}
