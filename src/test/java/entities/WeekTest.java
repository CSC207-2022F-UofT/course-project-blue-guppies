package entities;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class WeekTest {
    @Test
    public void TestEmptyConstructor(){
        Day d = new Day(new HashMap<>(), new HashMap<>());
        ArrayList<Day> a = new ArrayList<>();
        for(int i = 0; i < 7; i++){
            a.add(d);
        }
        Week w = new Week(a);
        assertEquals(a, w.getDays());
    }
}