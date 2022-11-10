package entities;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class DayTest {
    private final static HashMap<String, Event> e = new HashMap<>();
    private final static HashMap<String, Task> t = new HashMap<>();
    private final static Event e1 = new Event("1", LocalTime.parse("00:01"), LocalTime.parse("01:00"));
    private final static Event e2 = new Event("2", LocalTime.parse("01:02"), LocalTime.parse("02:00"));
    private final static Task t1 = new Task("Hello,");
    private final static Task t2 = new Task("World!");

    @Test
    public void testGetEventsWithDefaultConstructor(){
        Day d = new Day();
        assertEquals(new HashMap<>(), d.getEvents());
    }

    @Test
    public void testGetTasksWithDefaultConstructor(){
        Day d = new Day();
        assertEquals(new HashMap<>(), d.getTasks());
    }

    @BeforeAll
    public static void setUpHashMaps(){
        e.put("1", e1);
        e.put("2", e2);
        t.put("Hello,", t1);
        t.put("World!", t2);
    }

    @Test
    public void testGetEvents(){
        Day d = new Day(t, e);
        Day d1 = new Day(new HashMap<>(), e);
        assertEquals(e, d.getEvents());
        assertEquals(e, d1.getEvents());
    }

    @Test
    public void testGetTasks(){
        Day d = new Day(t, e);
        Day d1 = new Day(t, new HashMap<>());
        assertEquals(t, d.getTasks());
        assertEquals(t, d1.getTasks());
    }
}