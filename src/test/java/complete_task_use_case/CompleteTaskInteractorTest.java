package complete_task_use_case;

import entities.Day;
import entities.Task;
import org.junit.jupiter.api.Test;
import screens.ViewModel;
import screens.ViewModelBoundary;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Task Completion Interactor Test Cases.
 * @author Fardin Faruk
 */
public class CompleteTaskInteractorTest {
    static ViewModelBoundary VIEW_MODEL = getViewModel();

    public final static CompleteTaskOutputBoundary PRESENTER = new CompleteTaskPresenter(VIEW_MODEL);
    public final static CompleteTaskDataAccess DATA_ACCESS = new CompleteTaskDataAccess();

    private static ViewModel getViewModel() {
        ArrayList<Day> days = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            days.add(new Day(new HashMap<>(), new HashMap<>()));
        }
        return new ViewModel(days);
    }

    @Test
    public void testSuccessCompleteTask(){
        Task accessTask = new Task("Cricket");
        DATA_ACCESS.getDays().get(0).getTasks().put(accessTask.getTitle(),accessTask);
        CompleteTaskInteractor interactor = new CompleteTaskInteractor(PRESENTER, DATA_ACCESS);
        CompleteTaskInputData inputData = new CompleteTaskInputData(0, "Cricket", false);
        CompleteTaskOutputData outputData = interactor.completeTask(inputData);
        assertTrue(accessTask.getCompleted());
        assertTrue(outputData.isSuccessfullyCompleted());
    }
    @Test
    public void testFailCompleteTask(){
        DATA_ACCESS.getDays().get(0).getTasks().clear();
        CompleteTaskInteractor interactor = new CompleteTaskInteractor(PRESENTER, DATA_ACCESS);
        CompleteTaskInputData inputData = new CompleteTaskInputData(0, "Cricket", true);
        CompleteTaskOutputData outputData = interactor.completeTask(inputData);
        assertFalse(outputData.isSuccessfullyCompleted());
    }
}
