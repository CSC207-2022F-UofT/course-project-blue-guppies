package complete_task_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessTask;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Task Completion Controller Test Cases.
 * @author Fardin Faruk
 */
public class CompleteTaskControllerTest {
    private final static CompleteTaskPresenter PRESENTER = new CompleteTaskPresenter();
    private final static CompleteTaskDataAccess DATA_ACCESS = new CompleteTaskDataAccess();

    @Test
    public void testCompleteTask(){
        CompleteTaskInteractor interactor = new CompleteTaskInteractor(PRESENTER, DATA_ACCESS);
        CompleteTaskController controller = new CompleteTaskController(interactor);
        DataAccessTask task = new DataAccessTask("Daniel");
        ArrayList<DataAccessDay> days = DATA_ACCESS.getDays();
        DataAccessDay day = days.get(0);
        day.getTasks().put(task.getTitle(), task);
        CompleteTaskOutputData outputData = controller.completeTask(0, "Daniel");
        assertTrue(task.getCompleted());
        assertEquals(task.getCompleted(), outputData.isSuccessfullyCompleted());

    }

}
