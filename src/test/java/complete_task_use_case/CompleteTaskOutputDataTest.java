package complete_task_use_case;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Task Completion Output Data Test Cases.
 * @author Fardin Faruk
 */
public class CompleteTaskOutputDataTest {
    @Test
    public void testGetTitle(){
        CompleteTaskOutputData outputData = new CompleteTaskOutputData("Exam season", 0);
        assertEquals(outputData.getTitle(), "Exam season");
    }

    @Test
    public void testGetDayIndex(){
        CompleteTaskOutputData outputData = new CompleteTaskOutputData("eating", 1);
        assertEquals(outputData.getDayIndex(), 1);
    }

    @Test
    public void testIsSuccessfullyCreated(){
        CompleteTaskOutputData outputData = new CompleteTaskOutputData("Feeding", 0);
        outputData.setSuccessfullyCreated(true);
        assertTrue(outputData.isSuccessfullyCompleted());
    }

    @Test
    public void testGetErrorMessage(){
        CompleteTaskOutputData outputData = new CompleteTaskOutputData("Noodle", 1);
        assertEquals("",
                outputData.getErrorMessage());
    }

    @Test
    public void testSetErrorMessage(){
        CompleteTaskOutputData outputData = new CompleteTaskOutputData("orange Prep", 1);
        outputData.setErrorMessage("There already exists a task with name 'Study' on Sunday");
        assertEquals("There already exists a task with name 'Study' on Sunday",
                outputData.getErrorMessage());
    }

}
