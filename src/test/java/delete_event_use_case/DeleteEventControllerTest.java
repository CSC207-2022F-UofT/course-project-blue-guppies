package delete_event_use_case;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Unit Testing for DeleteEventController class
 * @author : Khizer Ahmad
 * @created: November 19th 2022
 * @since : 2022-11-21, Mon.
 **/
public class DeleteEventControllerTest {
    private final static DeleteEventPresenter outputBoundary = new DeleteEventPresenter();
    private final static DeleteEventDataAccess dsGateway = new DeleteEventDataAccess();
    private final static int dayIndex = 3;
    private final static String eventTitle = "Event";

    @Test
    public void testDeleteTask() {
        DeleteEventInteractor inputBoundary = new DeleteEventInteractor(outputBoundary, dsGateway);
        DeleteEventController controller = new DeleteEventController(inputBoundary);
        DeleteEventOutputData outputData = controller.delete(eventTitle, dayIndex);

        assertEquals(5, outputData.getDayIndex());
        assertEquals("Event", outputData.getLabel());
    }
}
