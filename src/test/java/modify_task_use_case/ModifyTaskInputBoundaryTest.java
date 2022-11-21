package modify_task_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessEvent;
import data_access.DataAccessTask;
import data_access.WeekDataAccess;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModifyTaskInputBoundaryTest extends WeekDataAccess {
    private final static ModifyTaskPresenter presenter = new ModifyTaskPresenter();
    private final static ModifyTaskDataAccess dataAccess = new ModifyTaskDataAccess();
    private final static ModifyTaskInputBoundary inputBoundary = new ModifyTaskInteractor(
            presenter, dataAccess
    );
    private final static ModifyTaskInputData inputData = new ModifyTaskInputData(
            0,"New Sample Task", "Sample Task"
    );

    @Test
    public void testModifyTask() {
        DataAccessTask task = new DataAccessTask("Sample Task");
        HashMap<String, DataAccessTask> tasks = new HashMap<>();
        HashMap<String, DataAccessEvent> events = new HashMap<>();
        tasks.put("Sample Task", task);
        DataAccessDay day = new DataAccessDay(tasks, events);
        this.days.set(0, day);

        ModifyTaskOutputData outputData = inputBoundary.modifyTask(
                inputData
        );

        assertEquals("New Sample Task", outputData.getTitle());
        assertEquals(0, outputData.getDayId());
        assertEquals("New Sample Task", task.getTitle());
    }
}
