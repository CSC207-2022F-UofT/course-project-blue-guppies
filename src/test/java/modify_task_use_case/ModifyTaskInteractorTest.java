package modify_task_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessEvent;
import data_access.DataAccessTask;
import data_access.WeekDataAccess;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ModifyTaskInteractorTest extends WeekDataAccess {
    private final static ModifyTaskInputData inputData = new ModifyTaskInputData(
            0,"New Sample Task", "Sample Task"
    );
    private final static ModifyTaskPresenter outputBoundary = new ModifyTaskPresenter();
    private final static ModifyTaskDataAccess dsGateway = new ModifyTaskDataAccess();


    @Test
    public void testModifyTask(){
        DataAccessTask task = new DataAccessTask("Sample Task");
        HashMap<String, DataAccessTask> tasks = new HashMap<>();
        HashMap<String, DataAccessEvent > events = new HashMap<>();
        tasks.put("Sample Task", task);
        DataAccessDay day = new DataAccessDay(tasks, events);
        this.days.set(0, day);

        ModifyTaskInputBoundary inputBoundary = new ModifyTaskInteractor(
                outputBoundary, dsGateway
        );
        ModifyTaskOutputData outputData = inputBoundary.modifyTask(
                inputData
        );

        assertEquals("New Sample Task", outputData.getTitle());
        assertEquals(0, outputData.getDayId());
        assertEquals("New Sample Task", task.getTitle());
    }
}
