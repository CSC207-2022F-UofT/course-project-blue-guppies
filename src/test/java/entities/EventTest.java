package entities;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    @Test
    void testGetTitle() {
        Event mathEvent = new Event("math", LocalTime.parse("12:30"), LocalTime.parse("01:53:20"));
        assertEquals("math", mathEvent.getTitle());
    }

    @Test
    void testGetEndTime() {
        Event studyEvent = new Event("study", LocalTime.parse("00:00:04"), LocalTime.parse("01:00"));
        assertEquals(LocalTime.parse("01:00"), studyEvent.getEndTime());
    }

    @Test
    void testGetStartTime() {
        Event studyEvent = new Event("study", LocalTime.parse("00:01:10"), LocalTime.parse("01:00"));
        assertEquals(LocalTime.parse("00:01:10"), studyEvent.getStartTime());
    }

    @Test
    void testSetTitle() {
        Event sleepEvent = new Event("zzz", LocalTime.parse("23:00"), LocalTime.parse("23:58:20"));
        sleepEvent.setTitle("Sleep zzz");
        assertEquals("Sleep zzz", sleepEvent.getTitle());

    }

    @Test
    void testSetStartTime() {
        Event meetingEvent = new Event("Very important meeting", LocalTime.parse("01:23:20"),
                LocalTime.parse("13:53:20"));
        meetingEvent.setStartTime(LocalTime.parse("00:05:00"));
        assertEquals(LocalTime.parse("00:05:00"), meetingEvent.getStartTime());
    }

    @Test
    void testSetEndTime() {
        Event schoolEvent = new Event("School", LocalTime.parse("00:08:20"), LocalTime.parse("08:20"));
        schoolEvent.setEndTime(LocalTime.parse("05:33:20"));
        assertEquals(LocalTime.parse("05:33:20"), schoolEvent.getEndTime());
    }

    @Test
    void testToString() {
        Event mathEvent = new Event("math", LocalTime.parse("00:00:45"), LocalTime.parse("00:08:20"));
        assertEquals("math", mathEvent.toString());
    }
}