package create_task_use_case;

import entities.Day;
import org.junit.jupiter.api.Test;
import screens.ViewModel;
import screens.ViewModelBoundary;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Task Creation Presenter Test Cases.
 * @author Fardin Faruk
 */
public class CreateTaskPresenterTest {
    private final static ViewModelBoundary VIEW_MODEL = getViewModel();

    private static ViewModel getViewModel() {
        ArrayList<Day> days = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            days.add(new Day(new HashMap<>(), new HashMap<>()));
        }
        return new ViewModel(days);
    }
    @Test
    public void TestPrepareSuccessView(){
        CreateTaskOutputData createTaskOutputData = new CreateTaskOutputData("Test Task",  0);
        CreateTaskPresenter createTaskPresenter = new CreateTaskPresenter(VIEW_MODEL);
        CreateTaskOutputData outputData = createTaskPresenter.prepareSuccessView(createTaskOutputData);
        assertTrue(outputData.isSuccessfullyCreated());
    }
    @Test
    public void TestPrepareFailView(){
        CreateTaskOutputData createTaskOutputData = new CreateTaskOutputData("Test Task", 0);
        CreateTaskPresenter createTaskPresenter = new CreateTaskPresenter(VIEW_MODEL);
        CreateTaskOutputData outputData = createTaskPresenter.prepareFailView(createTaskOutputData,
                "There already exists a task with name: 'Test Task' on Wednesday");
        assertFalse(outputData.isSuccessfullyCreated());
        assertEquals(outputData.getErrorMessage(),
                "There already exists a task with name: 'Test Task' on Wednesday");
    }
}
