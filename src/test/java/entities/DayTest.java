package entities;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class DayTest {

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
}