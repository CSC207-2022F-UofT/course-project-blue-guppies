package clear_all_use_case;

import static org.junit.jupiter.api.Assertions.*;

import entities.Day;
import org.junit.jupiter.api.Test;
import screens.ViewModel;
import screens.ViewModelBoundary;

import java.util.ArrayList;
import java.util.HashMap;

class ClearAllPresenterTest {

    static ViewModelBoundary VIEW_MODEL = getViewModel();

    private static ViewModel getViewModel() {
        ArrayList<Day> days = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            days.add(new Day(new HashMap<>(), new HashMap<>()));
        }
        return new ViewModel(days);
    }

    private final static ClearAllOutputData OUTPUT_DATA = new ClearAllOutputData();
    private final static ClearAllOutputBoundary OUTPUT_BOUNDARY = new ClearAllPresenter(VIEW_MODEL);

    @Test
    void testPrepareSuccessView() {
        ClearAllOutputData outputData = OUTPUT_BOUNDARY.prepareSuccessView(OUTPUT_DATA);

        assertTrue(outputData.getSuccess());
    }

}
