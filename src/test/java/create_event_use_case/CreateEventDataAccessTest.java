package create_event_use_case;

import entities.Day;
import entities.Event;
import entities.EventFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Create Event Data Access Test Cases.
 * @author Raghav Arora, Anna Myllyniemi
 */
class CreateEventDataAccessTest {
    private final static CreateEventDataAccess DATA_ACCESS = new CreateEventDataAccess();
    private final static CreateEventDsGateway DS_GATEWAY = DATA_ACCESS;

    @Test
    void testEventDoesNotExistByTitle() {
        assertFalse(DS_GATEWAY.eventExistsByTitle("New Event", 0));
    }

    @Test
    void testEventExistsByTitle() {
        Event event = new Event(
                "Sample Event",
                LocalTime.parse("09:00"),
                LocalTime.parse("10:00")
        );
        // Make day 0 i.e. Sunday have an event called "Sample Event"
        HashMap<String, Event> events = new HashMap<>();
        events.put("Sample Event", event);
        Day day = DATA_ACCESS.getDays().get(0);
        day.setEvents(events);

        assertTrue(DS_GATEWAY.eventExistsByTitle("Sample Event", 0));
    }

    @Test
    void testSave() {
        EventFactory eventFactory = new EventFactory();
        Event event = eventFactory.createEvent("Sample Event", LocalTime.parse("09:00"),
                LocalTime.parse("10:00"));
        CreateEventDsInputData dsInputData =  new CreateEventDsInputData(0, event);
        DS_GATEWAY.save(dsInputData);

        // check whether an Event by the name "Sample Event" was created for day 0 i.e. Sunday
        assertTrue(DATA_ACCESS.getDays().get(0).getEvents().containsKey("Sample Event"));
        //assertEquals(dsInputData.getNewEvent(), DATA_ACCESS.getDays().get(0).getEvents().get("Sample Event"));
        assertEquals("Sample Event", DATA_ACCESS.getDays().get(0).getEvents().get("Sample Event").getTitle());
        assertEquals(LocalTime.parse("09:00"),
                DATA_ACCESS.getDays().get(0).getEvents().get("Sample Event").getStartTime());
        assertEquals(LocalTime.parse("10:00"),
                DATA_ACCESS.getDays().get(0).getEvents().get("Sample Event").getEndTime());
    }

    @Test
    void testIsTimeConflictNoExistingEvents() {
        assertFalse(DS_GATEWAY.isTimeConflict(3, LocalTime.parse("11:30"), LocalTime.parse("12:30")));
    }

    @Test
    void testIsTimeConflictNoConflictingEvents() {
        EventFactory eventFactory = new EventFactory();
        Event event = eventFactory.createEvent("Study", LocalTime.parse("09:00"),
                LocalTime.parse("10:00"));
        DS_GATEWAY.save(new CreateEventDsInputData(2, event));
        assertFalse(DS_GATEWAY.isTimeConflict(2, LocalTime.parse("11:30"), LocalTime.parse("12:30")));
    }

    @Test
    void testIsTimeConflictConflictingEventBefore() {
        EventFactory eventFactory = new EventFactory();
        Event event = eventFactory.createEvent("Study", LocalTime.parse("09:00"),
                LocalTime.parse("12:00"));
        DS_GATEWAY.save(new CreateEventDsInputData(5, event));
        assertTrue(DS_GATEWAY.isTimeConflict(5, LocalTime.parse("11:30"), LocalTime.parse("12:30")));
    }

    @Test
    void testIsTimeConflictConsecutiveEvents() {
        EventFactory eventFactory = new EventFactory();
        Event event = eventFactory.createEvent("Study", LocalTime.parse("09:00"),
                LocalTime.parse("12:00"));
        DS_GATEWAY.save(new CreateEventDsInputData(6, event));
        assertFalse(DS_GATEWAY.isTimeConflict(6, LocalTime.parse("08:30"), LocalTime.parse("09:00")));
    }

    @Test
    void testIsTimeConflictConflictingEventAfter() {
        EventFactory eventFactory = new EventFactory();
        Event event = eventFactory.createEvent("Study", LocalTime.parse("09:00"),
                LocalTime.parse("12:00"));
        DS_GATEWAY.save(new CreateEventDsInputData(1, event));
        assertTrue(DS_GATEWAY.isTimeConflict(1, LocalTime.parse("08:30"), LocalTime.parse("09:01")));
    }

    @AfterEach
    public void clearStorage(){
        try {
            PrintWriter pw = new PrintWriter("CleanCalendarStorage.txt"); //deleting the contents of the file
            pw.close();
        }
        catch(IOException e){
            return;
        }
    }
}