package complete_task_use_case;

import data_access.WeekDataAccess;
import entities.Day;
import entities.Task;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Task Completion Data Access Test Cases.
 * @author Fardin Faruk
 */
public class CompleteTaskDataAccessTest {
    @Test
    public void testExistsByTitleWithoutDuplicateTask(){
        CompleteTaskDataAccess dataAccess = new CompleteTaskDataAccess();
        boolean actual = dataAccess.existsByTitle("Check for task", 0);
        assertFalse(actual);
    }

    @Test
    public void testExistsByTitleWithDuplicateTask(){
        CompleteTaskDataAccess dataAccess = new CompleteTaskDataAccess();
        ArrayList<Day> days = WeekDataAccess.getDays();
        Day referenceDay = days.get(0);
        HashMap<String, Task> tasks = referenceDay.getTasks();
        Task newTask = new Task("Sample Task");
        tasks.put("Sample Task", newTask);
        boolean actual = dataAccess.existsByTitle("Sample Task",0);
        assertTrue(actual);
    }

    @Test
    public void testSave(){
        CompleteTaskDataAccess dataAccess = new CompleteTaskDataAccess();
        Task dataAccessTask = new Task("Watch World Cup");
        CompleteTaskDsInputData task = new CompleteTaskDsInputData(0, "Watch World Cup");
        WeekDataAccess.getDays().get(0).getTasks().put(dataAccessTask.getTitle(), dataAccessTask);
        dataAccess.save(task);
        HashMap<String, Task> tasks = WeekDataAccess.getDays().get(0).getTasks();
        Task taskCheck = tasks.get(task.getTitle());
        assertTrue(taskCheck.getCompleted());
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
