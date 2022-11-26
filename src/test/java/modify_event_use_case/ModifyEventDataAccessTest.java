package modify_event_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ModifyEventDataAccessTest {
    ModifyEventDataAccess dataAccess = new ModifyEventDataAccess();

    @Test
    void testSave() {
        ModifyEventDsInputData inputData = new ModifyEventDsInputData(1, "MAT237", "Mat237",
                LocalTime.parse("09:00"), LocalTime.parse("10:00"));
        dataAccess.save(inputData);
        assertEquals("Mat237", dataAccess.getDays().get(1).getEvents().get("Mat237").getTitle());
        assertEquals(LocalTime.parse("09:00"), dataAccess.getDays().get(1).getEvents().get("Mat237").getStartTime());
        assertEquals(LocalTime.parse("10:00"), dataAccess.getDays().get(1).getEvents().get("Mat237").getEndTime());
    }

    @Test
    void testSaveWithNewTimes(){
        ModifyEventDsInputData inputData = new ModifyEventDsInputData(2, "Sta247", "Sta247 Lecture",
                LocalTime.parse("15:00"), LocalTime.parse("16:00"));
        dataAccess.save(inputData);
        assertEquals("Sta247 Lecture", dataAccess.getDays().get(2).getEvents().get("Sta247 Lecture").getTitle());
        assertEquals(LocalTime.parse("15:00"), dataAccess.getDays().get(2).getEvents().get("Sta247 Lecture").getStartTime());
        assertEquals(LocalTime.parse("16:00"), dataAccess.getDays().get(2).getEvents().get("Sta247 Lecture").getEndTime());
    }

    @Test
    void testSaveIdenticalEventsMaps(){
        ModifyEventDsInputData inputData = new ModifyEventDsInputData(2, "Mat237", "MAT237",
                                LocalTime.parse("09:00"), LocalTime.parse("10:00"));
        dataAccess.save(inputData);
        assertEquals("MAT237", dataAccess.getDays().get(2).getEvents().get("MAT237").getTitle());
        assertEquals(LocalTime.parse("09:00"), dataAccess.getDays().get(2).getEvents().get("MAT237").getStartTime());
        assertEquals(LocalTime.parse("10:00"), dataAccess.getDays().get(2).getEvents().get("MAT237").getEndTime());
        assertEquals("MAT237", dataAccess.getDays().get(4).getEvents().get("MAT237").getTitle());
        assertEquals(LocalTime.parse("09:00"), dataAccess.getDays().get(4).getEvents().get("MAT237").getStartTime());
        assertEquals(LocalTime.parse("10:00"), dataAccess.getDays().get(4).getEvents().get("MAT237").getEndTime());
    }

    @Test
    void testTitleExistsInDay() {
        assertTrue(dataAccess.titleExistsInDay(1, "MAT237"));
        assertTrue(dataAccess.titleExistsInDay(2, "Sta247"));
        assertFalse(dataAccess.titleExistsInDay(3, "Mat237"));
        assertFalse(dataAccess.titleExistsInDay(4, "Csc236"));
        assertFalse(dataAccess.titleExistsInDay(5, "Sta247"));
    }

    @Test
    void testTitleExistsInDayAfterSave(){
        ModifyEventDsInputData inputData = new ModifyEventDsInputData(1, "MAT237", "Mat237",
                LocalTime.parse("09:00"), LocalTime.parse("10:00"));
        dataAccess.save(inputData);
        assertTrue(dataAccess.titleExistsInDay(1, "Mat237"));
        assertFalse(dataAccess.titleExistsInDay(1, "MAT237"));
    }

    @Test
    void testIsTimeConflict() {
        assertFalse(dataAccess.isTimeConflict(1, "MAT237", LocalTime.parse("09:00"),
                LocalTime.parse("10:00")));
        assertTrue(dataAccess.isTimeConflict(1, "something else",
                LocalTime.parse("09:00"), LocalTime.parse("10:00")));
        assertTrue(dataAccess.isTimeConflict(2, "MAT237", LocalTime.parse("13:30"),
                LocalTime.parse("15:30")));
        assertTrue(dataAccess.isTimeConflict(2, "MAT257", LocalTime.parse("15:00"),
                LocalTime.parse("16:40")));
    }

    @BeforeEach
    void setUp() {
        // This could be replicated more cleanly with a file once file reading is implemented
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
