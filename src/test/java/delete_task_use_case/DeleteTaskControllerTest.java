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

public class DeleteTaskControllerTest {
    private final static DeleteTaskOutputBoundary OUTPUT_BOUNDARY = new DeleteTaskPresenter();
    private final static DeleteTaskDataAccess DATA_ACCESS = new DeleteTaskDataAccess();
    private final static DeleteTaskDsGateway DS_GATEWAY = DATA_ACCESS;
    private final static DeleteTaskInteractor INPUT_BOUNDARY = new DeleteTaskInteractor(OUTPUT_BOUNDARY, DS_GATEWAY);
    private final static DeleteTaskController CONTROLLER = new DeleteTaskController(INPUT_BOUNDARY);
    private final static int DAY_INDEX = 5;
    private final static String TASK_TITLE = "Task";

    @Test
    void testDeleteTaskController() {
        Task task = new Task("Task");
        HashMap<String, Task> tasks = new HashMap<>();
        HashMap<String, Event> events = new HashMap<>();
        tasks.put("Task", task);

        Day day = new Day(tasks, events);
        WeekDataAccess.getDays().set(5, day);
        DeleteTaskOutputData outputData = CONTROLLER.deleteTask(DAY_INDEX, TASK_TITLE);

        assertEquals(5, outputData.getDayIndex());
        assertEquals("Task", outputData.getTaskTitle());
        assertTrue(outputData.isSuccess());
        assertFalse(WeekDataAccess.getDays().get(5).getTasks().containsKey("Task"));
        assertFalse(WeekDataAccess.getDays().get(5).getTasks().containsValue(task));
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
