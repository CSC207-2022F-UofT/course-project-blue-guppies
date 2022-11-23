package create_task_use_case;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateTaskOutputDataTest {
    @Test
    public void testGetTitle(){
        CreateTaskOutputData outputData = new CreateTaskOutputData("Feed Kittens", true, 0);
        assertEquals(outputData.getTitle(), "Feed Kittens");
    }
    @Test
    public void testSetTitle(){
        CreateTaskOutputData outputData = new CreateTaskOutputData("Statistics", true, 2);
        outputData.setTitle("Food");
        assertEquals(outputData.getTitle(), "Food");
    }
    @Test
    public void testGetCompleted(){
        CreateTaskOutputData outputData = new CreateTaskOutputData("John Smith", true, 3);
        assertTrue(outputData.getCompleted());
    }
    @Test
    public void testSetCompleted(){
        CreateTaskOutputData outputData = new CreateTaskOutputData("Oranges", false, 4);
        outputData.setCompleted(false);
        assertFalse(outputData.getCompleted());
    }
    @Test
    public void testGetDayID(){
        CreateTaskOutputData outputData = new CreateTaskOutputData("Meal Prep", true, 1);
        assertEquals(outputData.getDayID(), 1);
    }
    @Test
    public void testSetDayID(){
        CreateTaskOutputData outputData = new CreateTaskOutputData("Meal Prep", true, 6);
        outputData.setDayID(2);
        assertEquals(outputData.getDayID(), 2);
    }
}
