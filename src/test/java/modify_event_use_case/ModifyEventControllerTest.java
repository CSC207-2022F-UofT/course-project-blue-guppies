package modify_event_use_case;

import data_access.WeekDataAccess;
import entities.Day;
import entities.Event;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ModifyEventController test cases.
 * @author Daniel Livshits
 */
class ModifyEventControllerTest {
    final ModifyEventDataAccess sampleDataAccess = new ModifyEventDataAccess();
    final ModifyEventPresenter samplePresenter = new ModifyEventPresenter();
    final ModifyEventInteractor sampleInteractor = new ModifyEventInteractor(samplePresenter, sampleDataAccess);
    final ModifyEventController sampleController = new ModifyEventController(sampleInteractor);

    @Test
    void testModify() {
        ModifyEventOutputData output = sampleController.modify("MAT237", 1, "Mat237",
                "09:01", "09:59");
        assertEquals("MAT237", output.getTitle());
        assertEquals("Mat237", output.getNewTitle());
        assertEquals(1, output.getDayIndex());
        assertEquals(LocalTime.parse("09:01:00"), output.getNewStartTime());
        assertEquals(LocalTime.parse("09:59:00"), output.getNewEndTime());
        assertTrue(output.getSuccessfullyModified());
        assertNull(output.getFailureMessage());
    }

    @Test
    void testModifyTitleConflict(){
        Event originalEvent = WeekDataAccess.getDays().get(2).getEvents().get("Mat237");
        ModifyEventOutputData output = sampleController.modify("Mat237", 2, "Sta247",
                "09:00", "09:59");
        assertFalse(output.getSuccessfullyModified());
        String failMessage = "The title Sta247 was already used for another event on Tuesday.";
        assertEquals(failMessage, output.getFailureMessage());
        assertFalse(output.getSuccessfullyModified());
        Event currentEvent = WeekDataAccess.getDays().get(2).getEvents().get("Mat237");
        assertEquals(originalEvent, currentEvent);
    }

    @Test
    void testModifyTimeConflict(){
        Event originalEvent = WeekDataAccess.getDays().get(2).getEvents().get("Mat237");
        ModifyEventOutputData output = sampleController.modify("Mat237", 2, "Mat237",
                "14:30", "15:00");
        assertFalse(output.getSuccessfullyModified());
        String failMessage = "The new times for the event Mat237 conflict with another event on Tuesday.";
        assertEquals(failMessage, output.getFailureMessage());
        assertFalse(output.getSuccessfullyModified());
        Event currentEvent = WeekDataAccess.getDays().get(2).getEvents().get("Mat237");
        assertEquals(originalEvent, currentEvent);
    }

    @BeforeEach
    void setUp() {
        ArrayList<Day> days = new ArrayList<>();
        Day emptyDay = new Day(new HashMap<>(), new HashMap<>());
        days.add(emptyDay);
        Event math1 = new Event("MAT237", LocalTime.parse("09:00"), LocalTime.parse("10:00"));
        Event math = new Event("Mat237", LocalTime.parse("09:00"), LocalTime.parse("10:00"));
        Event stats = new Event("Sta247", LocalTime.parse("14:00"), LocalTime.parse("16:00"));
        Event theory = new Event("Csc236", LocalTime.parse("12:00"), LocalTime.parse("13:00"));
        HashMap<String, Event> events1 = new HashMap<>();
        HashMap<String, Event> events2 = new HashMap<>();
        HashMap<String, Event> events3 = new HashMap<>();
        events1.put("MAT237", math1);
        events2.put("Mat237", math);
        events2.put("Sta247", stats);
        events3.put("Csc236", theory);
        Day sampleMonday = new Day(new HashMap<>(), events1);
        days.add(sampleMonday);
        Day sampleTuesday = new Day(new HashMap<>(), events2);
        days.add(sampleTuesday);
        Day sampleWednesday = new Day(new HashMap<>(), events3);
        days.add(sampleWednesday);
        Day sampleThursday = new Day(new HashMap<>(), events2);
        days.add(sampleThursday);
        Day sampleFriday = new Day(new HashMap<>(), events3);
        days.add(sampleFriday);
        days.add(emptyDay);
        ModifyEventDataAccess.setDays(days);
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
