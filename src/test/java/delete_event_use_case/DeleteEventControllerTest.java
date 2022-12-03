package delete_event_use_case;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeleteEventControllerTest {
    private final static DeleteEventPresenter outputBoundary = new DeleteEventPresenter();
    private final static DeleteEventDataAccess dsGateway = new DeleteEventDataAccess();
    private final static int dayIndex = 3;
    private final static String eventTitle = "Event";

    @Test
    public void testDeleteEvent() {
        DeleteEventInteractor inputBoundary = new DeleteEventInteractor(outputBoundary, dsGateway);
        DeleteEventController controller = new DeleteEventController(inputBoundary);
        DeleteEventOutputData outputData = controller.delete(eventTitle, dayIndex);

        assertFalse(dsGateway.getDays().get(1).getEvents().containsKey("Event"));
        assertEquals(3, outputData.getDayIndex());
        assertEquals("Event", outputData.getLabel());
    }
}
