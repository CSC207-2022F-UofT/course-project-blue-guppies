package complete_task_use_case;

import data_access.DataAccessTask;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 * Task Completion Interactor Test Cases.
 * @author Fardin Faruk
 */
public class CompleteTaskInteractorTest {
    public final static CompleteTaskOutputBoundary PRESENTER = new CompleteTaskPresenter();
    public final static CompleteTaskDataAccess DATA_ACCESS = new CompleteTaskDataAccess();

    @Test
    public void testCompleteTask(){
        DataAccessTask accessTask = new DataAccessTask("Cricket");
        DATA_ACCESS.getDays().get(0).getTasks().put(accessTask.getTitle(),accessTask);
        CompleteTaskInteractor interactor = new CompleteTaskInteractor(PRESENTER, DATA_ACCESS);
        CompleteTaskInputData inputData = new CompleteTaskInputData(0, "Cricket");
        CompleteTaskOutputData outputData = interactor.completeTask(inputData);
        DataAccessTask referenceTask = DATA_ACCESS.getDays().get(0).getTasks().get(accessTask.getTitle());
        assertTrue(accessTask.getCompleted());
        assertTrue(outputData.isSuccessfullyCompleted());
    }
}
