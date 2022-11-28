package delete_task_use_case;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeleteTaskDsInputDataTest {
    DeleteTaskDsInputData dsInputData = new DeleteTaskDsInputData(0, "Homework");

    @Test
    void testGetTaskTitle() {
        assertEquals("Homework", dsInputData.getTaskTitle());
    }

    @Test
    void testGetDayIndex() {
        assertEquals(0, dsInputData.getDayIndex());
    }

}
