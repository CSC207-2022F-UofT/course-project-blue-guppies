package task_modification_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessEvent;
import data_access.DataAccessTask;
import data_access.WeekDataAccess;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskModificationInteractorTest extends WeekDataAccess {
    private final static TaskModificationInputData inputData = new TaskModificationInputData(
            0,"New Sample Task", "Sample Task"
    );
    private final static TaskModificationPresenter outputBoundary = new TaskModificationPresenter();
    private final static TaskModificationDataAccess dsGateway = new TaskModificationDataAccess();


    @Test
    public void testModifyTask(){
        DataAccessTask task = new DataAccessTask("Sample Task");
        HashMap<String, DataAccessTask> tasks = new HashMap<>();
        HashMap<String, DataAccessEvent > events = new HashMap<>();
        tasks.put("Sample Task", task);
        DataAccessDay day = new DataAccessDay(tasks, events);
        this.days.set(0, day);

        TaskModificationInputBoundary inputBoundary = new TaskModificationInteractor(
                outputBoundary, dsGateway
        );
        TaskModificationOutputData outputData = inputBoundary.modifyTask(
                inputData
        );

        assertEquals("New Sample Task", outputData.getTitle());
        assertEquals(0, outputData.getDayId());
        assertEquals("New Sample Task", task.getTitle());
    }

}