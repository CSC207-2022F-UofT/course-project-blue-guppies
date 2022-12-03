package delete_task_use_case;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeleteTaskOutputDataTest {
    private final static DeleteTaskOutputData outputData = new DeleteTaskOutputData(6, "Midterm");

    @Test
    void testGetDayIndex() {
        assertEquals(6, outputData.getDayIndex());
    }

    @Test
    void testGetTaskTitle() {
        assertEquals("Midterm", outputData.getTaskTitle());
    }

    @Test
    void testGetSuccess() {
        assertFalse(outputData.isSuccess());
    }

    @Test
    void testSetSuccess() {
        outputData.setSuccess(true);
        assertTrue(outputData.isSuccess());
    }

    @Test
    void testGetErrorMessage() {
        assertNull(outputData.getErrorMessage());
    }

    @Test
    void testSetErrorMessage() {
        outputData.setErrorMessage("Error");
        assertEquals("Error", outputData.getErrorMessage());
    }
}
