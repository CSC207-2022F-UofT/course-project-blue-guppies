package create_task_use_case;

import entities.Day;
import entities.TaskFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import screens.ViewModel;
import screens.ViewModelBoundary;

import java.util.ArrayList;
import java.util.HashMap;


import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Task Creation Controller Test Cases.
 * @author Fardin Faruk
 */
public class CreateTaskControllerTest {
    static ViewModelBoundary VIEW_MODEL = getViewModel();
    private final static CreateTaskPresenter PRESENTER = new CreateTaskPresenter(VIEW_MODEL);
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
    public void testCreateTask(){
        CreateTaskInteractor interactor = new CreateTaskInteractor(
                TASK_FACTORY, PRESENTER, DATA_ACCESS
        );
        CreateTaskController controller = new CreateTaskController(interactor);
        CreateTaskOutputData outputData = controller.createTask(
                "Sunday",  "Sampled Task"
        );
        assertEquals("Sampled Task", outputData.getTitle());
        assertEquals(0, outputData.getDayIndex());
        assertTrue(outputData.isSuccessfullyCreated());
        assertTrue(DATA_ACCESS.existsByTitle("Sampled Task", 0));
    }

    @AfterEach
    public void clearStorage(){
        try {
            PrintWriter pw = new PrintWriter("CleanCalendarStorage.txt"); //deleting the contents of the file
            pw.close();
        }
        catch(IOException e){
            return;
        }
    }
}
