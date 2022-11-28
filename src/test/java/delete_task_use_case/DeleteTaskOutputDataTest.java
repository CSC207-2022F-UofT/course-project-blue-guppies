package delete_task_use_case;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeleteTaskOutputDataTest {
    private final static DeleteTaskOutputData outputData = new DeleteTaskOutputData(6, "Midterm");

    @Test
    void getDayIndex() {
        assertEquals(6, outputData.getDayIndex());
    }

    @Test
    void getTaskTitle() {
        assertEquals("Midterm", outputData.getTaskTitle());
    }

    @Test
    void getSuccess() {
        assertFalse(outputData.getSuccess());
    }

    @Test
    void setSuccess() {
        outputData.setSuccess(true);
        assertTrue(outputData.getSuccess());
    }
}
