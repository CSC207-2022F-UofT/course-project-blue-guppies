package modify_event_use_case;

import data_access.WeekDataAccess;
import entities.Day;
import entities.Event;
import entities.Task;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import screens.ViewModel;
import screens.ViewModelBoundary;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ModifyEventInteractor test cases.
 * @author Daniel Livshits
 */
class ModifyEventInteractorTest {
    static ViewModelBoundary VIEW_MODEL = getViewModel();
    final ModifyEventDataAccess sampleDataAccess = new ModifyEventDataAccess();
    final ModifyEventPresenter samplePresenter = new ModifyEventPresenter(VIEW_MODEL);
    final ModifyEventInteractor sampleInteractor = new ModifyEventInteractor(samplePresenter, sampleDataAccess);

    private static ViewModel getViewModel() {
        ArrayList<Day> days = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            days.add(new Day(new HashMap<>(), new HashMap<>()));
        }
        return new ViewModel(days);
    }

    @Test
    void testModify() {
        ModifyEventInputData inputData = new ModifyEventInputData("MAT237", 1, "Mat237",
                "09:00", "10:00");
        ModifyEventOutputData output = sampleInteractor.modify(inputData);
        assertEquals("MAT237", output.getTitle());
        assertEquals("Mat237", output.getNewTitle());
        assertEquals(1, output.getDayIndex());
        assertEquals(LocalTime.parse("09:00"), output.getNewStartTime());
        assertEquals(LocalTime.parse("10:00"), output.getNewEndTime());
        assertTrue(output.getSuccessfullyModified());
        assertNull(output.getFailureMessage());
        assertEquals("Feed dog", WeekDataAccess.getDays().get(3).getTasks().get("Feed dog").getTitle());
        assertFalse(WeekDataAccess.getDays().get(3).getTasks().get("Feed dog").getCompleted());
    }

    @Test
    void testModifyTitleConflict(){
        Event originalEvent = WeekDataAccess.getDays().get(2).getEvents().get("Mat237");
        String originalTitle = originalEvent.getTitle();
        LocalTime originalStart = originalEvent.getStartTime();
        LocalTime originalEnd = originalEvent.getEndTime();
        ModifyEventInputData inputData = new ModifyEventInputData("Mat237", 2, "Sta247",
                "09:00","10:00");
        ModifyEventOutputData output = sampleInteractor.modify(inputData);
        String failMessage = "The title Sta247 was already used for another event on Tuesday.";
        assertEquals(failMessage, output.getFailureMessage());
        assertFalse(output.getSuccessfullyModified());
        Event currentEvent = WeekDataAccess.getDays().get(2).getEvents().get("Mat237");
        assertEquals(originalTitle, currentEvent.getTitle());
        assertEquals(originalStart, currentEvent.getStartTime());
        assertEquals(originalEnd, currentEvent.getEndTime());
    }

    @Test
    void testModifyTimeConflict(){
        Event originalEvent = WeekDataAccess.getDays().get(2).getEvents().get("Mat237");
        String originalTitle = originalEvent.getTitle();
        LocalTime originalStart = originalEvent.getStartTime();
        LocalTime originalEnd = originalEvent.getEndTime();
        ModifyEventInputData inputData = new ModifyEventInputData("Mat237", 2, "Mat247",
                "14:30", "15:00");
        ModifyEventOutputData output = sampleInteractor.modify(inputData);
        String failMessage = "The new times for the event Mat237 conflict with another event on Tuesday.";
        assertEquals(failMessage, output.getFailureMessage());
        assertFalse(output.getSuccessfullyModified());
        Event currentEvent = WeekDataAccess.getDays().get(2).getEvents().get("Mat237");
        assertEquals(originalTitle, currentEvent.getTitle());
        assertEquals(originalStart, currentEvent.getStartTime());
        assertEquals(originalEnd, currentEvent.getEndTime());
    }

    @Test
    void testModifyInvalidTimes(){
        Event originalEvent = WeekDataAccess.getDays().get(2).getEvents().get("Mat237");
        String originalTitle = originalEvent.getTitle();
        LocalTime originalStart = originalEvent.getStartTime();
        LocalTime originalEnd = originalEvent.getEndTime();
        ModifyEventInputData faultyData = new ModifyEventInputData("Mat237", 4, "TL;DR room",
                "bad", "times");
        ModifyEventOutputData output = sampleInteractor.modify(faultyData);
        String failMessage = "The start and end times are not valid times!";
        assertEquals(failMessage, output.getFailureMessage());
        assertFalse(output.getSuccessfullyModified());
        Event currentEvent = WeekDataAccess.getDays().get(2).getEvents().get("Mat237");
        assertEquals(originalTitle, currentEvent.getTitle());
        assertEquals(originalStart, currentEvent.getStartTime());
        assertEquals(originalEnd, currentEvent.getEndTime());
    }

    @Test
    void testModifyTimesOutOfOrder(){
        Event originalEvent = WeekDataAccess.getDays().get(2).getEvents().get("Mat237");
        String originalTitle = originalEvent.getTitle();
        LocalTime originalStart = originalEvent.getStartTime();
        LocalTime originalEnd = originalEvent.getEndTime();
        ModifyEventInputData faultyData = new ModifyEventInputData("Mat237", 4, "Time turner",
                "04:00", "03:00");
        ModifyEventOutputData output = sampleInteractor.modify(faultyData);
        String failMessage = "The new start time is not before the new end time!";
        assertEquals(failMessage, output.getFailureMessage());
        assertFalse(output.getSuccessfullyModified());
        Event currentEvent = WeekDataAccess.getDays().get(2).getEvents().get("Mat237");
        assertEquals(originalTitle, currentEvent.getTitle());
        assertEquals(originalStart, currentEvent.getStartTime());
        assertEquals(originalEnd, currentEvent.getEndTime());
    }

    @Test
    void testModifyOriginalTaskNotInDay(){
        Event originalEvent = WeekDataAccess.getDays().get(2).getEvents().get("Mat237");
        String originalTitle = originalEvent.getTitle();
        LocalTime originalStart = originalEvent.getStartTime();
        LocalTime originalEnd = originalEvent.getEndTime();
        ModifyEventInputData faultyData = new ModifyEventInputData("Sleep", 4, "Time turner",
                "04:00", "03:00");
        ModifyEventOutputData output = sampleInteractor.modify(faultyData);
        String failMessage = "There is no event called Sleep on Thursday!";
        assertEquals(failMessage, output.getFailureMessage());
        assertFalse(output.getSuccessfullyModified());
        Event currentEvent = WeekDataAccess.getDays().get(2).getEvents().get("Mat237");
        assertEquals(originalTitle, currentEvent.getTitle());
        assertEquals(originalStart, currentEvent.getStartTime());
        assertEquals(originalEnd, currentEvent.getEndTime());
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
        Task winterBreak = new Task("Feed dog");
        HashMap<String, Event> events1 = new HashMap<>();
        HashMap<String, Event> events2 = new HashMap<>();
        HashMap<String, Event> events3 = new HashMap<>();
        HashMap<String, Task> tasks = new HashMap<>();
        events1.put("MAT237", math1);
        events2.put("Mat237", math);
        events2.put("Sta247", stats);
        events3.put("Csc236", theory);
        tasks.put("Feed dog", winterBreak);
        Day sampleMonday = new Day(new HashMap<>(), events1);
        days.add(sampleMonday);
        Day sampleTuesday = new Day(new HashMap<>(), events2);
        days.add(sampleTuesday);
        Day sampleWednesday = new Day(tasks, events3);
        days.add(sampleWednesday);
        Day sampleThursday = new Day(new HashMap<>(), events2);
        days.add(sampleThursday);
        Day sampleFriday = new Day(tasks, events3);
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
