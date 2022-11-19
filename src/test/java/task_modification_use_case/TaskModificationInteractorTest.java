package task_modification_use_case;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskModificationInteractorTest {
    private final static TaskModificationInputData inputData = new TaskModificationInputData(
            0,"New Sample Task", "Sample Task"
    );
    private final static TaskModificationPresenter outputBoundary = new TaskModificationPresenter();
    private final static TaskModificationDataAccess dsGateway = new TaskModificationDataAccess();

    @Test
    public void testModifyTask(){
        TaskModificationInputBoundary inputBoundary = new TaskModificationInteractor(
                outputBoundary, dsGateway
        );
        TaskModificationOutputData outputData = inputBoundary.modifyTask(
                inputData
        );
        assertEquals(0, outputData.getDayId());
        assertEquals("New Sample Task", outputData.getTitle());
    }

}