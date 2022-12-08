package screens;

import entities.Day;
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
    void testModifyEvent() {
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
    void testCompleteTask() {
    }

    @Test
    void testDeleteEvent() {
    }

    @Test
    void testDeleteTask() {
    }

    @Test
    void testClearAll() {
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