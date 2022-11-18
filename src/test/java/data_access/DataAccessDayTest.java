package data_access;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class DataAccessDayTest {
    private final static HashMap<String, DataAccessEvent> eventMap = new HashMap<>();
    private final static HashMap<String, DataAccessTask> taskMap = new HashMap<>();
    private final static DataAccessEvent event1 = new DataAccessEvent("1", LocalTime.parse("00:01"), LocalTime.parse("01:00"));
    private final static DataAccessEvent event2 = new DataAccessEvent("2", LocalTime.parse("01:02"), LocalTime.parse("02:00"));
    private final static DataAccessTask task1 = new DataAccessTask("Hello,");
    private final static DataAccessTask task2 = new DataAccessTask("World!");

    @Test
    public void testGetEventsWithEmptyMaps(){
        DataAccessDay day = new DataAccessDay(new HashMap<>(), new HashMap<>());
        assertEquals(new HashMap<>(), day.getEvents());
    }

    @Test
    public void testGetTasksWithEmptyMaps(){
        DataAccessDay day = new DataAccessDay(new HashMap<>(), new HashMap<>());
        assertEquals(new HashMap<>(), day.getTasks());
    }

    @BeforeAll
    public static void setUpHashMaps(){
        eventMap.put("1", event1);
        eventMap.put("2", event2);
        taskMap.put("Hello,", task1);
        taskMap.put("World!", task2);
    }

    @Test
    public void testGetEvents(){
        DataAccessDay day1 = new DataAccessDay(taskMap, eventMap);
        DataAccessDay day2 = new DataAccessDay(new HashMap<>(), eventMap);
        assertEquals(eventMap, day1.getEvents());
        assertEquals(eventMap, day2.getEvents());
    }

    @Test
    public void testGetTasks(){
        DataAccessDay day1 = new DataAccessDay(taskMap, eventMap);
        DataAccessDay day2 = new DataAccessDay(taskMap, new HashMap<>());
        assertEquals(taskMap, day1.getTasks());
        assertEquals(taskMap, day2.getTasks());
    }

    @Test
    public void testSetTasks(){
        DataAccessTask networking = new DataAccessTask("connect with Google employer");
        DataAccessTask pullRequest = new DataAccessTask("make Pull Request on data access");
        HashMap<String, DataAccessTask> taskMap2 = new HashMap<>();
        for(String k: taskMap.keySet()){
            taskMap2.put(k, taskMap.get(k));
        }
        taskMap2.put("connect with Google employer", networking);
        taskMap2.put("make Pull Request on data access", pullRequest);
        DataAccessDay day = new DataAccessDay(taskMap, eventMap);
        day.setTasks(taskMap2);
        assertEquals(taskMap2, day.getTasks());
    }

    @Test
    public void testSetEvents(){
        DataAccessEvent study = new DataAccessEvent("study", LocalTime.parse("00:01:10"), LocalTime.parse("01:00"));
        DataAccessEvent sleep = new DataAccessEvent("zzz", LocalTime.parse("23:00"), LocalTime.parse("23:58:20"));
        HashMap<String, DataAccessEvent> eventMap2 = new HashMap<>();
        for(String k: eventMap.keySet()){
            eventMap2.put(k, eventMap.get(k));
        }
        eventMap2.put("study", study);
        eventMap2.put("zzz", sleep);
        DataAccessDay day = new DataAccessDay(taskMap, eventMap);
        day.setEvents(eventMap2);
        assertEquals(eventMap2, day.getEvents());
    }
}
