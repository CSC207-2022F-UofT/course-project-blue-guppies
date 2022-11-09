package entities;

import org.junit.jupiter.api.Test;
import java.sql.Time;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    @Test
    void getTitle() {
        Event mathEvent = new Event("math", new Time(45000000), new Time(500000000));
        assertEquals("math", mathEvent.getTitle());
    }

    @Test
    void getEndTime() {
        Event studyEvent = new Event("study", new Time(4000), new Time(3600000));
        assertEquals(3600000, studyEvent.getEndTime().getTime());
    }

    @Test
    void getStartTime() {
        Event studyEvent = new Event("study", new Time(70000), new Time(360000));
        assertEquals(70000, studyEvent.getStartTime().getTime());
    }

    @Test
    void setTitle() {
        Event sleepEvent = new Event("zzz", new Time(82800000), new Time(86300000));
        sleepEvent.setTitle("Sleep zzz");
        assertEquals("Sleep zzz", sleepEvent.getTitle());

    }

    @Test
    void setStartTime() {
        Event meetingEvent = new Event("Very important meeting", new Time(5000000), new Time(50000000));
        meetingEvent.setStartTime(new Time(300000));
        assertEquals(300000, meetingEvent.getStartTime().getTime());
    }

    @Test
    void setEndTime() {
        Event schoolEvent = new Event("School", new Time(500000), new Time(30000000));
        schoolEvent.setEndTime(new Time(20000000));
        assertEquals(20000000, schoolEvent.getEndTime().getTime());
    }

    @Test
    void stringRepresentation() {
        Event mathEvent = new Event("math", new Time(45000), new Time(500000));
        assertEquals("math", mathEvent.toString());
    }
}