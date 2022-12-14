package modify_task_use_case;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Task Modification Input Data Test Cases.
 * @author Raghav Arora
 */
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
        assertEquals(0, inputData.getDayIndex());
    }

    @Test
    void testGetTitle() {
        assertEquals("Title", inputData.getTitle());
    }

}
