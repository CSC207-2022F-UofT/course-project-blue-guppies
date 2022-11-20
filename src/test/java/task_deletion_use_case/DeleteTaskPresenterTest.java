package task_deletion_use_case;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeleteTaskPresenterTest {
    private final static DeleteTaskOutputData success = new DeleteTaskOutputData(
            5, "Task");

    @Test
    public void testPrepareSuccessView() {
        DeleteTaskOutputBoundary outputBoundary = new DeleteTaskPresenter();
        DeleteTaskOutputData response = outputBoundary.prepareFailView(success);

        assertFalse(response.getSuccess());
        assertEquals(5, response.getInputDay());
        assertEquals("Task", response.getLabel());
    }
}