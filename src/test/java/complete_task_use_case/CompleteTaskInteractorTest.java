package complete_task_use_case;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompleteTaskInteractorTest {
    public final static CompleteTaskOutputBoundary presenter = new CompleteTaskPresenter();
    public final static CompleteTaskDataAccess dataAccess = new CompleteTaskDataAccess();

    @Test
    public void testCompleteTask(){
        CompleteTaskInteractor interactor = new CompleteTaskInteractor(presenter, dataAccess);
        CompleteTaskInputData inputData = new CompleteTaskInputData(0, "Cricket");
        CompleteTaskOutputData outputData = interactor.completeTask(inputData);
        assertTrue(outputData.isSuccessfullyCreated());
    }

}
