package delete_task_use_case;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeleteTaskPresenterTest {
    private final static DeleteTaskOutputData outputData = new DeleteTaskOutputData(
            5, "Task");
    private final static DeleteTaskOutputBoundary outputBoundary = new DeleteTaskPresenter();

    @Test
    void testPrepareSuccessView() {
        DeleteTaskOutputData response = outputBoundary.prepareSuccessView(outputData);

        assertTrue(response.isSuccess());
        assertEquals(5, response.getDayIndex());
        assertEquals("Task", response.getTaskTitle());
        assertNull(response.getErrorMessage());
    }

    @Test
    void testPrepareFailView(){
        DeleteTaskOutputData response = outputBoundary.prepareFailView(outputData, "Error");

        assertFalse(response.isSuccess());
        assertEquals(5, response.getDayIndex());
        assertEquals("Task", response.getTaskTitle());
        assertEquals("Error", response.getErrorMessage());

    }
}
