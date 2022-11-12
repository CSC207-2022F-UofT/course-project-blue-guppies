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
}