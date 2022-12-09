package screens;

import entities.Day;
import entities.Event;
import entities.Task;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ViewModelTest {
    final static TestingObserver OBSERVER = new TestingObserver();

    private static ViewModel getViewModel() {
        ArrayList<Day> days = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            days.add(new Day(new HashMap<>(), new HashMap<>()));
        }
        ViewModel v = new ViewModel(days);
        v.addObserver(OBSERVER);
        return v;
    }

    @Test
    void testInitializeWeekViewScreen() {
        ViewModel viewModel = getViewModel();

        viewModel.initializeWeekViewScreen();

        assertEquals(6, OBSERVER.getDayIndex());
        assertEquals(new ArrayList<String>(), OBSERVER.getStartTimes());
        assertEquals(new ArrayList<String>(), OBSERVER.getEndTimes());
        assertEquals(new ArrayList<String>(), OBSERVER.getEventTitles());
        assertEquals(new ArrayList<String>(), OBSERVER.getTaskTitles());
        assertEquals(new ArrayList<Boolean>(), OBSERVER.getTaskCompletionStatuses());
    }

    @Test
    void testInitializeWeekViewScreenNonEmptyInitialization() {
        ArrayList<Day> days = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            HashMap<String, Task> tasks = new HashMap<>();
            HashMap<String, Event> events = new HashMap<>();
            for (int j = 0; j < 3; j++) {
                tasks.put("task" + j, new Task("task" + j));
                events.put("event" + j, new Event("event" + j, LocalTime.parse("0" + j + ":00"),
                        LocalTime.parse("0" + (j + 1) + ":00")));
            }
            days.add(new Day(tasks,events));
        }

        // Test that the view model gets setup correctly when it is not given empty days.
        ViewModel viewModel = new ViewModel(days);
        viewModel.addObserver(OBSERVER);

        viewModel.initializeWeekViewScreen();

        assertEquals(6, OBSERVER.getDayIndex());
        assertEquals(3, OBSERVER.getEventTitles().size());
        assertEquals(3, OBSERVER.getStartTimes().size());
        assertEquals(3, OBSERVER.getEndTimes().size());
        assertEquals(3, OBSERVER.getTaskTitles().size());
        assertEquals(3, OBSERVER.getTaskCompletionStatuses().size());

        ArrayList<String> startTimes = new ArrayList<>();
        startTimes.add("00:00");
        startTimes.add("01:00");
        startTimes.add("02:00");

        ArrayList<String> endTimes = new ArrayList<>();
        endTimes.add("01:00");
        endTimes.add("02:00");
        endTimes.add("03:00");

        ArrayList<String> taskTitles = new ArrayList<>();
        taskTitles.add("task0");
        taskTitles.add("task1");
        taskTitles.add("task2");

        ArrayList<String> eventTitles = new ArrayList<>();
        eventTitles.add("event0");
        eventTitles.add("event1");
        eventTitles.add("event2");

        ArrayList<Boolean> taskCompletions = new ArrayList<>();
        taskCompletions.add(false);
        taskCompletions.add(false);
        taskCompletions.add(false);

        assertEquals(startTimes, OBSERVER.getStartTimes());
        assertEquals(endTimes, OBSERVER.getEndTimes());
        assertEquals(eventTitles, OBSERVER.getEventTitles());
        assertEquals(taskTitles, OBSERVER.getTaskTitles());
        assertEquals(taskCompletions, OBSERVER.getTaskCompletionStatuses());
    }

    @Test
    void testNewEvent() {
        ViewModel viewModel = getViewModel();

        viewModel.newEvent(1, "Relax", LocalTime.parse("15:30"), LocalTime.parse("19:45"));

        assertEquals(1, OBSERVER.getDayIndex());
        assertEquals(1, OBSERVER.getEventTitles().size());
        assertEquals(1, OBSERVER.getStartTimes().size());
        assertEquals(1, OBSERVER.getEndTimes().size());
        assertEquals("15:30", OBSERVER.getStartTimes().get(0));
        assertEquals("19:45", OBSERVER.getEndTimes().get(0));
        assertEquals("Relax", OBSERVER.getEventTitles().get(0));
    }

    @Test
    void testNewEventMultipleSameDay() {
        ViewModel viewModel = getViewModel();

        viewModel.newEvent(1, "Clean", LocalTime.parse("05:30"), LocalTime.parse("09:45"));

        assertEquals(1, OBSERVER.getDayIndex());
        assertEquals(1, OBSERVER.getEventTitles().size());
        assertEquals(1, OBSERVER.getStartTimes().size());
        assertEquals(1, OBSERVER.getEndTimes().size());
        assertEquals("05:30", OBSERVER.getStartTimes().get(0));
        assertEquals("09:45", OBSERVER.getEndTimes().get(0));
        assertEquals("Clean", OBSERVER.getEventTitles().get(0));

        viewModel.newEvent(1, "Relax", LocalTime.parse("15:30"), LocalTime.parse("19:45"));

        assertEquals(1, OBSERVER.getDayIndex());
        assertEquals(2, OBSERVER.getEventTitles().size());
        assertEquals(2, OBSERVER.getStartTimes().size());
        assertEquals(2, OBSERVER.getEndTimes().size());
        assertEquals("15:30", OBSERVER.getStartTimes().get(1));
        assertEquals("19:45", OBSERVER.getEndTimes().get(1));
        assertEquals("Relax", OBSERVER.getEventTitles().get(1));
    }

    @Test
    void testNewEventMultipleDifferentDay() {
        ViewModel viewModel = getViewModel();

        viewModel.newEvent(1, "Relax", LocalTime.parse("15:30"), LocalTime.parse("19:45"));

        assertEquals(1, OBSERVER.getDayIndex());
        assertEquals(1, OBSERVER.getEventTitles().size());
        assertEquals(1, OBSERVER.getStartTimes().size());
        assertEquals(1, OBSERVER.getEndTimes().size());
        assertEquals("15:30", OBSERVER.getStartTimes().get(0));
        assertEquals("19:45", OBSERVER.getEndTimes().get(0));
        assertEquals("Relax", OBSERVER.getEventTitles().get(0));

        viewModel.newEvent(2, "Relax", LocalTime.parse("15:30"), LocalTime.parse("19:45"));

        assertEquals(2, OBSERVER.getDayIndex());
        assertEquals(1, OBSERVER.getEventTitles().size());
        assertEquals(1, OBSERVER.getStartTimes().size());
        assertEquals(1, OBSERVER.getEndTimes().size());
        assertEquals("15:30", OBSERVER.getStartTimes().get(0));
        assertEquals("19:45", OBSERVER.getEndTimes().get(0));
        assertEquals("Relax", OBSERVER.getEventTitles().get(0));
    }

    @Test
    void testNewTask() {
        ViewModel viewModel = getViewModel();

        viewModel.newTask(3, "Unlock the secrets of the universe");

        assertEquals(3, OBSERVER.getDayIndex());
        assertEquals(1, OBSERVER.getTaskTitles().size());
        assertEquals(1, OBSERVER.getTaskCompletionStatuses().size());
        assertEquals(false, OBSERVER.getTaskCompletionStatuses().get(0));
        assertEquals("Unlock the secrets of the universe", OBSERVER.getTaskTitles().get(0));
    }

    @Test
    void testNewTaskMultipleTasksSameDay() {
        ViewModel viewModel = getViewModel();

        viewModel.newTask(3, "Unlock the secrets of the universe");
        viewModel.newTask(3, "Cry about the secrets of the universe");

        assertEquals(3, OBSERVER.getDayIndex());
        assertEquals(2, OBSERVER.getTaskTitles().size());
        assertEquals(2, OBSERVER.getTaskCompletionStatuses().size());
        assertEquals(false, OBSERVER.getTaskCompletionStatuses().get(1));
        assertEquals("Unlock the secrets of the universe", OBSERVER.getTaskTitles().get(1));
    }

    @Test
    void testNewTaskMultipleTasksDifferentDay() {
        ViewModel viewModel = getViewModel();

        viewModel.newTask(3, "Unlock the secrets of the universe");

        assertEquals(3, OBSERVER.getDayIndex());
        assertEquals(1, OBSERVER.getTaskTitles().size());
        assertEquals(1, OBSERVER.getTaskCompletionStatuses().size());
        assertEquals(false, OBSERVER.getTaskCompletionStatuses().get(0));
        assertEquals("Unlock the secrets of the universe", OBSERVER.getTaskTitles().get(0));

        viewModel.newTask(4, "Cry about the secrets of the universe");

        assertEquals(4, OBSERVER.getDayIndex());
        assertEquals(1, OBSERVER.getTaskTitles().size());
        assertEquals(1, OBSERVER.getTaskCompletionStatuses().size());
        assertEquals(false, OBSERVER.getTaskCompletionStatuses().get(0));
        assertEquals("Cry about the secrets of the universe", OBSERVER.getTaskTitles().get(0));
    }

    @Test
    void testModifyEventMultipleEvents() {
        ViewModel viewModel = getViewModel();

        viewModel.newEvent(5, "Sleep", LocalTime.parse("20:30"), LocalTime.parse("23:59"));
        viewModel.newEvent(5, "Relax", LocalTime.parse("15:30"), LocalTime.parse("19:45"));
        viewModel.modifyEvent(5, "Sleep", "Study", LocalTime.parse("17:30"),
                LocalTime.parse("23:45"));

        assertEquals(5, OBSERVER.getDayIndex());
        assertEquals(2, OBSERVER.getEventTitles().size());
        assertEquals(2, OBSERVER.getStartTimes().size());
        assertEquals(2, OBSERVER.getEndTimes().size());
        assertEquals("17:30", OBSERVER.getStartTimes().get(1));
        assertEquals("23:45", OBSERVER.getEndTimes().get(1));
        assertEquals("Study", OBSERVER.getEventTitles().get(1));
    }

    @Test
    void testModifyEvent() {
        ViewModel viewModel = getViewModel();

        viewModel.newEvent(5, "Sleep", LocalTime.parse("20:30"), LocalTime.parse("23:59"));
        viewModel.modifyEvent(5, "Sleep", "Study", LocalTime.parse("17:30"),
                LocalTime.parse("23:45"));

        assertEquals(5, OBSERVER.getDayIndex());
        assertEquals(1, OBSERVER.getEventTitles().size());
        assertEquals(1, OBSERVER.getStartTimes().size());
        assertEquals(1, OBSERVER.getEndTimes().size());
        assertEquals("17:30", OBSERVER.getStartTimes().get(0));
        assertEquals("23:45", OBSERVER.getEndTimes().get(0));
        assertEquals("Study", OBSERVER.getEventTitles().get(0));
    }

    @Test
    void testModifyTask() {
        ViewModel viewModel = getViewModel();

        viewModel.newTask(3, "Unlock the secrets of the universe");
        viewModel.modifyTask(3, "Unlock the secrets of the universe", "Clean room :(");

        assertEquals(3, OBSERVER.getDayIndex());
        assertEquals(1, OBSERVER.getTaskTitles().size());
        assertEquals(1, OBSERVER.getTaskCompletionStatuses().size());
        assertEquals(false, OBSERVER.getTaskCompletionStatuses().get(0));
        assertEquals("Clean room :(", OBSERVER.getTaskTitles().get(0));
    }

    @Test
    void testModifyTaskMultipleTasks() {
        ViewModel viewModel = getViewModel();

        viewModel.newTask(3, "Unlock the secrets of the universe");
        viewModel.newTask(4, "Unlock the secrets of the universe");
        viewModel.newTask(5, "Unlock the secrets of the universe");
        viewModel.newTask(5, "Leave room");
        viewModel.modifyTask(5, "Leave room", "zzzzzzzzzzzzzzzzzzzzzzzzzzzz");

        assertEquals(5, OBSERVER.getDayIndex());
        assertEquals(2, OBSERVER.getTaskTitles().size());
        assertEquals(2, OBSERVER.getTaskCompletionStatuses().size());
        assertEquals(false, OBSERVER.getTaskCompletionStatuses().get(1)); // index 1 because items are sorted
        assertEquals("zzzzzzzzzzzzzzzzzzzzzzzzzzzz", OBSERVER.getTaskTitles().get(1));
    }

    @Test
    void testCompleteTask() {
        ViewModel viewModel = getViewModel();

        viewModel.newTask(4, "Freeze chicken");
        viewModel.completeTask(4, "Freeze chicken", true);

        assertEquals(4, OBSERVER.getDayIndex());
        assertEquals(1, OBSERVER.getTaskTitles().size());
        assertEquals(1, OBSERVER.getTaskCompletionStatuses().size());
        assertEquals(true, OBSERVER.getTaskCompletionStatuses().get(0));
        assertEquals("Freeze chicken", OBSERVER.getTaskTitles().get(0));
    }

    @Test
    void testCompleteTaskMultipleTasks() {
        ViewModel viewModel = getViewModel();

        viewModel.newTask(4, "Freeze chicken");
        viewModel.newTask(3, "Freeze chicken");
        viewModel.newTask(4, "Freeze hamburgers");
        viewModel.completeTask(4, "Freeze chicken", true);

        assertEquals(4, OBSERVER.getDayIndex());
        assertEquals(2, OBSERVER.getTaskTitles().size());
        assertEquals(2, OBSERVER.getTaskCompletionStatuses().size());
        assertEquals(true, OBSERVER.getTaskCompletionStatuses().get(0));
        assertEquals("Freeze chicken", OBSERVER.getTaskTitles().get(0));

        viewModel.completeTask(4, "Freeze chicken", false);

        assertEquals(4, OBSERVER.getDayIndex());
        assertEquals(2, OBSERVER.getTaskTitles().size());
        assertEquals(2, OBSERVER.getTaskCompletionStatuses().size());
        assertEquals(false, OBSERVER.getTaskCompletionStatuses().get(0));
        assertEquals("Freeze chicken", OBSERVER.getTaskTitles().get(0));

    }

    @Test
    void testDeleteEvent() {
        ViewModel viewModel = getViewModel();

        viewModel.newEvent(5, "Sleep", LocalTime.parse("20:30"), LocalTime.parse("23:59"));
        viewModel.deleteEvent(5, "Sleep");

        assertEquals(5, OBSERVER.getDayIndex());
        assertEquals(new ArrayList<String>(), OBSERVER.getEventTitles());
        assertEquals(new ArrayList<String>(), OBSERVER.getStartTimes());
        assertEquals(new ArrayList<String>(), OBSERVER.getEndTimes());
    }

    @Test
    void testDeleteEventMultipleEvents() {
        ViewModel viewModel = getViewModel();

        viewModel.newEvent(5, "Sleep", LocalTime.parse("20:30"), LocalTime.parse("23:59"));
        viewModel.newEvent(5, "Get ready", LocalTime.parse("08:30"), LocalTime.parse("13:59"));
        viewModel.deleteEvent(5, "Sleep");

        assertEquals(5, OBSERVER.getDayIndex());
        assertEquals(1, OBSERVER.getEventTitles().size());
        assertEquals(1, OBSERVER.getStartTimes().size());
        assertEquals(1, OBSERVER.getEndTimes().size());
        assertEquals("Get ready", OBSERVER.getEventTitles().get(0));
        assertEquals("08:30", OBSERVER.getStartTimes().get(0));
        assertEquals("13:59", OBSERVER.getEndTimes().get(0));
    }

    @Test
    void testDeleteTask() {
        ViewModel viewModel = getViewModel();

        viewModel.newTask(3, "Groceries");
        viewModel.deleteTask(3, "Groceries");

        assertEquals(3, OBSERVER.getDayIndex());
        assertEquals(new ArrayList<String>(), OBSERVER.getTaskTitles());
        assertEquals(new ArrayList<Boolean>(), OBSERVER.getTaskCompletionStatuses());
    }

    @Test
    void testDeleteTaskMultipleTasks() {
        ViewModel viewModel = getViewModel();

        viewModel.newTask(3, "Groceries");
        viewModel.newTask(2, "Groceries");
        viewModel.newTask(2, "Homework");
        viewModel.newTask(2, "Give Daniel a high five");
        viewModel.deleteTask(2, "Groceries");

        assertEquals(2, OBSERVER.getDayIndex());
        assertEquals(2, OBSERVER.getTaskTitles().size());
        assertEquals(2, OBSERVER.getTaskCompletionStatuses().size());
        assertEquals(false, OBSERVER.getTaskCompletionStatuses().get(0));
        assertEquals(false, OBSERVER.getTaskCompletionStatuses().get(1));
        assertEquals("Give Daniel a high five", OBSERVER.getTaskTitles().get(0));
        assertEquals("Homework", OBSERVER.getTaskTitles().get(1));
    }

    @Test
    void testClearAll() {
        ViewModel viewModel = getViewModel();

        viewModel.newTask(4, "Freeze chicken");
        viewModel.newTask(3, "Freeze chicken");
        viewModel.newTask(4, "Freeze hamburgers");
        viewModel.completeTask(4, "Freeze chicken", true);
        viewModel.completeTask(4, "Freeze chicken", false);
        viewModel.newEvent(5, "Sleep", LocalTime.parse("20:30"), LocalTime.parse("23:59"));
        viewModel.modifyEvent(5, "Sleep", "Study", LocalTime.parse("17:30"),
                LocalTime.parse("23:45"));
        viewModel.newEvent(1, "Relax", LocalTime.parse("15:30"), LocalTime.parse("19:45"));

        viewModel.clearAll();

        // Due to the structure of the view model and observer only the last day can be checked.
        assertEquals(6, OBSERVER.getDayIndex());
        assertEquals(new ArrayList<String>(), OBSERVER.getStartTimes());
        assertEquals(new ArrayList<String>(), OBSERVER.getEndTimes());
        assertEquals(new ArrayList<String>(), OBSERVER.getEventTitles());
        assertEquals(new ArrayList<String>(), OBSERVER.getTaskTitles());
        assertEquals(new ArrayList<Boolean>(), OBSERVER.getTaskCompletionStatuses());
    }

    @Test
    void testGetEventStartTime() {
        ViewModel viewModel = getViewModel();

        viewModel.newEvent(5, "Sleep", LocalTime.parse("20:30"), LocalTime.parse("23:59"));
        assertEquals("20:30", viewModel.getEventStartTime(5, "Sleep"));
    }

    @Test
    void testGetEventEndTime() {
        ViewModel viewModel = getViewModel();

        viewModel.newEvent(5, "Sleep", LocalTime.parse("20:30"), LocalTime.parse("23:59"));
        assertEquals("23:59", viewModel.getEventEndTime(5, "Sleep"));
    }

    @Test
    void testGetTaskCompletion() {
        ViewModel viewModel = getViewModel();

        viewModel.newTask(2, "Hello");
        assertFalse(viewModel.getTaskCompletion(2, "Hello"));
        viewModel.completeTask(2, "Hello", true);
        assertTrue(viewModel.getTaskCompletion(2, "Hello"));
    }

    private static class TestingObserver implements ViewModelObserver {
        int dayIndex;
        ArrayList<String> eventTitles;
        ArrayList<String> startTimes;
        ArrayList<String> endTimes;
        ArrayList<String> taskTitles;
        ArrayList<Boolean> taskCompletionStatuses;


        @Override
        public void updateEventSectionOnDay(int dayIndex, ArrayList<String> eventTitles, ArrayList<String> startTimes,
                                            ArrayList<String> endTimes) {
            this.dayIndex = dayIndex;
            this.eventTitles = eventTitles;
            this.startTimes = startTimes;
            this.endTimes = endTimes;
        }

        @Override
        public void updateTaskSectionOnDay(int dayIndex, ArrayList<String> taskTitles,
                                           ArrayList<Boolean> taskCompletionStatuses) {
            this.dayIndex = dayIndex;
            this.taskTitles = taskTitles;
            this.taskCompletionStatuses = taskCompletionStatuses;
        }

        public int getDayIndex() {
            return dayIndex;
        }

        public ArrayList<String> getEventTitles() {
            return eventTitles;
        }

        public ArrayList<String> getStartTimes() {
            return startTimes;
        }

        public ArrayList<String> getEndTimes() {
            return endTimes;
        }

        public ArrayList<String> getTaskTitles() {
            return taskTitles;
        }

        public ArrayList<Boolean> getTaskCompletionStatuses() {
            return taskCompletionStatuses;
        }
    }

}