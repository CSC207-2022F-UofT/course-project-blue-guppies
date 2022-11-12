package entities;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class DayTest {
    //task and event instances (and maps) to be used across tests.
    private final static HashMap<String, Event> eventMap = new HashMap<>();
    private final static HashMap<String, Task> taskMap = new HashMap<>();
    private final static Event event1 = new Event("1", LocalTime.parse("00:01"), LocalTime.parse("01:00"));
    private final static Event event2 = new Event("2", LocalTime.parse("01:02"), LocalTime.parse("02:00"));
    private final static Task task1 = new Task("Hello,");
    private final static Task task2 = new Task("World!");

    @Test
    public void testGetEventsWithEmptyMaps(){
        Day d = new Day(new HashMap<>(), new HashMap<>());
        assertEquals(new HashMap<>(), d.getEvents());
    }

    @Test
    public void testGetTasksWithEmptyMaps(){
        Day d = new Day(new HashMap<>(), new HashMap<>());
        assertEquals(new HashMap<>(), d.getTasks());
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
        Day d = new Day(taskMap, eventMap);
        Day d1 = new Day(new HashMap<>(), eventMap);
        assertEquals(eventMap, d.getEvents());
        assertEquals(eventMap, d1.getEvents());
    }

    @Test
    public void testGetTasks(){
        Day d = new Day(taskMap, eventMap);
        Day d1 = new Day(taskMap, new HashMap<>());
        assertEquals(taskMap, d.getTasks());
        assertEquals(taskMap, d1.getTasks());
    }
}