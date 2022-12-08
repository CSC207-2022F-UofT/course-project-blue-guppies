package complete_task_use_case;

import entities.Day;
import org.junit.jupiter.api.Test;
import screens.ViewModel;
import screens.ViewModelBoundary;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Task Completion Presenter Test Cases.
 * @author Fardin Faruk
 */
public class CompleteTaskPresenterTest {
    static ViewModelBoundary VIEW_MODEL = getViewModel();

    private static ViewModel getViewModel() {
        ArrayList<Day> days = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            days.add(new Day(new HashMap<>(), new HashMap<>()));
        }
        return new ViewModel(days);
    }
    @Test
    public void TestPrepareSuccessView(){
        CompleteTaskOutputData completeTaskOutputData = new CompleteTaskOutputData("Test Task",  2,
                true);
        CompleteTaskPresenter completeTaskPresenter = new CompleteTaskPresenter(VIEW_MODEL);
        CompleteTaskOutputData outputData = completeTaskPresenter.prepareSuccessView(completeTaskOutputData);
        assertTrue(outputData.isSuccessfullyCompleted());
    }

    @Test
    public void TestPrepareFailView(){
        CompleteTaskOutputData completeTaskOutputData = new CompleteTaskOutputData("Test Task", 3,
                true);
        CompleteTaskPresenter completeTaskPresenter = new CompleteTaskPresenter(VIEW_MODEL);
        CompleteTaskOutputData outputData = completeTaskPresenter.prepareFailView(completeTaskOutputData,
                "There does not exist a task with name: 'Test Task' on Wednesday");
        assertFalse(outputData.isSuccessfullyCompleted());
        assertEquals(outputData.getErrorMessage(),
                "There does not exist a task with name: 'Test Task' on Wednesday");
    }
}
