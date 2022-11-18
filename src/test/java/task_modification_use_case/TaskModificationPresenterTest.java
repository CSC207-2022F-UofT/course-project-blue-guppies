package task_modification_use_case;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class TaskModificationPresenterTest {
    //task and event instances (and maps) to be used across tests.
    private final static TaskModificationResponseModel task = new TaskModificationResponseModel(
            "Sample Task", 0
    );
    private final static String error = "ERROR!";

    @Test
    public void testPrepareSuccessView(){
        TaskModificationOutputBoundary outputBoundary = new TaskModificationPresenter();
        TaskModificationResponseModel responseModel = outputBoundary.prepareSuccessView(
                task
        );
        assertEquals(task.getDayId(), responseModel.getDayId());
        assertEquals(task.getTitle(), responseModel.getTitle());
    }

    @Test
    public void testPrepareFailView(){
        TaskModificationOutputBoundary outputBoundary = new TaskModificationPresenter();
        try {
            TaskModificationResponseModel responseModel = outputBoundary.prepareFailView(
                    error
            );
        } catch (TaskModificationFailed e) {
            assertEquals("ERROR!", e.getMessage());
        }
    }
}