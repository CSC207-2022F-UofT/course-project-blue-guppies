package delete_event_use_case;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeleteEventPresenterTest {
    private final static DeleteEventOutputData SUCCESS = new DeleteEventOutputData(
            5, "Event");

    @Test
    public void testPrepareSuccessView() {
        DeleteEventOutputBoundary outputBoundary = new DeleteEventPresenter();
        DeleteEventOutputData response = outputBoundary.prepareSuccessView(SUCCESS);

        assertTrue(response.getSuccess());
        assertEquals(5, response.getDayIndex());
        assertEquals("Event", response.getLabel());
    }

    @Test
    public void testPrepareFailView() {
        DeleteEventOutputBoundary outputBoundary = new DeleteEventPresenter();
        DeleteEventOutputData response = outputBoundary.prepareFailureView(SUCCESS, "ERROR: Event not found within database.");

        assertFalse(response.getSuccess());
        assertEquals(5, response.getDayIndex());
        assertEquals("Event", response.getLabel());
    }
}