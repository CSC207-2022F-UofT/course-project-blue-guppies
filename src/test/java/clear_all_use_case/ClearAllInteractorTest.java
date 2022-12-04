package clear_all_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessEvent;
import data_access.DataAccessTask;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClearAllInteractorTest {
    private final static ClearAllPresenter OUTPUT_BOUNDARY = new ClearAllPresenter();
    private final static ClearAllDataAccess DATA_ACCESS = new ClearAllDataAccess();
    private final static ClearAllDsGateway DS_GATEWAY = DATA_ACCESS;

    @Test
    void testClearInteractor() {
        ClearAllInputBoundary inputBoundary = new ClearAllInteractor(OUTPUT_BOUNDARY, DS_GATEWAY);
        ClearAllOutputData outputData = inputBoundary.clearAll();

        assertTrue(outputData.getSuccess());

        assertTrue(DATA_ACCESS.getDays().get(0).getTasks().isEmpty());
        assertTrue(DATA_ACCESS.getDays().get(1).getTasks().isEmpty());
        assertTrue(DATA_ACCESS.getDays().get(2).getTasks().isEmpty());
        assertTrue(DATA_ACCESS.getDays().get(3).getTasks().isEmpty());
        assertTrue(DATA_ACCESS.getDays().get(4).getTasks().isEmpty());
        assertTrue(DATA_ACCESS.getDays().get(5).getTasks().isEmpty());
        assertTrue(DATA_ACCESS.getDays().get(6).getTasks().isEmpty());

        assertTrue(DATA_ACCESS.getDays().get(0).getEvents().isEmpty());
        assertTrue(DATA_ACCESS.getDays().get(1).getEvents().isEmpty());
        assertTrue(DATA_ACCESS.getDays().get(2).getEvents().isEmpty());
        assertTrue(DATA_ACCESS.getDays().get(3).getEvents().isEmpty());
        assertTrue(DATA_ACCESS.getDays().get(4).getEvents().isEmpty());
        assertTrue(DATA_ACCESS.getDays().get(5).getEvents().isEmpty());
        assertTrue(DATA_ACCESS.getDays().get(6).getEvents().isEmpty());
    }

    @BeforeEach
    void setUp() {
        ArrayList<DataAccessDay> days = new ArrayList<>();

        DataAccessTask task1 = new DataAccessTask("Sample Task1");
        DataAccessTask task2 = new DataAccessTask("Sample Task2");
        DataAccessTask task3 = new DataAccessTask("Sample Task3");
        DataAccessTask task4 = new DataAccessTask("Sample Task4");
        DataAccessTask task5 = new DataAccessTask("Sample Task5");
        DataAccessTask task6 = new DataAccessTask("Sample Task6");
        DataAccessTask task7 = new DataAccessTask("Sample Task7");

        DataAccessEvent event1 = new DataAccessEvent(
                "Sample Event1", LocalTime.parse("09:00"), LocalTime.parse("10:00"));
        DataAccessEvent event2 = new DataAccessEvent(
                "Sample Event2", LocalTime.parse("09:00"), LocalTime.parse("10:00"));
        DataAccessEvent event3 = new DataAccessEvent(
                "Sample Event3", LocalTime.parse("09:00"), LocalTime.parse("10:00"));
        DataAccessEvent event4 = new DataAccessEvent(
                "Sample Event4", LocalTime.parse("09:00"), LocalTime.parse("10:00"));
        DataAccessEvent event5 = new DataAccessEvent(
                "Sample Event5", LocalTime.parse("09:00"), LocalTime.parse("10:00"));
        DataAccessEvent event6 = new DataAccessEvent(
                "Sample Event6", LocalTime.parse("09:00"), LocalTime.parse("10:00"));
        DataAccessEvent event7 = new DataAccessEvent(
                "Sample Event7", LocalTime.parse("09:00"), LocalTime.parse("10:00"));

        HashMap<String, DataAccessTask> tasks1 = new HashMap<>();
        HashMap<String, DataAccessTask> tasks2 = new HashMap<>();
        HashMap<String, DataAccessTask> tasks3 = new HashMap<>();
        HashMap<String, DataAccessTask> tasks4 = new HashMap<>();
        HashMap<String, DataAccessTask> tasks5 = new HashMap<>();
        HashMap<String, DataAccessTask> tasks6 = new HashMap<>();
        HashMap<String, DataAccessTask> tasks7 = new HashMap<>();

        HashMap<String, DataAccessEvent> events1 = new HashMap<>();
        HashMap<String, DataAccessEvent> events2 = new HashMap<>();
        HashMap<String, DataAccessEvent> events3 = new HashMap<>();
        HashMap<String, DataAccessEvent> events4 = new HashMap<>();
        HashMap<String, DataAccessEvent> events5 = new HashMap<>();
        HashMap<String, DataAccessEvent> events6 = new HashMap<>();
        HashMap<String, DataAccessEvent> events7 = new HashMap<>();

        tasks1.put("Sample Task1", task1);
        tasks2.put("Sample Task2", task2);
        tasks3.put("Sample Task3", task3);
        tasks4.put("Sample Task4", task4);
        tasks5.put("Sample Task5", task5);
        tasks6.put("Sample Task6", task6);
        tasks7.put("Sample Task7", task7);

        events1.put("Sample Event1", event1);
        events2.put("Sample Event2", event2);
        events3.put("Sample Event3", event3);
        events4.put("Sample Event4", event4);
        events5.put("Sample Event5", event5);
        events6.put("Sample Event6", event6);
        events7.put("Sample Event7", event7);

        DataAccessDay sunday = new DataAccessDay(tasks1, events1);
        days.add(sunday);
        DataAccessDay monday = new DataAccessDay(tasks2, events2);
        days.add(monday);
        DataAccessDay tuesday = new DataAccessDay(tasks3, events3);
        days.add(tuesday);
        DataAccessDay wednesday = new DataAccessDay(tasks4, events4);
        days.add(wednesday);
        DataAccessDay thursday = new DataAccessDay(tasks5, events5);
        days.add(thursday);
        DataAccessDay friday = new DataAccessDay(tasks6, events6);
        days.add(friday);
        DataAccessDay saturday = new DataAccessDay(tasks7, events7);
        days.add(saturday);


        ClearAllDataAccess.setDays(days);
    }
}
