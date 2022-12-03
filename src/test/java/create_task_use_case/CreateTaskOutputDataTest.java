package create_task_use_case;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreateTaskOutputDataTest {
    @Test
    public void testGetTitle(){
        CreateTaskOutputData outputData = new CreateTaskOutputData("Feed Kittens", 0,
                "");
        assertEquals(outputData.getTitle(), "Feed Kittens");
    }
    @Test
    public void testGetDayIndex(){
        CreateTaskOutputData outputData = new CreateTaskOutputData("Meal Prep", 1,
                "");
        assertEquals(outputData.getDayIndex(), 1);
    }
    @Test
    public void testIsSuccessfullyCreated(){
        CreateTaskOutputData outputData = new CreateTaskOutputData("Feed Dogs", 0,
                "");
        outputData.setSuccessfullyCreated(true);
        assertTrue(outputData.isSuccessfullyCreated());
    }
    @Test
    public void testGetErrorMessage(){
        CreateTaskOutputData outputData = new CreateTaskOutputData("Meal Prep", 1,
                "There already exists a task with name 'Study' on Monday");
        assertEquals("There already exists a task with name 'Study' on Monday",
                outputData.getErrorMessage());
    }
    @Test
    public void testSetErrorMessage(){
        CreateTaskOutputData outputData = new CreateTaskOutputData("Meal Prep", 1,
                "There already exists a task with name 'Study' on Monday");
        outputData.setErrorMessage("There already exists a task with name 'Study' on Sunday");
        assertEquals("There already exists a task with name 'Study' on Sunday",
                outputData.getErrorMessage());
    }
}
