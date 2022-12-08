package delete_event_use_case;

import entities.Day;
import entities.Event;
import entities.Task;
import data_access.WeekDataAccess;

import java.time.LocalTime;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import screens.ViewModel;
import screens.ViewModelBoundary;

import static org.junit.jupiter.api.Assertions.*;

class DeleteEventInteractorTest extends WeekDataAccess {
    static ViewModelBoundary VIEW_MODEL = getViewModel();

    private final static DeleteEventInputData INPUT_DATA = new DeleteEventInputData(
            5, "Event");
    private final static DeleteEventPresenter OUTPUT_BOUNDARY = new DeleteEventPresenter(VIEW_MODEL);
    private final static DeleteEventDataAccess DS_GATEWAY = new DeleteEventDataAccess();

    private static ViewModel getViewModel() {
        ArrayList<Day> days = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            days.add(new Day(new HashMap<>(), new HashMap<>()));
        }
        return new ViewModel(days);
    }

    @Test
    public void testDeleteEventInteractor() {
        Event event = new Event("Event", LocalTime.parse("09:00"), LocalTime.parse("10:00"));
        HashMap<String, Task> tasks = new HashMap<>();
        HashMap<String, Event> events = new HashMap<>();
        events.put("Event", event);
        Day day = new Day(tasks, events);
        WeekDataAccess.days.set(5, day);

        DeleteEventInputBoundary inputBoundary = new DeleteEventInteractor(OUTPUT_BOUNDARY, DS_GATEWAY);
        DeleteEventOutputData outputData = inputBoundary.delete(INPUT_DATA);

        assertEquals(5, outputData.getDayIndex());
        assertEquals("Event", outputData.getLabel());
        assertTrue(day.getTasks().isEmpty());
        assertTrue(outputData.getSuccess());
    }
}