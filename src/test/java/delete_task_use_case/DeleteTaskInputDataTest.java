package delete_task_use_case;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeleteTaskInputDataTest {

    DeleteTaskInputData inputData = new DeleteTaskInputData(4, "Term Test");

    @Test
    void getDayIndex() {
        assertEquals(4, inputData.getDayIndex());
    }

    @Test
    void getTaskTitle() {
        assertEquals("Term Test", inputData.getTaskTitle());
    }
}
