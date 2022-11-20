package modify_task_use_case;

import data_access.WeekDataAccess;
import entities.Day;
import entities.Event;
import entities.Task;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModifyTaskControllerTest extends WeekDataAccess {
    private final static ModifyTaskPresenter outputBoundary = new ModifyTaskPresenter();
    private final static ModifyTaskDataAccess dsGateway = new ModifyTaskDataAccess();
    private final static int dayId = 0;
    private final static String newTitle = "New Sample Task";
    private final static String title = "Sample Task";

    @Test
    public void testModifyTask() {
        Task task = new Task("Sample Task");
        HashMap<String, Task> tasks = new HashMap<>();
        HashMap<String, Event> events = new HashMap<>();
        tasks.put("Sample Task", task);
        Day day = new Day(tasks, events);
        days.set(0, day);

        ModifyTaskInteractor inputBoundary = new ModifyTaskInteractor(
                outputBoundary, dsGateway
        );
        ModifyTaskController controller = new ModifyTaskController(inputBoundary);
        ModifyTaskOutputData outputData = controller.modifyTask(
                dayId, newTitle, title
        );
        assertEquals(0, outputData.getDayId());
        assertEquals("New Sample Task", outputData.getTitle());
    }
}
