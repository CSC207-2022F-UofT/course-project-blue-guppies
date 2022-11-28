package create_task_use_case;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateTaskOutputDataTest {
    @Test
    public void testGetTitle(){
        CreateTaskOutputData outputData = new CreateTaskOutputData("Feed Kittens", true, 0,
                "");
        assertEquals(outputData.getTitle(), "Feed Kittens");
    }
    @Test
    public void testGetCompleted(){
        CreateTaskOutputData outputData = new CreateTaskOutputData("John Smith", true, 3,
                "");
        assertTrue(outputData.getCompleted());
    }
    @Test
    public void testGetDayIndex(){
        CreateTaskOutputData outputData = new CreateTaskOutputData("Meal Prep", true, 1,
                "");
        assertEquals(outputData.getDayIndex(), 1);
    }
    @Test
    public void testGet(){
        CreateTaskOutputData outputData = new CreateTaskOutputData("Meal Prep", true, 1,
                "There already exists a task with name 'Study' on Monday");
        assertEquals("There already exists a task with name 'Study' on Monday",
                outputData.getErrorMessage());
    }
}