package delete_task_use_case;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeleteTaskInputDataTest {

    private final static DeleteTaskInputData inputData = new DeleteTaskInputData(4, "Term Test");

    @Test
    void testGetDayIndex() {
        assertEquals(4, inputData.getDayIndex());
    }

    @Test
    void testGetTaskTitle() {
        assertEquals("Term Test", inputData.getTaskTitle());
    }
}
