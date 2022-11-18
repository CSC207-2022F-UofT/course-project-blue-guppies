package data_access;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class DataAccessEventTest {
    @Test
    void testGetTitle() {
        DataAccessEvent mathEvent = new DataAccessEvent("mat237", LocalTime.parse("12:30"), LocalTime.parse("01:53:20"));
        assertEquals("mat237", mathEvent.getTitle());
    }

    @Test
    void testGetEndTime() {
        DataAccessEvent studyEvent = new DataAccessEvent("study", LocalTime.parse("00:00:04"), LocalTime.parse("01:00"));
        assertEquals(LocalTime.parse("01:00"), studyEvent.getEndTime());
    }

    @Test
    void testGetStartTime() {
        DataAccessEvent studyEvent = new DataAccessEvent("study", LocalTime.parse("00:01:10"), LocalTime.parse("01:00"));
        assertEquals(LocalTime.parse("00:01:10"), studyEvent.getStartTime());
    }

    @Test
    void testSetTitle() {
        DataAccessEvent sleepEvent = new DataAccessEvent("zzz", LocalTime.parse("23:00"), LocalTime.parse("23:58:20"));
        sleepEvent.setTitle("Sleep zzz");
        assertEquals("Sleep zzz", sleepEvent.getTitle());

    }

    @Test
    void testSetStartTime() {
        DataAccessEvent meetingEvent = new DataAccessEvent("Very important meeting", LocalTime.parse("01:23:20"),
                LocalTime.parse("13:53:20"));
        meetingEvent.setStartTime(LocalTime.parse("00:05:00"));
        assertEquals(LocalTime.parse("00:05:00"), meetingEvent.getStartTime());
    }

    @Test
    void testSetEndTime() {
        DataAccessEvent schoolEvent = new DataAccessEvent("School", LocalTime.parse("00:08:20"), LocalTime.parse("08:20"));
        schoolEvent.setEndTime(LocalTime.parse("05:33:20"));
        assertEquals(LocalTime.parse("05:33:20"), schoolEvent.getEndTime());
    }

    @Test
    void testToString() {
        DataAccessEvent mathEvent = new DataAccessEvent("mat157", LocalTime.parse("00:00:45"), LocalTime.parse("00:08:20"));
        assertEquals("mat157", mathEvent.toString());
    }
}