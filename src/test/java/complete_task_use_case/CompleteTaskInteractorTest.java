package complete_task_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessTask;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompleteTaskInteractorTest {
    public final static CompleteTaskOutputBoundary presenter = new CompleteTaskPresenter();
    public final static CompleteTaskDataAccess dataAccess = new CompleteTaskDataAccess();

    @Test
    public void testCompleteTask(){
        DataAccessTask task = new DataAccessTask("Cricket");
        dataAccess.getDays().get(0).getTasks().put(task.getTitle(),task);
        CompleteTaskInteractor interactor = new CompleteTaskInteractor(presenter, dataAccess);
        CompleteTaskInputData inputData = new CompleteTaskInputData("Sunday", "Cricket");
        CompleteTaskOutputData outputData = interactor.completeTask(inputData);
        assertTrue(outputData.isSuccessfullyCreated());
    }

}
