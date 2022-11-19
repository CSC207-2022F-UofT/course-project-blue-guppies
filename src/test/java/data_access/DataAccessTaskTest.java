package data_access;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataAccessTaskTest {
    @Test
    void testGetTitle() {
        DataAccessTask exam = new DataAccessTask("Stats Exam");
        assertEquals("Stats Exam", exam.getTitle());
    }

    @Test
    void testSetTitle() {
        DataAccessTask networking = new DataAccessTask("Connect with Employer");
        networking.setTitle("Connect with Microsoft Employer");
        assertEquals("Connect with Microsoft Employer", networking.getTitle());
    }

    @Test
    void testGetCompleted() {
        DataAccessTask resume = new DataAccessTask("Update Resume");
        assertFalse(resume.getCompleted());
    }

    @Test
    void testSetCompleted() {
        DataAccessTask study = new DataAccessTask("study a lot");
        study.setCompleted(true);
        assertTrue(study.getCompleted());
    }

    @Test
    void testToString() {
        DataAccessTask sleep = new DataAccessTask("get some sleep");
        assertEquals("get some sleep", sleep.toString());
    }
}