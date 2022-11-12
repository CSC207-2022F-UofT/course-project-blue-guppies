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
    void testToString() {
        Task resume = new Task("Update Resume");
        assertEquals("Update Resume", resume.toString());
    }

}
