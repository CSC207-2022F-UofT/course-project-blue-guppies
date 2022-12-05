package delete_task_use_case;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeleteTaskDsInputDataTest {
    private final static DeleteTaskDsInputData DS_INPUT_DATA = new DeleteTaskDsInputData(0, "Homework");

    @Test
    void testGetTaskTitle() {
        assertEquals("Homework", DS_INPUT_DATA.getTaskTitle());
    }

    @Test
    void testGetDayIndex() {
        assertEquals(0, DS_INPUT_DATA.getDayIndex());
    }

}
