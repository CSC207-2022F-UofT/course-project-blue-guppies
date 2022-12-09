package modify_event_use_case;

import entities.Day;
import org.junit.jupiter.api.Test;
import screens.ViewModel;
import screens.ViewModelBoundary;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ModifyEventPresenter test cases.
 * @author Daniel Livshits
 */
class ModifyEventPresenterTest {
    private final static ViewModelBoundary VIEW_MODEL = getViewModel();
    final ModifyEventPresenter samplePresenter = new ModifyEventPresenter(VIEW_MODEL);
    final ModifyEventOutputData outputData =  new ModifyEventOutputData("Team Mtg", 6, "Blue Guppies Meeting",
            LocalTime.parse("15:00"), LocalTime.parse("16:00"));

    private static ViewModel getViewModel() {
        ArrayList<Day> days = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            days.add(new Day(new HashMap<>(), new HashMap<>()));
        }
        return new ViewModel(days);
    }

    @Test
    void testPrepareSuccessView() {
        ModifyEventOutputData outputAfter = samplePresenter.prepareSuccessView(outputData);
        assertEquals(outputAfter, outputData);
    }

    @Test
    void testPrepareFailView() {
    ModifyEventOutputData outputAfter = samplePresenter.prepareFailView(outputData, "more testing is required!");
        assertEquals("Team Mtg", outputAfter.getTitle());
        assertEquals(6, outputAfter.getDayIndex());
        assertEquals("Blue Guppies Meeting", outputAfter.getNewTitle());
        assertEquals(LocalTime.parse("15:00:00"), outputAfter.getNewStartTime());
        assertEquals(LocalTime.parse("16:00:00"), outputAfter.getNewEndTime());
        assertFalse(outputAfter.getSuccessfullyModified());
        assertEquals("more testing is required!", outputAfter.getFailureMessage());
    }
}
