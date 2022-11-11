package entities;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class DayFactoryTest {
    //task and event instances (and maps) to be used across tests.
    private final static HashMap<String, Event> e = new HashMap<>();
    private final static HashMap<String, Task> t = new HashMap<>();
    private final static Event e1 = new Event("1", LocalTime.parse("00:01"), LocalTime.parse("01:00"));
    private final static Event e2 = new Event("2", LocalTime.parse("01:02"), LocalTime.parse("02:00"));
    private final static Task t1 = new Task("Hello,");
    private final static Task t2 = new Task("World!");

    @BeforeAll
    public static void setUpHashMaps(){
        e.put("1", e1);
        e.put("2", e2);
        t.put("Hello,", t1);
        t.put("World!", t2);
    }

    @Test
    public void testCreateDayWithEmptyMaps(){
        Day d = new Day(new HashMap<>(), new HashMap<>());
        DayFactory fact = new DayFactory();
        Day d1 = fact.createDay(new HashMap<>(), new HashMap<>());
        assertEquals(d.getTasks(), d1.getTasks());
        assertEquals(d.getEvents(), d1.getEvents());
    }

    @Test
    public void testCreateDayWithParameters(){
        Day d = new Day(new HashMap<>(), new HashMap<>());
        DayFactory fact = new DayFactory();
        Day d1 = fact.createDay(new HashMap<>(), new HashMap<>());
        assertEquals(d.getTasks(), d1.getTasks());
        assertEquals(d.getEvents(), d1.getEvents());
        d = new Day(t, e);
        d1 = fact.createDay(t, e);
        assertEquals(d.getTasks(), d1.getTasks());
        assertEquals(d.getEvents(), d1.getEvents());
    }
}