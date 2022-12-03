package delete_event_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessEvent;
import data_access.DataAccessTask;
import data_access.WeekDataAccess;

import java.time.LocalTime;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeleteEventInteractorTest extends WeekDataAccess {
    private final static DeleteEventInputData INPUT_DATA = new DeleteEventInputData(
            5, "Event");

    private final static DeleteEventPresenter OUTPUT_BOUNDARY = new DeleteEventPresenter();
    private final static DeleteEventDataAccess DS_GATEWAY = new DeleteEventDataAccess();

    @Test
    public void testDeleteEventInteractor() {
        DataAccessEvent event = new DataAccessEvent("Event", LocalTime.parse("09:00"), LocalTime.parse("10:00"));
        HashMap<String, DataAccessTask> tasks = new HashMap<>();
        HashMap<String, DataAccessEvent> events = new HashMap<>();
        events.put("Event", event);
        DataAccessDay day = new DataAccessDay(tasks, events);
        WeekDataAccess.days.set(5, day);

        DeleteEventInputBoundary inputBoundary = new DeleteEventInteractor(OUTPUT_BOUNDARY, DS_GATEWAY);
        DeleteEventOutputData outputData = inputBoundary.delete(INPUT_DATA);

        assertEquals(5, outputData.getDayIndex());
        assertEquals("Event", outputData.getLabel());
        assertTrue(day.getTasks().isEmpty());
        assertTrue(outputData.getSuccess());
    }
}