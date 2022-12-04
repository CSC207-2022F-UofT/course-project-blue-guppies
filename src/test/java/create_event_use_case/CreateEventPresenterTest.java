package create_event_use_case;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Create Event Presenter Test Cases.
 * @author Raghav Arora
 */
class CreateEventPresenterTest {
    private final static CreateEventOutputBoundary outputBoundary = new CreateEventPresenter();
    private final static CreateEventOutputData outputData = new CreateEventOutputData(
            "Event", LocalTime.parse("09:00"), LocalTime.parse("10:00"), 0
    );

    @Test
    void testPrepareSuccessView() {
        CreateEventOutputData result = outputBoundary.prepareSuccessView(outputData);
        assertEquals("Event", result.getTitle());
        assertEquals(LocalTime.parse("09:00"), result.getStartTime());
        assertEquals(LocalTime.parse("10:00"), result.getEndTime());
        assertTrue(result.isSuccess());
        assertEquals("", result.getErrorMessage());
    }

    @Test
    void testPrepareFailView() {
        CreateEventOutputData result = outputBoundary.prepareFailView(outputData, "Error");
        assertEquals("Event", result.getTitle());
        assertEquals(LocalTime.parse("09:00"), result.getStartTime());
        assertEquals(LocalTime.parse("10:00"), result.getEndTime());
        assertFalse(result.isSuccess());
        assertEquals("Error", result.getErrorMessage());
    }
}