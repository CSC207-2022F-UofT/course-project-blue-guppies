package entities;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class WeekTest {
    //task and event instances (and maps) to be used across tests.
    private final static HashMap<String, Event> eventMap = new HashMap<>();
    private final static HashMap<String, Task> taskMap = new HashMap<>();
    private final static Event event1 = new Event("1", LocalTime.parse("00:01"), LocalTime.parse("01:00"));
    private final static Event event2 = new Event("2", LocalTime.parse("01:02"), LocalTime.parse("02:00"));
    private final static Task task1 = new Task("Hello,");
    private final static Task task2 = new Task("World!");
    @Test
    public void testGetDaysConstructorWithEmptyDays(){
        Day emptyDay = new Day(new HashMap<>(), new HashMap<>());
        ArrayList<Day> dayList = new ArrayList<>();
        for(int i = 0; i < 7; i++){
            dayList.add(emptyDay);
        }
        Week exampleWeek = new Week(dayList);
        assertEquals(dayList, exampleWeek.getDays());
    }
    
    @Test
    public void testGetDaysConstructorWithParameters(){
        Day day0 = new Day(taskMap, eventMap);
        taskMap.put("Hello,", task1);
        Day day1 = new Day(taskMap, eventMap);
        eventMap.put("1", event1);
        Day day2 = new Day(taskMap, eventMap);
        taskMap.put("World!", task2);
        Day day3 = new Day(taskMap, eventMap);
        eventMap.put("2", event2);
        Day day4 = new Day(taskMap, eventMap);
        ArrayList<Day> daysList = new ArrayList<>();
        daysList.add(day0);
        daysList.add(day1);
        daysList.add(day2);
        daysList.add(day3);
        daysList.add(day4);
        daysList.add(new Day(new HashMap<>(), new HashMap<>()));
        daysList.add(new Day(new HashMap<>(), new HashMap<>()));
        Week exampleWeek = new Week(daysList);
        assertEquals(exampleWeek.getDays(), daysList);
    }
}