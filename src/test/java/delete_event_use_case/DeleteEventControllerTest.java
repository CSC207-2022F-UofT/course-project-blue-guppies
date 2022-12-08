package delete_event_use_case;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.*;

public class DeleteEventControllerTest {
    private final static DeleteEventPresenter OUTPUT_BOUNDARY = new DeleteEventPresenter();
    private final static DeleteEventDataAccess DS_GATEWAY = new DeleteEventDataAccess();
    private final static int DAY_INDEX = 3;
    private final static String EVENT_TITLE = "Event";

    @Test
    public void testDeleteEvent() {
        DeleteEventInteractor inputBoundary = new DeleteEventInteractor(OUTPUT_BOUNDARY, DS_GATEWAY);
        DeleteEventController controller = new DeleteEventController(inputBoundary);
        DeleteEventOutputData outputData = controller.delete(EVENT_TITLE, DAY_INDEX);

        assertFalse(DS_GATEWAY.getDays().get(1).getEvents().containsKey("Event"));
        assertEquals(3, outputData.getDayIndex());
        assertEquals("Event", outputData.getLabel());
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
