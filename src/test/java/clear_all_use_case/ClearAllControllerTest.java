package clear_all_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessEvent;
import data_access.DataAccessTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ClearAllControllerTest {
    private final static ClearAllPresenter OUTPUT_BOUNDARY = new ClearAllPresenter();
    private final static ClearAllDataAccess DATA_ACCESS = new ClearAllDataAccess();
    private final static ClearAllDsGateway DS_GATEWAY = DATA_ACCESS;
    private final static ClearAllInteractor INPUT_BOUNDARY = new ClearAllInteractor(OUTPUT_BOUNDARY, DS_GATEWAY);
    private final static ClearAllController CONTROLLER = new ClearAllController(INPUT_BOUNDARY);

    @Test
    void testClearAll() {
        ClearAllOutputData outputData = CONTROLLER.clearAll();

        assertTrue(outputData.getSuccess());
        assertTrue(DATA_ACCESS.getDays().get(0).getTasks().isEmpty());
        assertTrue(DATA_ACCESS.getDays().get(1).getTasks().isEmpty());
        assertTrue(DATA_ACCESS.getDays().get(2).getTasks().isEmpty());

        assertTrue(DATA_ACCESS.getDays().get(0).getEvents().isEmpty());
        assertTrue(DATA_ACCESS.getDays().get(1).getEvents().isEmpty());
        assertTrue(DATA_ACCESS.getDays().get(2).getEvents().isEmpty());

    }

    @BeforeEach
    void setUp() {
        ArrayList<DataAccessDay> days = new ArrayList<>();
        DataAccessTask task1 = new DataAccessTask("Task1");
        DataAccessTask task2 = new DataAccessTask("Task2");
        DataAccessTask task3 = new DataAccessTask("Task3");
        DataAccessEvent event1 = new DataAccessEvent(
                "Math", LocalTime.parse("09:00"), LocalTime.parse("10:00"));
        DataAccessEvent event2 = new DataAccessEvent(
                "CSC", LocalTime.parse("09:00"), LocalTime.parse("10:00"));
        DataAccessEvent event3 = new DataAccessEvent(
                "Math2", LocalTime.parse("09:00"), LocalTime.parse("10:00"));
        HashMap<String, DataAccessTask> tasks1 = new HashMap<>();
        HashMap<String, DataAccessTask> tasks2 = new HashMap<>();
        HashMap<String, DataAccessTask> tasks3 = new HashMap<>();
        HashMap<String, DataAccessEvent> events1 = new HashMap<>();
        HashMap<String, DataAccessEvent> events2 = new HashMap<>();
        HashMap<String, DataAccessEvent> events3 = new HashMap<>();
        tasks1.put("Task1", task1);
        tasks2.put("Task2", task2);
        tasks3.put("Task3", task3);
        events1.put("Math", event1);
        events2.put("CSC", event2);
        events3.put("Math2", event3);

        DataAccessDay sunday = new DataAccessDay(tasks1, events1);
        days.add(sunday);
        DataAccessDay monday = new DataAccessDay(tasks2, events2);
        days.add(monday);
        DataAccessDay tuesday = new DataAccessDay(tasks3, events3);
        days.add(tuesday);

        ClearAllDataAccess.setDays(days);
    }
}
