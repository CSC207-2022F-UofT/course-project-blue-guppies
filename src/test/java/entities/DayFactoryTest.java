package entities;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class DayFactoryTest {
    @Test
    public void testCreateDay(){
        Day d = new Day(new HashMap<>(), new HashMap<>());
        DayFactory fact = new DayFactory();
        Day d1 = fact.createDay();
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
    }
}