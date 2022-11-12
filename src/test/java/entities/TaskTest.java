package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    void testGetTitle() {
        Task exam = new Task("Math Exam");
        assertEquals("Math Exam", exam.getTitle());
    }

    @Test
    void testSetTitle() {
        Task networking = new Task("Connect with Employer");
        networking.setTitle("Connect with Google Employer");
        assertEquals("Connect with Google Employer", networking.getTitle());
    }

    @Test
    void testGetCompleted() {
        Task sleep = new Task("get some sleep");
        assertFalse(sleep.getCompleted());
    }

    @Test
    void testSetCompleted() {
        Task study = new Task("study a lot");
        study.setCompleted(true);
        assertTrue(study.getCompleted());
    }

    @Test
    void testToString() {
        Task resume = new Task("Update Resume");
        assertEquals("Update Resume", resume.toString());
    }

}
