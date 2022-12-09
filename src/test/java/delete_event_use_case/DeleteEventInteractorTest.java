package delete_event_use_case;

import entities.Day;
import entities.Event;
import entities.Task;
import data_access.WeekDataAccess;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import java.util.HashMap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeleteEventInteractorTest extends WeekDataAccess {
    private final static DeleteEventInputData INPUT_DATA = new DeleteEventInputData(
            5, "Event");

    private final static DeleteEventPresenter OUTPUT_BOUNDARY = new DeleteEventPresenter();
    private final static DeleteEventDataAccess DS_GATEWAY = new DeleteEventDataAccess();

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

    @AfterEach
    public void clearStorage(){
        try {
            PrintWriter pw = new PrintWriter("CleanCalendarStorage.txt"); //deleting the contents of the file
            pw.close();
        }
        catch(IOException ignored){
        }
    }
}