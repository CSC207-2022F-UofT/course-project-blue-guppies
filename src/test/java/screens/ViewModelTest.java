package screens;

import entities.Day;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ViewModelTest {
    static ViewModel VIEW_MODEL = getViewModel();
    static TestingObserver observer = new TestingObserver();

    @BeforeAll
    static void testSetup() {
        VIEW_MODEL = getViewModel();
    }

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
        VIEW_MODEL.initializeWeekViewScreen();
        assertEquals(6, observer.getDayIndex());
        assertEquals(new ArrayList<String>(), observer.getStartTimes());
        assertEquals(new ArrayList<String>(), observer.getEndTimes());
        assertEquals(new ArrayList<String>(), observer.getEventTitles());
        assertEquals(new ArrayList<String>(), observer.getTaskTitles());
        assertEquals(new ArrayList<Boolean>(), observer.getTaskCompletionStatuses());
    }

    @Test
    void testNewEvent() {
    }

    @Test
    void testNewTask() {
    }

    @Test
    void testModifyEvent() {
    }

    @Test
    void testModifyTask() {
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