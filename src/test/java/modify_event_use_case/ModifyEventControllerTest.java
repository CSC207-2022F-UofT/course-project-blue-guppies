package modify_event_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ModifyEventControllerTest {
    ModifyEventDataAccess sampleDataAccess = new ModifyEventDataAccess();
    ModifyEventPresenter samplePresenter = new ModifyEventPresenter();
    ModifyEventInteractor sampleInteractor = new ModifyEventInteractor(samplePresenter, sampleDataAccess);
    ModifyEventController sampleController = new ModifyEventController(sampleInteractor);

    @Test
    void testModify() {
        ModifyEventOutputData output = sampleController.modify("MAT237", 1, "Mat237",
                LocalTime.parse("09:01"), LocalTime.parse("09:59:59"));
        assertEquals("MAT237", output.getTitle());
        assertEquals("Mat237", output.getNewTitle());
        assertEquals(1, output.getDayIndex());
        assertEquals(LocalTime.parse("09:01:00"), output.getNewStartTime());
        assertEquals(LocalTime.parse("09:59:59"), output.getNewEndTime());
        assertTrue(output.getSuccessfullyModified());
        assertNull(output.getFailureMessage());
    }

    @Test
    void testModifyTitleConflict(){
        DataAccessEvent originalEvent = sampleDataAccess.getDays().get(2).getEvents().get("Mat237");
        ModifyEventOutputData output = sampleController.modify("Mat237", 2, "Sta247",
                LocalTime.parse("09:00"), LocalTime.parse("09:59:59"));
        assertFalse(output.getSuccessfullyModified());
        String failMessage = "The title Sta247 was already used for another event in that day.";
        assertEquals(failMessage, output.getFailureMessage());
        assertFalse(output.getSuccessfullyModified());
        DataAccessEvent currentEvent = sampleDataAccess.getDays().get(2).getEvents().get("Mat237");
        assertEquals(originalEvent, currentEvent);
    }

    @Test
    void testModifyTimeConflict(){
        DataAccessEvent originalEvent = sampleDataAccess.getDays().get(2).getEvents().get("Mat237");
        ModifyEventOutputData output = sampleController.modify("Mat237", 2, "Mat237",
                LocalTime.parse("14:30"), LocalTime.parse("15:00"));
        assertFalse(output.getSuccessfullyModified());
        String failMessage = "There was a time conflict for the new times for this event.";
        assertEquals(failMessage, output.getFailureMessage());
        assertFalse(output.getSuccessfullyModified());
        DataAccessEvent currentEvent = sampleDataAccess.getDays().get(2).getEvents().get("Mat237");
        assertEquals(originalEvent, currentEvent);
    }

    @BeforeEach
    void setUp() {
        ArrayList<DataAccessDay> days = new ArrayList<>();
        DataAccessDay emptyDay = new DataAccessDay(new HashMap<>(), new HashMap<>());
        days.add(emptyDay);
        DataAccessEvent math1 = new DataAccessEvent("MAT237", LocalTime.parse("09:00"), LocalTime.parse("10:00"));
        DataAccessEvent math = new DataAccessEvent("Mat237", LocalTime.parse("09:00"), LocalTime.parse("10:00"));
        DataAccessEvent stats = new DataAccessEvent("Sta247", LocalTime.parse("14:00"), LocalTime.parse("16:00"));
        DataAccessEvent theory = new DataAccessEvent("Csc236", LocalTime.parse("12:00"), LocalTime.parse("13:00"));
        HashMap<String, DataAccessEvent> events1 = new HashMap<>();
        HashMap<String, DataAccessEvent> events2 = new HashMap<>();
        HashMap<String, DataAccessEvent> events3 = new HashMap<>();
        events1.put("MAT237", math1);
        events2.put("Mat237", math);
        events2.put("Sta247", stats);
        events3.put("Csc236", theory);
        DataAccessDay sampleMonday = new DataAccessDay(new HashMap<>(), events1);
        days.add(sampleMonday);
        DataAccessDay sampleTuesday = new DataAccessDay(new HashMap<>(), events2);
        days.add(sampleTuesday);
        DataAccessDay sampleWednesday = new DataAccessDay(new HashMap<>(), events3);
        days.add(sampleWednesday);
        DataAccessDay sampleThursday = new DataAccessDay(new HashMap<>(), events2);
        days.add(sampleThursday);
        DataAccessDay sampleFriday = new DataAccessDay(new HashMap<>(), events3);
        days.add(sampleFriday);
        days.add(emptyDay);
        ModifyEventDataAccess.setDays(days);
    }
}
