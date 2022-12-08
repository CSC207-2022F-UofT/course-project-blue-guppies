package modify_task_use_case;

import entities.Day;
import entities.Event;
import entities.Task;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Task Modification Data Access Test Cases.
 * @author Raghav Arora
 */
class ModifyTaskDataAccessTest {
    private final static ModifyTaskDataAccess dsGateway = new ModifyTaskDataAccess();
    private final static ModifyTaskDsInputData dsInputData = new ModifyTaskDsInputData(
        0, "New Sample Task 1", "Sample Task 1"
    );

    @Test
    void testTaskExistsByTitle() {
        Task task1 = new Task("Sample Task 1");
        Task task2 = new Task("Sample Task 2");

        HashMap<String, Task> tasks = new HashMap<>();
        HashMap<String, Event> events = new HashMap<>();
        tasks.put("Sample Task 1", task1);
        tasks.put("Sample Task 2", task2);

        Day day = new Day(tasks, events);
        dsGateway.getDays().set(0, day);

        assertFalse(dsGateway.taskExistsByTitle("New Sample Task 1", 0));
        assertTrue(dsGateway.taskExistsByTitle("Sample Task 2", 0));
    }

    @Test
    void testSave() {
        Task task1 = new Task("Sample Task 1");
        Task task2 = new Task("Sample Task 2");

        HashMap<String, Task> tasks = new HashMap<>();
        HashMap<String, Event> events = new HashMap<>();
        tasks.put("Sample Task 1", task1);
        tasks.put("Sample Task 2", task2);

        Day day = new Day(tasks, events);
        dsGateway.getDays().set(0, day);

        // change the name of "Sample Task 1" to "New Sample Task 1"
        dsGateway.save(dsInputData);
        Day day0 = dsGateway.getDays().get(0);
        assertFalse(day0.getTasks().containsKey("Sample Task 1"));
        assertTrue(day0.getTasks().containsKey("New Sample Task 1"));
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
