package screens;

import entities.Day;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

class ViewModelTest {
    static ViewModel VIEW_MODEL = getViewModel();
    static ViewModelObserver observer = new testingObserver();

    @BeforeAll
    static void testSetup() {
        VIEW_MODEL = getViewModel();
    }

    private static ViewModel getViewModel() {
        ArrayList<Day> days = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            days.add(new Day(new HashMap<>(), new HashMap<>()));
        }
        return new ViewModel(days);
    }

    @Test
    void testInitializeWeekViewScreen() {
        VIEW_MODEL.addObserver();
    }

    @Test
    void testAddObserver() {
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

    private static class testingObserver implements ViewModelObserver {

        @Override
        public void updateEventSectionOnDay(int dayIndex, ArrayList<String> eventTitles, ArrayList<String> startTimes,
                                            ArrayList<String> endTimes) {
            // Left empty on purpose.
        }

        @Override
        public void updateTaskSectionOnDay(int dayIndex, ArrayList<String> taskTitles,
                                           ArrayList<Boolean> taskCompletionStatuses) {
            // Left empty on purpose.
        }
    }
}