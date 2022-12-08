package create_event_use_case;

import entities.Day;
import entities.Event;
import entities.EventFactory;
import org.junit.jupiter.api.Test;
import screens.ViewModel;
import screens.ViewModelBoundary;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Create Event Interactor Test Cases.
 * @author Raghav Arora, Anna Myllyniemi
 */
class CreateEventInteractorTest {
    static ViewModelBoundary VIEW_MODEL = getViewModel();
    private final static CreateEventOutputBoundary OUTPUT_BOUNDARY = new CreateEventPresenter(VIEW_MODEL);
    private final static CreateEventDataAccess DATA_ACCESS = new CreateEventDataAccess();
    private final static CreateEventDsGateway DS_GATEWAY = DATA_ACCESS;
    private final static EventFactory EVENT_FACTORY = new EventFactory();
    private final static CreateEventInputBoundary INPUT_BOUNDARY = new CreateEventInteractor(
            DS_GATEWAY, OUTPUT_BOUNDARY, EVENT_FACTORY
    );
    private final static CreateEventInputData INPUT_DATA_1 = new CreateEventInputData(
            "Sample Event", "09:00", "10:00", "Sunday"
    );
    private final static CreateEventInputData INPUT_DATA_2 = new CreateEventInputData(
            "Sample Event", "09:00", "10:00", "Monday"
    );
    private final static CreateEventInputData INPUT_DATA_3 = new CreateEventInputData(
            "Sample Event", "10:30", "11:30", "Sunday"
    );
    private final static CreateEventInputData INPUT_DATA_4 = new CreateEventInputData(
            "Another Sample Event", "09:30", "11:00", "Sunday"
    );

    private static ViewModel getViewModel() {
        ArrayList<Day> days = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            days.add(new Day(new HashMap<>(), new HashMap<>()));
        }
        return new ViewModel(days);
    }

    @Test
    void testCreateEvent() {
        HashMap<String, Event> events = new HashMap<>();
        Day referenceDay = DATA_ACCESS.getDays().get(0);
        referenceDay.setEvents(events);
        DATA_ACCESS.getDays().set(0, referenceDay);

        CreateEventOutputData outputData = INPUT_BOUNDARY.createEvent(INPUT_DATA_1);

        assertEquals(0, outputData.getDayIndex());
        assertEquals(LocalTime.parse("09:00"), outputData.getStartTime());
        assertEquals(LocalTime.parse("10:00"), outputData.getEndTime());
        assertTrue(outputData.isSuccess());

        // check if an Event with the name "Sample Event" exists for day 0 i.e. Sunday
        assertTrue(DATA_ACCESS.getDays().get(0).getEvents().containsKey("Sample Event"));
        assertEquals(INPUT_DATA_1.getTitle(), DATA_ACCESS.getDays().get(0).getEvents().get("Sample Event").getTitle());

    }

    @Test
    void testCreateEventSameTitleDifferentDay() {
        // Suppose an event with the name "Sample Event" already exists on day 0/Sunday.
        Event event = new Event(
                "Sample Event", LocalTime.parse("09:00"), LocalTime.parse("10:00")
        );
        HashMap<String, Event> events = new HashMap<>();
        events.put("Sample Event", event);
        Day referenceDay = DATA_ACCESS.getDays().get(0);
        referenceDay.setEvents(events);
        DATA_ACCESS.getDays().set(0, referenceDay);

        HashMap<String, Event> eventsMonday = new HashMap<>();
        Day referenceDayMonday = DATA_ACCESS.getDays().get(1);
        referenceDayMonday.setEvents(eventsMonday);
        DATA_ACCESS.getDays().set(1, referenceDayMonday);

        // We should be able to create an event with name "Sample Event" for a day OTHER than Sunday.
        // In this case, we create an event called "Sample Task" for day 1/Monday.
        CreateEventOutputData outputData = INPUT_BOUNDARY.createEvent(INPUT_DATA_2);

        assertEquals(1, outputData.getDayIndex());
        assertEquals(LocalTime.parse("09:00"), outputData.getStartTime());
        assertEquals(LocalTime.parse("10:00"), outputData.getEndTime());
        assertTrue(outputData.isSuccess());

        // check if an Event with the name "Sample Event" exists for day 1 i.e. Monday
        assertTrue(DATA_ACCESS.getDays().get(1).getEvents().containsKey("Sample Event"));
        assertEquals(
                INPUT_DATA_2.getTitle(),
                DATA_ACCESS.getDays().get(1).getEvents().get("Sample Event").getTitle()
        );
    }

    @Test
    void testCreateEventSameTitleSameDayDifferentTime() {
        // Suppose an event with the name "Sample Event" already exists on day 0/Sunday.
        Event event = new Event(
                "Sample Event", LocalTime.parse("09:00"), LocalTime.parse("10:00")
        );
        HashMap<String, Event> events = new HashMap<>();
        events.put("Sample Event", event);
        Day referenceDay = DATA_ACCESS.getDays().get(0);
        referenceDay.setEvents(events);
        DATA_ACCESS.getDays().set(0, referenceDay);

        // We should NOT be able to create an event with name "Sample Event" for the same day (i.e. day 0/Sunday),
        // even if their times do not overlap.
        CreateEventOutputData outputData = INPUT_BOUNDARY.createEvent(INPUT_DATA_3);
        assertFalse(outputData.isSuccess());
        assertEquals("Event with name 'Sample Event' already exists on Sunday", outputData.getErrorMessage());

        // An event with name "Sample Event" continues to exist for day 0, but
        // does NOT begin and end at 10:30 and 11:30 respectively.
        assertTrue(DATA_ACCESS.getDays().get(0).getEvents().containsKey("Sample Event"));
        assertNotEquals(
                LocalTime.parse(INPUT_DATA_3.getStartTime()),
                DATA_ACCESS.getDays().get(0).getEvents().get("Sample Event").getStartTime()
        );
        assertNotEquals(
                LocalTime.parse(INPUT_DATA_3.getEndTime()),
                DATA_ACCESS.getDays().get(0).getEvents().get("Sample Event").getEndTime()
        );

        // The event continues to begin at 09:00 and end at 10:00
        assertEquals(
                LocalTime.parse("09:00"),
                DATA_ACCESS.getDays().get(0).getEvents().get("Sample Event").getStartTime()
        );
        assertEquals(
                LocalTime.parse("10:00"),
                DATA_ACCESS.getDays().get(0).getEvents().get("Sample Event").getEndTime()
        );
    }

    @Test
    void testCreateEventDifferentTitleSameDayConflictingTime() {
        // Suppose an event with the name "Sample Event" already exists on day 0/Sunday.
        Event event = new Event(
                "Sample Event", LocalTime.parse("09:00"), LocalTime.parse("10:00")
        );
        HashMap<String, Event> events = new HashMap<>();
        events.put("Sample Event", event);
        Day referenceDay = DATA_ACCESS.getDays().get(0);
        referenceDay.setEvents(events);
        DATA_ACCESS.getDays().set(0, referenceDay);

        // We should NOT be able to create an event with name "Another Sample Event" for the same day (i.e. day 0/Sunday),
        // if its timings overlap with that of "Sample Event"
        CreateEventOutputData outputData = INPUT_BOUNDARY.createEvent(INPUT_DATA_4);
        assertFalse(outputData.isSuccess());
        assertEquals("This event conflicts with an existing event.", outputData.getErrorMessage());

        // An event with name "Another Sample Event" is not created for day 0/Sunday.
        assertFalse(DATA_ACCESS.getDays().get(0).getEvents().containsKey("Another Sample Event"));
    }

    @Test
    void testCreateEventStartTimeNotBeforeEndTime() {
        CreateEventInputData inputData = new CreateEventInputData("Relax", "11:30", "10:30",
                "Wednesday");
        CreateEventOutputData outputData = INPUT_BOUNDARY.createEvent(inputData);
        assertFalse(outputData.isSuccess());
        assertEquals("Start time is not before end time.", outputData.getErrorMessage());

    }

    @Test
    void testCreateEventStartTimeNotValid() {
        CreateEventInputData inputData = new CreateEventInputData("Cry", "1:30", "10:30",
                "Thursday");
        CreateEventOutputData outputData = INPUT_BOUNDARY.createEvent(inputData);
        assertFalse(outputData.isSuccess());
        assertEquals("Start time is not a valid time. \nEx: 21:39", outputData.getErrorMessage());

    }

    @Test
    void testCreateEventEndTimeNotValid() {
        CreateEventInputData inputData = new CreateEventInputData("Laugh", "11:30", "12:60",
                "Thursday");
        CreateEventOutputData outputData = INPUT_BOUNDARY.createEvent(inputData);
        assertFalse(outputData.isSuccess());
        assertEquals("End time is not a valid time. \nEx: 21:39", outputData.getErrorMessage());

    }

}