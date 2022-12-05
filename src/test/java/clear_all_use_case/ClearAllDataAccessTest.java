package clear_all_use_case;

import entities.Day;
import entities.Event;
import entities.Task;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClearAllDataAccessTest {
    private final static ClearAllDataAccess DATA_ACCESS = new ClearAllDataAccess();

    @Test
    void testSaveInfo() {
        DATA_ACCESS.save();

        assertTrue(DATA_ACCESS.getDays().get(0).getTasks().isEmpty());
        assertTrue(DATA_ACCESS.getDays().get(1).getTasks().isEmpty());
        assertTrue(DATA_ACCESS.getDays().get(2).getTasks().isEmpty());
        assertTrue(DATA_ACCESS.getDays().get(3).getTasks().isEmpty());
        assertTrue(DATA_ACCESS.getDays().get(4).getTasks().isEmpty());
        assertTrue(DATA_ACCESS.getDays().get(5).getTasks().isEmpty());
        assertTrue(DATA_ACCESS.getDays().get(6).getTasks().isEmpty());

        assertTrue(DATA_ACCESS.getDays().get(0).getEvents().isEmpty());
        assertTrue(DATA_ACCESS.getDays().get(1).getEvents().isEmpty());
        assertTrue(DATA_ACCESS.getDays().get(2).getEvents().isEmpty());
        assertTrue(DATA_ACCESS.getDays().get(3).getEvents().isEmpty());
        assertTrue(DATA_ACCESS.getDays().get(4).getEvents().isEmpty());
        assertTrue(DATA_ACCESS.getDays().get(5).getEvents().isEmpty());
        assertTrue(DATA_ACCESS.getDays().get(6).getEvents().isEmpty());

    }

    @BeforeEach
    void setUp() {
        ArrayList<Day> days = new ArrayList<>();

        Task task1 = new Task("Sample Task1");
        Task task2 = new Task("Sample Task2");
        Task task3 = new Task("Sample Task3");
        Task task4 = new Task("Sample Task4");
        Task task5 = new Task("Sample Task5");
        Task task6 = new Task("Sample Task6");
        Task task7 = new Task("Sample Task7");

        Event event1 = new Event(
                "Sample Event1", LocalTime.parse("09:00"), LocalTime.parse("10:00"));
        Event event2 = new Event(
                "Sample Event2", LocalTime.parse("09:00"), LocalTime.parse("10:00"));
        Event event3 = new Event(
                "Sample Event3", LocalTime.parse("09:00"), LocalTime.parse("10:00"));
        Event event4 = new Event(
                "Sample Event4", LocalTime.parse("09:00"), LocalTime.parse("10:00"));
        Event event5 = new Event(
                "Sample Event5", LocalTime.parse("09:00"), LocalTime.parse("10:00"));
        Event event6 = new Event(
                "Sample Event6", LocalTime.parse("09:00"), LocalTime.parse("10:00"));
        Event event7 = new Event(
                "Sample Event7", LocalTime.parse("09:00"), LocalTime.parse("10:00"));

        HashMap<String, Task> tasks1 = new HashMap<>();
        HashMap<String, Task> tasks2 = new HashMap<>();
        HashMap<String, Task> tasks3 = new HashMap<>();
        HashMap<String, Task> tasks4 = new HashMap<>();
        HashMap<String, Task> tasks5 = new HashMap<>();
        HashMap<String, Task> tasks6 = new HashMap<>();
        HashMap<String, Task> tasks7 = new HashMap<>();

        HashMap<String, Event> events1 = new HashMap<>();
        HashMap<String, Event> events2 = new HashMap<>();
        HashMap<String, Event> events3 = new HashMap<>();
        HashMap<String, Event> events4 = new HashMap<>();
        HashMap<String, Event> events5 = new HashMap<>();
        HashMap<String, Event> events6 = new HashMap<>();
        HashMap<String, Event> events7 = new HashMap<>();

        tasks1.put("Sample Task1", task1);
        tasks2.put("Sample Task2", task2);
        tasks3.put("Sample Task3", task3);
        tasks4.put("Sample Task4", task4);
        tasks5.put("Sample Task5", task5);
        tasks6.put("Sample Task6", task6);
        tasks7.put("Sample Task7", task7);

        events1.put("Sample Event1", event1);
        events2.put("Sample Event2", event2);
        events3.put("Sample Event3", event3);
        events4.put("Sample Event4", event4);
        events5.put("Sample Event5", event5);
        events6.put("Sample Event6", event6);
        events7.put("Sample Event7", event7);

        Day sunday = new Day(tasks1, events1);
        days.add(sunday);
        Day monday = new Day(tasks2, events2);
        days.add(monday);
        Day tuesday = new Day(tasks3, events3);
        days.add(tuesday);
        Day wednesday = new Day(tasks4, events4);
        days.add(wednesday);
        Day thursday = new Day(tasks5, events5);
        days.add(thursday);
        Day friday = new Day(tasks6, events6);
        days.add(friday);
        Day saturday = new Day(tasks7, events7);
        days.add(saturday);


        ClearAllDataAccess.setDays(days);
    }
}
