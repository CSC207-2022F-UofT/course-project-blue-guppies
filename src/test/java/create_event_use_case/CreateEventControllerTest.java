package create_event_use_case;

import data_access.WeekDataAccess;
import entities.Day;
import entities.Event;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import strategies.DayToIndexConverter;
import strategies.SaturdayAssumingConverter;
import screens.ViewModel;
import screens.ViewModelBoundary;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Create Event Controller Test Cases.
 * @author Raghav Arora
 */
class CreateEventControllerTest {
    private final static ViewModelBoundary VIEW_MODEL = getViewModel();
    private final static CreateEventOutputBoundary OUTPUT_BOUNDARY = new CreateEventPresenter(VIEW_MODEL);
    private final static CreateEventDataAccess DATA_ACCESS = new CreateEventDataAccess();
    private final static CreateEventDsGateway DS_GATEWAY = DATA_ACCESS;
    private final static String TITLE = "Sample Event";
    private final static String START_TIME = "09:00";
    private final static String END_TIME = "10:00";
    private final static String DAY = "Sunday";

    private static ViewModel getViewModel() {
        ArrayList<Day> days = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            days.add(new Day(new HashMap<>(), new HashMap<>()));
        }
        return new ViewModel(days);
    }

    @Test
    void testCreate() {
        HashMap<String, Event> events = new HashMap<>();
        Day referenceDay = WeekDataAccess.getDays().get(0);
        referenceDay.setEvents(events);
        WeekDataAccess.getDays().set(0, referenceDay);

        CreateEventInputBoundary inputBoundary = new CreateEventInteractor(
                DS_GATEWAY, OUTPUT_BOUNDARY
        );
        DayToIndexConverter converter = new SaturdayAssumingConverter();
        CreateEventController controller = new CreateEventController(inputBoundary, converter);
        CreateEventOutputData outputData = controller.create(
                DAY, TITLE, START_TIME, END_TIME
        );
        assertEquals("Sample Event", outputData.getTitle());
        assertEquals(LocalTime.parse("09:00"), outputData.getStartTime());
        assertEquals(LocalTime.parse("10:00"), outputData.getEndTime());
        assertEquals(0, outputData.getDayIndex());
        assertTrue(outputData.isSuccess());

        // check if an event by the name of "Sample Event" exists for day 0 i.e. Sunday
        assertTrue(DS_GATEWAY.eventExistsByTitle(TITLE, outputData.getDayIndex()));
    }

    @AfterEach
    public void clearStorage(){
        try {
            PrintWriter pw = new PrintWriter("CleanCalendarStorage.txt"); //deleting the contents of the file
            pw.close();
        }
        catch(IOException ignored){
        }
    }
}
