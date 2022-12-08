package modify_event_use_case;

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
 * ModifyEventDataAccess test cases.
 * @author Daniel Livshits
 */
class ModifyEventDataAccessTest {
    final ModifyEventDataAccess dataAccess = new ModifyEventDataAccess();

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
        catch(IOException e){
            return;
        }
    }
}
