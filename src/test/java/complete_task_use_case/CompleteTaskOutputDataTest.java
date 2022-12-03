package complete_task_use_case;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class CompleteTaskOutputDataTest {
    @Test
    public void testGetTitle(){
        CompleteTaskOutputData outputData = new CompleteTaskOutputData("Feed Kittens", 0,
                "");
        assertEquals(outputData.getTitle(), "Feed Kittens");
    }
    @Test
    public void testGetDayIndex(){
        CompleteTaskOutputData outputData = new CompleteTaskOutputData("Meal Prep", 1,
                "");
        assertEquals(outputData.getDayIndex(), 1);
    }
    @Test
    public void testGetErrorMessage(){
        CompleteTaskOutputData outputData = new CompleteTaskOutputData("Meal Prep", 1,
                "There already exists a task with name 'Study' on Monday");
        assertEquals("There already exists a task with name 'Study' on Monday",
                outputData.getErrorMessage());
    }

}
