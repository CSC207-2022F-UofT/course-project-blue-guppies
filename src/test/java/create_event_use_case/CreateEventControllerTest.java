package create_event_use_case;

import entities.EventFactory;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Create Event Controller Test Cases.
 * @author Raghav Arora
 */
class CreateEventControllerTest {
    private final static CreateEventOutputBoundary outputBoundary = new CreateEventPresenter();
    private final static CreateEventDsGateway dsGateway = new CreateEventDataAccess();
    private final static EventFactory eventFactory = new EventFactory();
    private final static String TITLE = "Sample Event";
    private final static String START_TIME = "09:00";
    private final static String END_TIME = "10:00";
    private final static String DAY = "Sunday";

    @Test
    void testCreateEvent() {
        CreateEventInputBoundary inputBoundary = new CreateEventInteractor(
                dsGateway, outputBoundary, eventFactory
        );
        CreateEventController controller = new CreateEventController(inputBoundary);
        CreateEventOutputData outputData = controller.createEvent(
                TITLE, START_TIME, END_TIME, DAY
        );
        assertEquals("Sample Event", outputData.getTitle());
        assertEquals(LocalTime.parse("09:00"), outputData.getStartTime());
        assertEquals(LocalTime.parse("10:00"), outputData.getEndTime());
        assertEquals(0, outputData.getDayIndex());
        assertTrue(outputData.isSuccessfullyCreated());

        // check if an event by the name of "Sample Event" exists for day 0 i.e. Sunday
        assertTrue(dsGateway.eventExistsByTitle(TITLE, outputData.getDayIndex()));
    }
}
