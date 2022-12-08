package complete_task_use_case;

import entities.Day;
import entities.Task;
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
 * Task Completion Controller Test Cases.
 * @author Fardin Faruk
 */
public class CompleteTaskControllerTest {
    static ViewModelBoundary VIEW_MODEL = getViewModel();
    private final static CompleteTaskPresenter PRESENTER = new CompleteTaskPresenter(VIEW_MODEL);
    private final static CompleteTaskDataAccess DATA_ACCESS = new CompleteTaskDataAccess();
    
    private static ViewModel getViewModel() {
        ArrayList<Day> days = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            days.add(new Day(new HashMap<>(), new HashMap<>()));
        }
        return new ViewModel(days);
    }

    @Test
    public void testCompleteTask(){
        CompleteTaskInteractor interactor = new CompleteTaskInteractor(PRESENTER, DATA_ACCESS);
        CompleteTaskController controller = new CompleteTaskController(interactor);
        Task task = new Task("Daniel");
        ArrayList<Day> days = DATA_ACCESS.getDays();
        Day day = days.get(0);
        day.getTasks().put(task.getTitle(), task);
        CompleteTaskOutputData outputData = controller.completeTask(0, "Daniel", false);
        assertTrue(task.getCompleted());
        assertEquals(task.getCompleted(), outputData.isSuccessfullyCompleted());

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
