package task_modification_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessEvent;
import data_access.DataAccessTask;
import data_access.WeekDataAccess;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class TaskModificationInteractorTest extends WeekDataAccess {
    private final static TaskModificationInputData inputData = new TaskModificationInputData(
            0,"New Sample Task", "Sample Task"
    );
    private final static TaskModificationPresenter outputBoundary = new TaskModificationPresenter();
    private final static TaskModificationDataAccess dsGateway = new TaskModificationDataAccess();
    private final static WeekDataAccess week = new WeekDataAccess();

    @BeforeAll
    public static void setUpWeekDays() {
        HashMap<String, DataAccessTask> tasks = new HashMap<>();
        HashMap<String, DataAccessEvent > events = new HashMap<>();
    }

    @Test
    public void testModifyTask(){
        TaskModificationInputBoundary inputBoundary = new TaskModificationInteractor(
                outputBoundary, dsGateway
        );
        TaskModificationOutputData outputData = inputBoundary.modifyTask(
                inputData
        );
        assertEquals(0, outputData.getDayId());
        assertEquals("New Sample Task", outputData.getTitle());
    }

}