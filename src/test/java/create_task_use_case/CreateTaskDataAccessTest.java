package create_task_use_case;

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
 * Task Creation Data Access Test Cases.
 * @author Fardin Faruk
 */
public class CreateTaskDataAccessTest {
    @Test
    public void testExistsByTitleWithoutDuplicateTask(){
        CreateTaskDataAccess createTaskDataAccess = new CreateTaskDataAccess();
        boolean actual = createTaskDataAccess.existsByTitle("Check for task", 0);
        assertFalse(actual);
    }
    @Test
    public void testExistsByTitleWithDuplicateTask(){
        CreateTaskDataAccess createTaskDataAccess = new CreateTaskDataAccess();
        ArrayList<Day> days = WeekDataAccess.getDays();
        Day referenceDay = days.get(0);
        HashMap<String, Task> tasks = referenceDay.getTasks();
        Task newTask = new Task("Sample Task");
        tasks.put("Sample Task", newTask);
        boolean actual = createTaskDataAccess.existsByTitle("Sample Task",0);
        assertTrue(actual);
    }

    @Test
    public void testSave(){
        Task franklin = new Task("Franklin");
        CreateTaskDsInputData inputData = new CreateTaskDsInputData(franklin, 0);
        CreateTaskDataAccess createTaskDataAccess = new CreateTaskDataAccess();
        createTaskDataAccess.save(inputData);
        HashMap<String, Task> tasks = WeekDataAccess.getDays().get(0).getTasks();
        Task taskCheck = inputData.getTask();
        boolean existence = tasks.containsKey(inputData.getTask().getTitle());
        assertTrue(existence);
        assertEquals(franklin, taskCheck);
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
