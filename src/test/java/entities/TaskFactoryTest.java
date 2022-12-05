package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for the TaskFactory class.
 * @author Fardin Faruk
 */
public class TaskFactoryTest {

    @Test
    void testCreateTask() {
        TaskFactory factory = new TaskFactory();
        Task study = factory.createTask("Study for Exam");
        assertEquals("Study for Exam", study.getTitle());
        assertFalse(study.getCompleted());
    }
}
