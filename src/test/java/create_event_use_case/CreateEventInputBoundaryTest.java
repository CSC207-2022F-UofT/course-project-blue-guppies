package create_event_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessEvent;
import entities.EventFactory;
import java.time.LocalTime;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Create Event Input Boundary Test Cases.
 * @author Raghav Arora
 */
class CreateEventInputBoundaryTest {
    private final static CreateEventOutputBoundary outputBoundary = new CreateEventPresenter();
    private final static CreateEventDataAccess dataAccess = new CreateEventDataAccess();
    private final static CreateEventDsGateway dsGateway = dataAccess;
    private final static EventFactory eventFactory = new EventFactory();
    private final static CreateEventInputBoundary inputBoundary = new CreateEventInteractor(
            dsGateway, outputBoundary, eventFactory
    );
    private final static CreateEventInputData inputData1 = new CreateEventInputData(
            "Sample Event", "09:00", "10:00", "Sunday"
    );
    private final static CreateEventInputData inputData2 = new CreateEventInputData(
            "Sample Event", "09:00", "10:00", "Monday"
    );
    private final static CreateEventInputData inputData3 = new CreateEventInputData(
            "Sample Event", "10:30", "11:30", "Sunday"
    );
    private final static CreateEventInputData inputData4 = new CreateEventInputData(
            "Another Sample Event", "9:30", "11:00", "Sunday"
    );

    @Test
    void testCreateEvent() {
        CreateEventOutputData outputData = inputBoundary.createEvent(inputData1);

        assertEquals(0, outputData.getDayIndex());
        assertEquals(LocalTime.parse("09:00"), outputData.getStartTime());
        assertEquals(LocalTime.parse("10:00"), outputData.getEndTime());
        assertTrue(outputData.isSuccess());

        // check if an Event with the name "Sample Event" exists for day 0 i.e. Sunday
        assertTrue(dataAccess.getDays().get(0).getEvents().containsKey("Sample Event"));
        assertEquals(
                inputData1.getTitle(),
                dataAccess.getDays().get(0).getEvents().get("Sample Event").getTitle()
        );
    }

    @Test
    void testCreateEventSameTitleDifferentDay() {
        // Suppose an event with the name "Sample Event" already exists on day 0/Sunday.
        DataAccessEvent event = new DataAccessEvent(
                "Sample Event", LocalTime.parse("09:00"), LocalTime.parse("10:00")
        );
        HashMap<String, DataAccessEvent> events = new HashMap<>();
        events.put("Sample Event", event);
        DataAccessDay referenceDay = dataAccess.getDays().get(0);
        referenceDay.setEvents(events);
        dataAccess.getDays().set(0, referenceDay);

        // We should be able to create an event with name "Sample Event" for a day OTHER than Sunday.
        // In this case, we create an event called "Sample Task" for day 1/Monday.
        CreateEventOutputData outputData = inputBoundary.createEvent(inputData2);

        assertEquals(1, outputData.getDayIndex());
        assertEquals(LocalTime.parse("09:00"), outputData.getStartTime());
        assertEquals(LocalTime.parse("10:00"), outputData.getEndTime());
        assertTrue(outputData.isSuccess());

        // check if an Event with the name "Sample Event" exists for day 1 i.e. Monday
        assertTrue(dataAccess.getDays().get(1).getEvents().containsKey("Sample Event"));
        assertEquals(
                inputData2.getTitle(),
                dataAccess.getDays().get(1).getEvents().get("Sample Event").getTitle()
        );
    }

    @Test
    void testCreateEventSameTitleSameDayDifferentTime() {
        // Suppose an event with the name "Sample Event" already exists on day 0/Sunday.
        DataAccessEvent event = new DataAccessEvent(
                "Sample Event", LocalTime.parse("09:00"), LocalTime.parse("10:00")
        );
        HashMap<String, DataAccessEvent> events = new HashMap<>();
        events.put("Sample Event", event);
        DataAccessDay referenceDay = dataAccess.getDays().get(0);
        referenceDay.setEvents(events);
        dataAccess.getDays().set(0, referenceDay);

        // We should NOT be able to create an event with name "Sample Event" for the same day (i.e. day 0/Sunday),
        // even if their times do not overlap.
        CreateEventOutputData outputData = inputBoundary.createEvent(inputData3);
        assertFalse(outputData.isSuccess());

        // An event with name "Sample Event" continues to exist for day 0, but
        // does NOT begin and end at 10:30 and 11:30 respectively.
        assertTrue(dataAccess.getDays().get(0).getEvents().containsKey("Sample Event"));
        assertNotEquals(
                LocalTime.parse(inputData2.getStartTime()),
                dataAccess.getDays().get(0).getEvents().get("Sample Event").getStartTime()
        );
        assertNotEquals(
                LocalTime.parse(inputData2.getEndTime()),
                dataAccess.getDays().get(0).getEvents().get("Sample Event").getEndTime()
        );

        // The event continues to begin at 09:00 and end at 10:00
        assertEquals(
                LocalTime.parse("09:00"),
                dataAccess.getDays().get(0).getEvents().get("Sample Event").getStartTime()
        );
        assertEquals(
                LocalTime.parse("10:00"),
                dataAccess.getDays().get(0).getEvents().get("Sample Event").getEndTime()
        );
    }

    @Test
    void testCreateEventDifferentTitleSameDayConflictingTime() {
        // Suppose an event with the name "Sample Event" already exists on day 0/Sunday.
        DataAccessEvent event = new DataAccessEvent(
                "Sample Event", LocalTime.parse("09:00"), LocalTime.parse("10:00")
        );
        HashMap<String, DataAccessEvent> events = new HashMap<>();
        events.put("Sample Event", event);
        DataAccessDay referenceDay = dataAccess.getDays().get(0);
        referenceDay.setEvents(events);
        dataAccess.getDays().set(0, referenceDay);

        // We should NOT be able to create an event with name "Another Sample Event" for the same day (i.e. day 0/Sunday),
        // if its timings overlap with that of "Sample Event"
        CreateEventOutputData outputData = inputBoundary.createEvent(inputData4);
        assertFalse(outputData.isSuccess());

        // An event with name "Another Sample Event" is not created for day 0/Sunday.
        assertFalse(dataAccess.getDays().get(0).getEvents().containsKey("Another Sample Event"));
    }
}
