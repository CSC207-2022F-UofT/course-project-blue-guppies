package create_event_use_case;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Create Event Presenter Test Cases.
 * @author Raghav Arora, Anna Myllyniemi
 */
class CreateEventPresenterTest {
    private final static CreateEventOutputBoundary OUTPUT_BOUNDARY = new CreateEventPresenter();
    private final static CreateEventOutputData OUTPUT_DATA = new CreateEventOutputData(
            "Event", LocalTime.parse("09:00"), LocalTime.parse("10:00"), 0
    );

    @Test
    void testPrepareSuccessView() {
        CreateEventOutputData result = OUTPUT_BOUNDARY.prepareSuccessView(OUTPUT_DATA);
        assertEquals("Event", result.getTitle());
        assertEquals(LocalTime.parse("09:00"), result.getStartTime());
        assertEquals(LocalTime.parse("10:00"), result.getEndTime());
        assertTrue(result.isSuccess());
        assertEquals("", result.getErrorMessage());
    }

    @Test
    void testPrepareFailViewDefault() {
        CreateEventOutputData result = OUTPUT_BOUNDARY.prepareFailView(new CreateEventOutputData(), "Error");
        assertFalse(result.isSuccess());
        assertEquals("Error", result.getErrorMessage());
    }

    @Test
    void testPrepareFailView() {
        CreateEventOutputData result = OUTPUT_BOUNDARY.prepareFailView(OUTPUT_DATA, "Error");
        assertEquals("Event", result.getTitle());
        assertEquals(LocalTime.parse("09:00"), result.getStartTime());
        assertEquals(LocalTime.parse("10:00"), result.getEndTime());
        assertFalse(result.isSuccess());
        assertEquals("Error", result.getErrorMessage());
        assertEquals(0, result.getDayIndex());
    }


    // add test for view model
}