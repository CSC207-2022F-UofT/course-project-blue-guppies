package create_event_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessEvent;
import entities.Event;
import entities.EventFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Create Event Ds Gateway Test Cases.
 * @author Raghav Arora
 */
class CreateEventDsGatewayTest {
    private final static CreateEventDataAccess DATA_ACCESS = new CreateEventDataAccess();
    private final static CreateEventDsGateway DS_GATEWAY = DATA_ACCESS;

    @Test
    void testEventDoesNotExistByTitle() {
        assertFalse(DS_GATEWAY.eventExistsByTitle("New Event", 0));
    }

    @Test
    void testEventExistsByTitle() {
        DataAccessEvent event = new DataAccessEvent(
                "Sample Event",
                LocalTime.parse("09:00"),
                LocalTime.parse("10:00")
        );
        // Make day 0 i.e. Sunday have an event called "Sample Event"
        HashMap<String, DataAccessEvent> events = new HashMap<>();
        events.put("Sample Event", event);
        DataAccessDay day = DATA_ACCESS.getDays().get(0);
        day.setEvents(events);

        assertTrue(DS_GATEWAY.eventExistsByTitle("Sample Event", 0));
    }

    @Test
    void testSave() {
        EventFactory eventFactory = new EventFactory();
        Event event = eventFactory.createEvent("Sample Event", LocalTime.parse("09:00"),
                LocalTime.parse("10:00"));
        CreateEventDsInputData dsInputData =  new CreateEventDsInputData(
                "Sample Event", LocalTime.parse("09:00"),
                LocalTime.parse("10:00"), 0, event
        );
        DS_GATEWAY.save(dsInputData);

        // check whether an Event by the name "Sample Event" was created for day 0 i.e Sunday
        assertTrue(DATA_ACCESS.getDays().get(0).getEvents().containsKey("Sample Event"));
        assertEquals(
                dsInputData.getTitle(),
                DATA_ACCESS.getDays().get(0).getEvents().get("Sample Event").getTitle()
        );
    }
}