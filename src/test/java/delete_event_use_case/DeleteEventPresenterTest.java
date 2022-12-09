package delete_event_use_case;

import entities.Day;
import org.junit.jupiter.api.Test;
import screens.ViewModel;
import screens.ViewModelBoundary;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class DeleteEventPresenterTest {
    private final static DeleteEventOutputData SUCCESS = new DeleteEventOutputData(
            5, "Event");
    private final static ViewModelBoundary VIEW_MODEL = getViewModel();

    private static ViewModel getViewModel() {
        ArrayList<Day> days = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            days.add(new Day(new HashMap<>(), new HashMap<>()));
        }
        return new ViewModel(days);
    }

    @Test
    public void testPrepareSuccessView() {
        DeleteEventOutputBoundary outputBoundary = new DeleteEventPresenter(VIEW_MODEL);
        DeleteEventOutputData response = outputBoundary.prepareSuccessView(SUCCESS);

        assertTrue(response.getSuccess());
        assertEquals(5, response.getDayIndex());
        assertEquals("Event", response.getLabel());
    }

    @Test
    public void testPrepareFailView() {
        DeleteEventOutputBoundary outputBoundary = new DeleteEventPresenter(VIEW_MODEL);
        DeleteEventOutputData response = outputBoundary.prepareFailureView(SUCCESS, "ERROR: Event not found within database.");

        assertFalse(response.getSuccess());
        assertEquals(5, response.getDayIndex());
        assertEquals("Event", response.getLabel());
    }
}
