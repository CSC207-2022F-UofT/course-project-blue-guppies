package entities;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class DayTest {

    @Test
    public void testEmptyConstructor(){
        Day d = new Day(new HashMap<>(), new HashMap<>());
        assertEquals(new HashMap<>(), d.getEvents());
        assertEquals(new HashMap<>(), d.getTasks());
    }
}