package entities;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class WeekTest {
    //task and event instances (and maps) to be used across tests.
    private final static HashMap<String, Event> e = new HashMap<>();
    private final static HashMap<String, Task> t = new HashMap<>();
    private final static Event e1 = new Event("1", LocalTime.parse("00:01"), LocalTime.parse("01:00"));
    private final static Event e2 = new Event("2", LocalTime.parse("01:02"), LocalTime.parse("02:00"));
    private final static Task t1 = new Task("Hello,");
    private final static Task t2 = new Task("World!");
    @Test
    public void testGetDaysConstructorWithEmptyDays(){
        Day d = new Day(new HashMap<>(), new HashMap<>());
        ArrayList<Day> a = new ArrayList<>();
        for(int i = 0; i < 7; i++){
            a.add(d);
        }
        Week w = new Week(a);
        assertEquals(a, w.getDays());
    }
    
    @Test
    public void testGetDaysConstructorWithParameters(){
        Day d0 = new Day(t, e);
        t.put("Hello,", t1);
        Day d1 = new Day(t, e);
        e.put("1", e1);
        Day d2 = new Day(t, e);
        t.put("World!", t2);
        Day d3 = new Day(t, e);
        e.put("2", e2);
        Day d4 = new Day(t, e);
        ArrayList<Day> a = new ArrayList<>();
        a.add(d0);
        a.add(d1);
        a.add(d2);
        a.add(d3);
        a.add(d4);
        a.add(new Day(new HashMap<>(), new HashMap<>()));
        a.add(new Day(new HashMap<>(), new HashMap<>()));
        Week w = new Week(a);
        assertEquals(w.getDays(), a);
    }
}