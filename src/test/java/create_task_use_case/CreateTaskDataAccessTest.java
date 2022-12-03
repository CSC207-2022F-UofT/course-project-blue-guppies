package create_task_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessTask;
import org.junit.jupiter.api.Test;


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
        ArrayList<DataAccessDay> days = createTaskDataAccess.getDays();
        DataAccessDay referenceDay = days.get(0);
        HashMap<String, DataAccessTask> tasks = referenceDay.getTasks();
        DataAccessTask newTask = new DataAccessTask("Sample Task");
        tasks.put("Sample Task", newTask);
        boolean actual = createTaskDataAccess.existsByTitle("Sample Task",0);
        assertTrue(actual);
    }

    @Test
    public void testSave(){
        CreateTaskDsInputData task = new CreateTaskDsInputData("Franklin", 0);
        CreateTaskDataAccess createTaskDataAccess = new CreateTaskDataAccess();
        createTaskDataAccess.save(task);
        HashMap<String, DataAccessTask> tasks = createTaskDataAccess.getDays().get(0).getTasks();
        DataAccessTask taskCheck = tasks.get(task.getTitle());
        boolean existence = tasks.containsKey(task.getTitle());
        assertTrue(existence);
        assertEquals(task.getTitle(), taskCheck.getTitle());
    }
}
