package data_access;

import entities.Day;
import entities.Event;
import entities.Task;
import entities.Week;
import modify_event_use_case.ModifyEventDataAccess;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class DataPersistenceTest {

    @Test
    public void testSerializingDeserializingType() throws IOException, ClassNotFoundException {
        ArrayList<Day> days = new ArrayList<>();
        Day emptyDay = new Day(new HashMap<>(), new HashMap<>());
        days.add(emptyDay);
        Event math1 = new Event("MAT237", LocalTime.parse("09:00"), LocalTime.parse("10:00"));
        Event math = new Event("Mat237", LocalTime.parse("09:00"), LocalTime.parse("10:00"));
        Event stats = new Event("Sta247", LocalTime.parse("14:00"), LocalTime.parse("16:00"));
        Event theory = new Event("Csc236", LocalTime.parse("12:00"), LocalTime.parse("13:00"));
        Task winterBreak = new Task("Feed dog");
        HashMap<String, Event> events1 = new HashMap<>();
        HashMap<String, Event> events2 = new HashMap<>();
        HashMap<String, Event> events3 = new HashMap<>();
        HashMap<String, Task> tasks = new HashMap<>();
        events1.put("MAT237", math1);
        events2.put("Mat237", math);
        events2.put("Sta247", stats);
        events3.put("Csc236", theory);
        tasks.put("Feed dog", winterBreak);
        Day sampleMonday = new Day(new HashMap<>(), events1);
        days.add(sampleMonday);
        Day sampleTuesday = new Day(new HashMap<>(), events2);
        days.add(sampleTuesday);
        Day sampleWednesday = new Day(tasks, events3);
        days.add(sampleWednesday);
        Day sampleThursday = new Day(new HashMap<>(), events2);
        days.add(sampleThursday);
        Day sampleFriday = new Day(tasks, events3);
        days.add(sampleFriday);
        days.add(emptyDay);

        WeekDataAccess.writeObject(days);
        WeekDataAccess.readObject();

        assertTrue(WeekDataAccess.days.get(1).getEvents().containsKey("MAT237"));
        assertTrue(WeekDataAccess.days.get(2).getEvents().containsKey("Mat237"));
        assertTrue(WeekDataAccess.days.get(3).getEvents().containsKey("Csc236"));
        assertTrue(WeekDataAccess.days.get(4).getEvents().containsKey("Mat237"));
    }
}
