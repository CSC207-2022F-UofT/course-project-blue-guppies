package delete_task_use_case;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeleteTaskInputDataTest {

    private final static DeleteTaskInputData INPUT_DATA = new DeleteTaskInputData(4, "Term Test");

    @Test
    void testGetDayIndex() {
        assertEquals(4, INPUT_DATA.getDayIndex());
    }

    @Test
    void testGetTaskTitle() {
        assertEquals("Term Test", INPUT_DATA.getTaskTitle());
    }
}
