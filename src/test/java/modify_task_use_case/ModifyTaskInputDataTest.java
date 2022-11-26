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
