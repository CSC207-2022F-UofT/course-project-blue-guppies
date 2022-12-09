package screens;

import entities.Day;
import entities.Event;
import entities.Task;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ViewModelTest {
    static TestingObserver observer = new TestingObserver();

    private static ViewModel getViewModel() {
        ArrayList<Day> days = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            days.add(new Day(new HashMap<>(), new HashMap<>()));
        }
        ViewModel v = new ViewModel(days);
        v.addObserver(observer);
        return v;
    }

    @Test
    void testInitializeWeekViewScreen() {
        ViewModel viewModel = getViewModel();

        viewModel.initializeWeekViewScreen();

        assertEquals(6, observer.getDayIndex());
        assertEquals(new ArrayList<String>(), observer.getStartTimes());
        assertEquals(new ArrayList<String>(), observer.getEndTimes());
        assertEquals(new ArrayList<String>(), observer.getEventTitles());
        assertEquals(new ArrayList<String>(), observer.getTaskTitles());
        assertEquals(new ArrayList<Boolean>(), observer.getTaskCompletionStatuses());
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
        viewModel.addObserver(observer);

        viewModel.initializeWeekViewScreen();

        assertEquals(6, observer.getDayIndex());
        assertEquals(3, observer.getEventTitles().size());
        assertEquals(3, observer.getStartTimes().size());
        assertEquals(3, observer.getEndTimes().size());
        assertEquals(3, observer.getTaskTitles().size());
        assertEquals(3, observer.getTaskCompletionStatuses().size());

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

        assertEquals(startTimes, observer.getStartTimes());
        assertEquals(endTimes, observer.getEndTimes());
        assertEquals(eventTitles, observer.getEventTitles());
        assertEquals(taskTitles, observer.getTaskTitles());
        assertEquals(taskCompletions, observer.getTaskCompletionStatuses());
    }

    @Test
    void testNewEvent() {
        ViewModel viewModel = getViewModel();

        viewModel.newEvent(1, "Relax", LocalTime.parse("15:30"), LocalTime.parse("19:45"));

        assertEquals(1, observer.getDayIndex());
        assertEquals(1, observer.getEventTitles().size());
        assertEquals(1, observer.getStartTimes().size());
        assertEquals(1, observer.getEndTimes().size());
        assertEquals("15:30", observer.getStartTimes().get(0));
        assertEquals("19:45", observer.getEndTimes().get(0));
        assertEquals("Relax", observer.getEventTitles().get(0));
    }

    @Test
    void testNewEventMultipleSameDay() {
        ViewModel viewModel = getViewModel();

        viewModel.newEvent(1, "Clean", LocalTime.parse("05:30"), LocalTime.parse("09:45"));

        assertEquals(1, observer.getDayIndex());
        assertEquals(1, observer.getEventTitles().size());
        assertEquals(1, observer.getStartTimes().size());
        assertEquals(1, observer.getEndTimes().size());
        assertEquals("05:30", observer.getStartTimes().get(0));
        assertEquals("09:45", observer.getEndTimes().get(0));
        assertEquals("Clean", observer.getEventTitles().get(0));

        viewModel.newEvent(1, "Relax", LocalTime.parse("15:30"), LocalTime.parse("19:45"));

        assertEquals(1, observer.getDayIndex());
        assertEquals(2, observer.getEventTitles().size());
        assertEquals(2, observer.getStartTimes().size());
        assertEquals(2, observer.getEndTimes().size());
        assertEquals("15:30", observer.getStartTimes().get(1));
        assertEquals("19:45", observer.getEndTimes().get(1));
        assertEquals("Relax", observer.getEventTitles().get(1));
    }

    @Test
    void testNewEventMultipleDifferentDay() {
        ViewModel viewModel = getViewModel();

        viewModel.newEvent(1, "Relax", LocalTime.parse("15:30"), LocalTime.parse("19:45"));

        assertEquals(1, observer.getDayIndex());
        assertEquals(1, observer.getEventTitles().size());
        assertEquals(1, observer.getStartTimes().size());
        assertEquals(1, observer.getEndTimes().size());
        assertEquals("15:30", observer.getStartTimes().get(0));
        assertEquals("19:45", observer.getEndTimes().get(0));
        assertEquals("Relax", observer.getEventTitles().get(0));

        viewModel.newEvent(2, "Relax", LocalTime.parse("15:30"), LocalTime.parse("19:45"));

        assertEquals(2, observer.getDayIndex());
        assertEquals(1, observer.getEventTitles().size());
        assertEquals(1, observer.getStartTimes().size());
        assertEquals(1, observer.getEndTimes().size());
        assertEquals("15:30", observer.getStartTimes().get(0));
        assertEquals("19:45", observer.getEndTimes().get(0));
        assertEquals("Relax", observer.getEventTitles().get(0));
    }

    @Test
    void testNewTask() {
        ViewModel viewModel = getViewModel();

        viewModel.newTask(3, "Unlock the secrets of the universe");

        assertEquals(3, observer.getDayIndex());
        assertEquals(1, observer.getTaskTitles().size());
        assertEquals(1, observer.getTaskCompletionStatuses().size());
        assertEquals(false, observer.getTaskCompletionStatuses().get(0));
        assertEquals("Unlock the secrets of the universe", observer.getTaskTitles().get(0));
    }

    @Test
    void testNewTaskMultipleTasksSameDay() {
        ViewModel viewModel = getViewModel();

        viewModel.newTask(3, "Unlock the secrets of the universe");
        viewModel.newTask(3, "Cry about the secrets of the universe");

        assertEquals(3, observer.getDayIndex());
        assertEquals(2, observer.getTaskTitles().size());
        assertEquals(2, observer.getTaskCompletionStatuses().size());
        assertEquals(false, observer.getTaskCompletionStatuses().get(1));
        assertEquals("Unlock the secrets of the universe", observer.getTaskTitles().get(1));
    }

    @Test
    void testNewTaskMultipleTasksDifferentDay() {
        ViewModel viewModel = getViewModel();

        viewModel.newTask(3, "Unlock the secrets of the universe");

        assertEquals(3, observer.getDayIndex());
        assertEquals(1, observer.getTaskTitles().size());
        assertEquals(1, observer.getTaskCompletionStatuses().size());
        assertEquals(false, observer.getTaskCompletionStatuses().get(0));
        assertEquals("Unlock the secrets of the universe", observer.getTaskTitles().get(0));

        viewModel.newTask(4, "Cry about the secrets of the universe");

        assertEquals(4, observer.getDayIndex());
        assertEquals(1, observer.getTaskTitles().size());
        assertEquals(1, observer.getTaskCompletionStatuses().size());
        assertEquals(false, observer.getTaskCompletionStatuses().get(0));
        assertEquals("Cry about the secrets of the universe", observer.getTaskTitles().get(0));
    }

    @Test
    void testModifyEventMultipleEvents() {
        ViewModel viewModel = getViewModel();

        viewModel.newEvent(5, "Sleep", LocalTime.parse("20:30"), LocalTime.parse("23:59"));
        viewModel.newEvent(5, "Relax", LocalTime.parse("15:30"), LocalTime.parse("19:45"));
        viewModel.modifyEvent(5, "Sleep", "Study", LocalTime.parse("17:30"),
                LocalTime.parse("23:45"));

        assertEquals(5, observer.getDayIndex());
        assertEquals(2, observer.getEventTitles().size());
        assertEquals(2, observer.getStartTimes().size());
        assertEquals(2, observer.getEndTimes().size());
        assertEquals("17:30", observer.getStartTimes().get(1));
        assertEquals("23:45", observer.getEndTimes().get(1));
        assertEquals("Study", observer.getEventTitles().get(1));
    }

    @Test
    void testModifyEvent() {
        ViewModel viewModel = getViewModel();

        viewModel.newEvent(5, "Sleep", LocalTime.parse("20:30"), LocalTime.parse("23:59"));
        viewModel.modifyEvent(5, "Sleep", "Study", LocalTime.parse("17:30"),
                LocalTime.parse("23:45"));

        assertEquals(5, observer.getDayIndex());
        assertEquals(1, observer.getEventTitles().size());
        assertEquals(1, observer.getStartTimes().size());
        assertEquals(1, observer.getEndTimes().size());
        assertEquals("17:30", observer.getStartTimes().get(0));
        assertEquals("23:45", observer.getEndTimes().get(0));
        assertEquals("Study", observer.getEventTitles().get(0));
    }

    @Test
    void testModifyTask() {
        ViewModel viewModel = getViewModel();

        viewModel.newTask(3, "Unlock the secrets of the universe");
        viewModel.modifyTask(3, "Unlock the secrets of the universe", "Clean room :(");

        assertEquals(3, observer.getDayIndex());
        assertEquals(1, observer.getTaskTitles().size());
        assertEquals(1, observer.getTaskCompletionStatuses().size());
        assertEquals(false, observer.getTaskCompletionStatuses().get(0));
        assertEquals("Clean room :(", observer.getTaskTitles().get(0));
    }

    @Test
    void testModifyTaskMultipleTasks() {
        ViewModel viewModel = getViewModel();

        viewModel.newTask(3, "Unlock the secrets of the universe");
        viewModel.newTask(4, "Unlock the secrets of the universe");
        viewModel.newTask(5, "Unlock the secrets of the universe");
        viewModel.newTask(5, "Leave room");
        viewModel.modifyTask(5, "Leave room", "zzzzzzzzzzzzzzzzzzzzzzzzzzzz");

        assertEquals(5, observer.getDayIndex());
        assertEquals(2, observer.getTaskTitles().size());
        assertEquals(2, observer.getTaskCompletionStatuses().size());
        assertEquals(false, observer.getTaskCompletionStatuses().get(1)); // index 1 because items are sorted
        assertEquals("zzzzzzzzzzzzzzzzzzzzzzzzzzzz", observer.getTaskTitles().get(1));
    }

    @Test
    void testCompleteTask() {
        ViewModel viewModel = getViewModel();

        viewModel.newTask(4, "Freeze chicken");
        viewModel.completeTask(4, "Freeze chicken", true);

        assertEquals(4, observer.getDayIndex());
        assertEquals(1, observer.getTaskTitles().size());
        assertEquals(1, observer.getTaskCompletionStatuses().size());
        assertEquals(true, observer.getTaskCompletionStatuses().get(0));
        assertEquals("Freeze chicken", observer.getTaskTitles().get(0));
    }

    @Test
    void testCompleteTaskMultipleTasks() {
        ViewModel viewModel = getViewModel();

        viewModel.newTask(4, "Freeze chicken");
        viewModel.newTask(3, "Freeze chicken");
        viewModel.newTask(4, "Freeze hamburgers");
        viewModel.completeTask(4, "Freeze chicken", true);

        assertEquals(4, observer.getDayIndex());
        assertEquals(2, observer.getTaskTitles().size());
        assertEquals(2, observer.getTaskCompletionStatuses().size());
        assertEquals(true, observer.getTaskCompletionStatuses().get(0));
        assertEquals("Freeze chicken", observer.getTaskTitles().get(0));

        viewModel.completeTask(4, "Freeze chicken", false);

        assertEquals(4, observer.getDayIndex());
        assertEquals(2, observer.getTaskTitles().size());
        assertEquals(2, observer.getTaskCompletionStatuses().size());
        assertEquals(false, observer.getTaskCompletionStatuses().get(0));
        assertEquals("Freeze chicken", observer.getTaskTitles().get(0));

    }

    @Test
    void testDeleteEvent() {
    }

    @Test
    void testDeleteTask() {
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
        assertEquals(6, observer.getDayIndex());
        assertEquals(new ArrayList<String>(), observer.getStartTimes());
        assertEquals(new ArrayList<String>(), observer.getEndTimes());
        assertEquals(new ArrayList<String>(), observer.getEventTitles());
        assertEquals(new ArrayList<String>(), observer.getTaskTitles());
        assertEquals(new ArrayList<Boolean>(), observer.getTaskCompletionStatuses());
    }

    @Test
    void testGetEventStartTime() {
    }

    @Test
    void testGetEventEndTime() {
    }

    @Test
    void testGetTaskCompletion() {
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