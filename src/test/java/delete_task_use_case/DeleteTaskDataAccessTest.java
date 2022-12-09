package delete_task_use_case;

import data_access.WeekDataAccess;
import entities.Day;
import entities.Event;
import entities.Task;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

class DeleteTaskDataAccessTest {

    private final static DeleteTaskDataAccess DATA_ACCESS = new DeleteTaskDataAccess();
    private final static DeleteTaskDsInputData INPUT_DATA = new DeleteTaskDsInputData(3, "Homework");

    @Test
    void testSave() {
        Task task1 = new Task("Homework");
        Task task2 = new Task("Test");
        HashMap<String, Task> tasks = new HashMap<>();
        HashMap<String, Event> events = new HashMap<>();
        tasks.put("Homework", task1);
        tasks.put("Test", task2);
        Day day = new Day(tasks, events);
        WeekDataAccess.getDays().set(3, day);
        DATA_ACCESS.save(INPUT_DATA);

        assertFalse(WeekDataAccess.getDays().get(3).getTasks().containsKey("Homework"));
        assertTrue(WeekDataAccess.getDays().get(3).getTasks().containsKey("Test"));
    }

    @Test
    void testTaskExistsInDay() {
        Task task1 = new Task("Homework");
        Task task2 = new Task("Test");
        HashMap<String, Task> tasks = new HashMap<>();
        HashMap<String, Event> events = new HashMap<>();
        tasks.put("Homework", task1);
        tasks.put("Test", task2);
        Day day = new Day(tasks, events);
        WeekDataAccess.getDays().set(3, day);

        assertTrue(DATA_ACCESS.taskExistsInDay(3, "Homework"));
        assertFalse(DATA_ACCESS.taskExistsInDay(3, "Clean Room"));
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
