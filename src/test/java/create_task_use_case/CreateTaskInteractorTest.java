package create_task_use_case;

import data_access.WeekDataAccess;
import entities.Day;
import entities.Task;
import entities.TaskFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import screens.ViewModel;
import screens.ViewModelBoundary;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Task Creation Interactor Test Cases.
 * @author Fardin Faruk
 */
public class CreateTaskInteractorTest {
    private final static ViewModelBoundary VIEW_MODEL = getViewModel();
    private final static CreateTaskOutputBoundary PRESENTER = new CreateTaskPresenter(VIEW_MODEL);
    private final static CreateTaskDataAccess DATA_ACCESS = new CreateTaskDataAccess();
    private final static TaskFactory TASK_FACTORY = new TaskFactory();

    private static ViewModel getViewModel() {
        ArrayList<Day> days = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            days.add(new Day(new HashMap<>(), new HashMap<>()));
        }
        return new ViewModel(days);
    }
    @Test
    public void createTestSuccess(){
        CreateTaskInputData inputData = new CreateTaskInputData("Finish Unit Test", 2);
        CreateTaskInteractor createTaskInteractor = new CreateTaskInteractor(TASK_FACTORY, PRESENTER,
                DATA_ACCESS );
        CreateTaskOutputData createTaskOutputData = createTaskInteractor.create(inputData);
        Day day = WeekDataAccess.getDays().get(2);
        HashMap<String, Task> tasks = day.getTasks();
        Task referenceTask = tasks.get("Finish Unit Test");
        assertTrue(createTaskOutputData.isSuccessfullyCreated());
        assertEquals(2, createTaskOutputData.getDayIndex());
        assertTrue(DATA_ACCESS.existsByTitle("Finish Unit Test", 2));
        assertEquals("Finish Unit Test", referenceTask.getTitle());
    }
    @Test
    public void createTestFail(){
        CreateTaskInputData inputData = new CreateTaskInputData("Update", 2);
        CreateTaskInteractor createTaskInteractor = new CreateTaskInteractor(TASK_FACTORY, PRESENTER,
                DATA_ACCESS);
        // Add Task twice to mock adding duplicate task on the same day
        createTaskInteractor.create(inputData);
        CreateTaskOutputData createTaskOutputData = createTaskInteractor.create(inputData);
        assertEquals("There already exists a task with name: 'Update' on Tuesday",
                createTaskOutputData.getErrorMessage());
    }

    @AfterEach
    public void clearStorage(){
        try {
            PrintWriter pw = new PrintWriter("CleanCalendarStorage.txt"); //deleting the contents of the file
            pw.close();
        }
        catch(IOException ignored){
        }
    }
}
