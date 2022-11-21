package modify_task_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessEvent;
import data_access.DataAccessTask;
import data_access.WeekDataAccess;

import java.util.HashMap;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ModifyTaskControllerTest extends WeekDataAccess {
    private final static ModifyTaskPresenter outputBoundary = new ModifyTaskPresenter();
    private final static ModifyTaskDataAccess dsGateway = new ModifyTaskDataAccess();
    private final static int dayId = 0;
    private final static String newTitle = "New Sample Task";
    private final static String title = "Sample Task";

    @Test
    public void testModifyTask() {
        DataAccessTask task = new DataAccessTask("Sample Task");
        HashMap<String, DataAccessTask> tasks = new HashMap<>();
        HashMap<String, DataAccessEvent> events = new HashMap<>();
        tasks.put("Sample Task", task);
        DataAccessDay day = new DataAccessDay(tasks, events);
        this.days.set(0, day);

        ModifyTaskInteractor inputBoundary = new ModifyTaskInteractor(
                outputBoundary,
                dsGateway
        );
        ModifyTaskController controller = new ModifyTaskController(inputBoundary);
        ModifyTaskOutputData outputData = controller.modifyTask(
                dayId, newTitle, title
        );
        assertEquals(0, outputData.getDayId());
        assertEquals("New Sample Task", outputData.getTitle());
    }
}
