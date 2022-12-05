package create_event_use_case;

import entities.Day;
import entities.Event;
import entities.EventFactory;
import java.time.LocalTime;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Create Event Controller Test Cases.
 * @author Raghav Arora
 */
class CreateEventControllerTest {
    private final static CreateEventOutputBoundary OUTPUT_BOUNDARY = new CreateEventPresenter();
    private final static CreateEventDataAccess DATA_ACCESS = new CreateEventDataAccess();
    private final static CreateEventDsGateway DS_GATEWAY = DATA_ACCESS;
    private final static EventFactory EVENT_FACTORY = new EventFactory();
    private final static String TITLE = "Sample Event";
    private final static String START_TIME = "09:00";
    private final static String END_TIME = "10:00";
    private final static String DAY = "Sunday";

    @Test
    void testCreate() {
        HashMap<String, Event> events = new HashMap<>();
        Day referenceDay = DATA_ACCESS.getDays().get(0);
        referenceDay.setEvents(events);
        DATA_ACCESS.getDays().set(0, referenceDay);

        CreateEventInputBoundary inputBoundary = new CreateEventInteractor(
                DS_GATEWAY, OUTPUT_BOUNDARY, EVENT_FACTORY
        );
        CreateEventController controller = new CreateEventController(inputBoundary);
        CreateEventOutputData outputData = controller.create(
                DAY, TITLE, START_TIME, END_TIME
        );
        assertEquals("Sample Event", outputData.getTitle());
        assertEquals(LocalTime.parse("09:00"), outputData.getStartTime());
        assertEquals(LocalTime.parse("10:00"), outputData.getEndTime());
        assertEquals(0, outputData.getDayIndex());
        assertTrue(outputData.isSuccess());

        // check if an event by the name of "Sample Event" exists for day 0 i.e. Sunday
        assertTrue(DS_GATEWAY.eventExistsByTitle(TITLE, outputData.getDayIndex()));
    }
}
