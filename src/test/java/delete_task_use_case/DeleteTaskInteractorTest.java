package delete_task_use_case;

import entities.Day;
import entities.Event;
import entities.Task;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeleteTaskInteractorTest {
    private final static DeleteTaskInputData INPUT_DATA_1 = new DeleteTaskInputData(
            5, "Task");
    private final static DeleteTaskInputData INPUT_DATA_2 = new DeleteTaskInputData(
            0,"Task2");
    private final static DeleteTaskDataAccess DATA_ACCESS = new DeleteTaskDataAccess();
    private final static DeleteTaskDsGateway DS_GATEWAY = DATA_ACCESS;
    private final static DeleteTaskPresenter OUTPUT_BOUNDARY = new DeleteTaskPresenter();

    @Test
    void testDeleteTaskSuccess() {
        Task task = new Task("Task");
        HashMap<String, Task> tasks = new HashMap<>();
        HashMap<String, Event> events = new HashMap<>();
        tasks.put("Task", task);
        Day day = new Day(tasks, events);
        DATA_ACCESS.getDays().set(5, day);

        DeleteTaskInputBoundary inputBoundary = new DeleteTaskInteractor(OUTPUT_BOUNDARY, DS_GATEWAY);
        DeleteTaskOutputData outputData = inputBoundary.deleteTask(INPUT_DATA_1);

        assertEquals(5, outputData.getDayIndex());
        assertEquals("Task", outputData.getTaskTitle());
        assertFalse(DATA_ACCESS.getDays().get(5).getTasks().containsKey("Task"));
        assertFalse(DATA_ACCESS.getDays().get(5).getTasks().containsValue(task));
        assertTrue(outputData.isSuccess());
    }

    @Test
    void testDeleteTaskFail() {

        Task task = new Task("Task");
        HashMap<String, Task> tasks = new HashMap<>();
        HashMap<String, Event> events = new HashMap<>();
        tasks.put("Task", task);
        Day day = new Day(tasks, events);
        DATA_ACCESS.getDays().set(5, day);

        DeleteTaskInputBoundary inputBoundary = new DeleteTaskInteractor(OUTPUT_BOUNDARY, DS_GATEWAY);
        DeleteTaskOutputData outputData = inputBoundary.deleteTask(INPUT_DATA_2);

        assertEquals("Task Title: \"Task2\" does not exist for day Sunday", outputData.getErrorMessage());
        assertFalse(outputData.isSuccess());
        assertTrue(DATA_ACCESS.getDays().get(5).getTasks().containsKey("Task"));
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
