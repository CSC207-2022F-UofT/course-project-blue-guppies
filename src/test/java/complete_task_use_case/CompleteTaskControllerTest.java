package complete_task_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessTask;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CompleteTaskControllerTest {
    private final static CompleteTaskPresenter presenter = new CompleteTaskPresenter();
    private final static CompleteTaskDataAccess dataAccess = new CompleteTaskDataAccess();

    @Test
    public void testCompleteTask(){
        CompleteTaskInteractor interactor = new CompleteTaskInteractor(presenter, dataAccess);
        CompleteTaskController controller = new CompleteTaskController(interactor);
        DataAccessTask task = new DataAccessTask("Daniel");
        ArrayList<DataAccessDay> days = dataAccess.getDays();
        DataAccessDay day = days.get(0);
        day.getTasks().put(task.getTitle(), task);
        controller.complete("Sunday", "Daniel");
        assertTrue(task.getCompleted());
    }

}
