package delete_task_use_case;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeleteTaskOutputDataTest {
    private final static DeleteTaskOutputData OUTPUT_DATA = new DeleteTaskOutputData(6, "Midterm");

    @Test
    void testGetDayIndex() {
        assertEquals(6, OUTPUT_DATA.getDayIndex());
    }

    @Test
    void testGetTaskTitle() {
        assertEquals("Midterm", OUTPUT_DATA.getTaskTitle());
    }

    @Test
    void testGetSuccess() {
        assertFalse(OUTPUT_DATA.isSuccess());
    }

    @Test
    void testSetSuccess() {
        OUTPUT_DATA.setSuccess(true);
        assertTrue(OUTPUT_DATA.isSuccess());
    }

    @Test
    void testGetErrorMessage() {
        assertNull(OUTPUT_DATA.getErrorMessage());
    }

    @Test
    void testSetErrorMessage() {
        OUTPUT_DATA.setErrorMessage("Error");
        assertEquals("Error", OUTPUT_DATA.getErrorMessage());
    }
}
