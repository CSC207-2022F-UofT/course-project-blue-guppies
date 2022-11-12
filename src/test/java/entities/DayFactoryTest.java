package entities;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class DayFactoryTest {
    //task and event instances (and maps) to be used across tests.
    private final static HashMap<String, Event>eventMap = new HashMap<>();
    private final static HashMap<String, Task>taskMap = new HashMap<>();
    private final static Event eventask1 = new Event("1", LocalTime.parse("00:01"), LocalTime.parse("01:00"));
    private final static Event eventask2 = new Event("2", LocalTime.parse("01:02"), LocalTime.parse("02:00"));
    private final static Task task1 = new Task("Hello,");
    private final static Task task2 = new Task("World!");

    @BeforeAll
    public static void setUpHashMaps(){
       eventMap.put("1", eventask1);
       eventMap.put("2", eventask2);
       taskMap.put("Hello,", task1);
       taskMap.put("World!", task2);
    }

    @Test
    public void testCreateDayWithEmptyMaps(){
        Day day1 = new Day(new HashMap<>(), new HashMap<>());
        DayFactory fact = new DayFactory();
        Day day2 = fact.createDay(new HashMap<>(), new HashMap<>());
        assertEquals(day1.getTasks(), day2.getTasks());
        assertEquals(day1.getEvents(), day2.getEvents());
    }

    @Test
    public void testCreateDayWithParameters(){
        DayFactory fact = new DayFactory();
        Day day1 = new Day(taskMap,eventMap);
        Day day2 = fact.createDay(taskMap,eventMap);
        assertEquals(day1.getTasks(), day2.getTasks());
        assertEquals(day1.getEvents(), day2.getEvents());
    }
}