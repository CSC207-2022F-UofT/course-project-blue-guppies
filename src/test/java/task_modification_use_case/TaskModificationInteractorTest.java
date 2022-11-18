package task_modification_use_case;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskModificationInteractorTest {
    private final static TaskModificationRequestModel task = new TaskModificationRequestModel(
            0,"New Sample Task", "Sample Task"
    );
    private final static TaskModificationPresenter outputBoundary = new TaskModificationPresenter();
    private final static TaskModificationDataAccess dsGateway = new TaskModificationDataAccess();

    @Test
    public void testModifyTask(){
        TaskModificationInputBoundary inputBoundary = new TaskModificationInteractor(
                outputBoundary, dsGateway
        );
        TaskModificationResponseModel responseModel = inputBoundary.modifyTask(
                task
        );
        assertEquals(0, responseModel.getDayId());
        assertEquals("New Sample Task", responseModel.getTitle());
    }

}