package delete_task_use_case;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeleteTaskPresenterTest {
    private final static DeleteTaskOutputData OUTPUT_DATA = new DeleteTaskOutputData(
            5, "Task");
    private final static DeleteTaskOutputBoundary OUTPUT_BOUNDARY = new DeleteTaskPresenter();

    @Test
    void testPrepareSuccessView() {
        DeleteTaskOutputData response = OUTPUT_BOUNDARY.prepareSuccessView(OUTPUT_DATA);

        assertTrue(response.isSuccess());
        assertEquals(5, response.getDayIndex());
        assertEquals("Task", response.getTaskTitle());
        assertNull(response.getErrorMessage());
    }

    @Test
    void testPrepareFailView(){
        DeleteTaskOutputData response = OUTPUT_BOUNDARY.prepareFailView(OUTPUT_DATA, "Error");

        assertFalse(response.isSuccess());
        assertEquals(5, response.getDayIndex());
        assertEquals("Task", response.getTaskTitle());
        assertEquals("Error", response.getErrorMessage());

    }
}
