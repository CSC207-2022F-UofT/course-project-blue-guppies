package entities;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class DayTest {
    private final static HashMap<String, Event> eventMap = new HashMap<>();
    private final static HashMap<String, Task> taskMap = new HashMap<>();
    private final static Event event1 = new Event("1", LocalTime.parse("00:01"), LocalTime.parse("01:00"));
    private final static Event event2 = new Event("2", LocalTime.parse("01:02"), LocalTime.parse("02:00"));
    private final static Task task1 = new Task("Hello,");
    private final static Task task2 = new Task("World!");

    @Test
    public void testGetEventsWithEmptyMaps(){
        Day day = new Day(new HashMap<>(), new HashMap<>());
        assertEquals(new HashMap<>(), day.getEvents());
    }

    @Test
    public void testGetTasksWithEmptyMaps(){
        Day day = new Day(new HashMap<>(), new HashMap<>());
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
        Day day1 = new Day(taskMap, eventMap);
        Day day2 = new Day(new HashMap<>(), eventMap);
        assertEquals(eventMap, day1.getEvents());
        assertEquals(eventMap, day2.getEvents());
    }

    @Test
    public void testGetTasks(){
        Day day1 = new Day(taskMap, eventMap);
        Day day2 = new Day(taskMap, new HashMap<>());
        assertEquals(taskMap, day1.getTasks());
        assertEquals(taskMap, day2.getTasks());
    }

    @Test
    public void testSetTasks(){
        Task networking = new Task("connect with Google employer");
        Task pullRequest = new Task("make Pull Request on data access");
        HashMap<String, Task> taskMap2 = new HashMap<>();
        for(String k: taskMap.keySet()){
            taskMap2.put(k, taskMap.get(k));
        }
        taskMap2.put("connect with Google employer", networking);
        taskMap2.put("make Pull Request on data access", pullRequest);
        Day day = new Day(taskMap, eventMap);
        day.setTasks(taskMap2);
        assertEquals(taskMap2, day.getTasks());
    }

    @Test
    public void testSetEvents(){
        Event study = new Event("study", LocalTime.parse("00:01:10"), LocalTime.parse("01:00"));
        Event sleep = new Event("zzz", LocalTime.parse("23:00"), LocalTime.parse("23:58:20"));
        HashMap<String, Event> eventMap2 = new HashMap<>();
        for(String k: eventMap.keySet()){
            eventMap2.put(k, eventMap.get(k));
        }
        eventMap2.put("study", study);
        eventMap2.put("zzz", sleep);
        Day day = new Day(taskMap, eventMap);
        day.setEvents(eventMap2);
        assertEquals(eventMap2, day.getEvents());
    }
}
