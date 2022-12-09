package modify_task_use_case;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Task Modification Ds Input Data Test Cases.
 * @author Raghav Arora
 */
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
        assertEquals(0, dsInputData.getDayIndex());
    }

    @Test
    void testGetTitle() {
        assertEquals("Old Task", dsInputData.getTitle());
    }

}
