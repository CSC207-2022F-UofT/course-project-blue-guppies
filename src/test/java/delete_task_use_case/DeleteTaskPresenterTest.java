package delete_task_use_case;

import entities.Day;
import org.junit.jupiter.api.Test;
import screens.ViewModel;
import screens.ViewModelBoundary;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class DeleteTaskPresenterTest {
    static ViewModelBoundary VIEW_MODEL = getViewModel();
    private final static DeleteTaskOutputData OUTPUT_DATA = new DeleteTaskOutputData(
            5, "Task");
    private final static DeleteTaskOutputBoundary OUTPUT_BOUNDARY = new DeleteTaskPresenter(VIEW_MODEL);

    private static ViewModel getViewModel() {
        ArrayList<Day> days = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            days.add(new Day(new HashMap<>(), new HashMap<>()));
        }
        return new ViewModel(days);
    }

    @Test
    void testPrepareSuccessView() {
        DeleteTaskOutputData response = OUTPUT_BOUNDARY.prepareSuccessView(OUTPUT_DATA);

        assertTrue(response.isSuccess());
        assertEquals(5, response.getDayIndex());
        assertEquals("Task", response.getTaskTitle());
        assertNull(response.getErrorMessage());
    }

    @Test
    void testPrepareFailView(){
        DeleteTaskOutputData response = OUTPUT_BOUNDARY.prepareFailView(OUTPUT_DATA, "Error");

        assertFalse(response.isSuccess());
        assertEquals(5, response.getDayIndex());
        assertEquals("Task", response.getTaskTitle());
        assertEquals("Error", response.getErrorMessage());

    }
}
