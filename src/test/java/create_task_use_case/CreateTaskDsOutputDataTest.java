package create_task_use_case;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CreateTaskDsOutputDataTest {

    @Test
    public void testGetTitle(){
        CreateTaskDsInputData outputData = new CreateTaskDsInputData("Exam", true, 0);
        assertEquals(outputData.getTitle(), "Exam");
    }
    @Test
    public void testSetTitle(){
        CreateTaskDsInputData outputData = new CreateTaskDsInputData("Podcast", true, 0);
        outputData.setTitle("Start a Podcast");
        assertEquals(outputData.getTitle(), "Start a Podcast");
    }
    @Test
    public void testGetCompleted(){
        CreateTaskDsInputData outputData = new CreateTaskDsInputData("Anime", true, 0);
        assertTrue(outputData.getCompleted());
    }
    @Test
    public void testSetCompleted(){
        CreateTaskDsInputData outputData = new CreateTaskDsInputData("Anime", true, 0);
        outputData.setCompleted(false);
        assertFalse(outputData.getCompleted());
    }
    @Test
    public void testGetDayID(){
        CreateTaskDsInputData outputData = new CreateTaskDsInputData("Meal Prep", true, 0);
        assertEquals(outputData.getDayIndex(), 0);
    }
    @Test
    public void testSetDayID(){
        CreateTaskDsInputData outputData = new CreateTaskDsInputData("Meal Prep", true, 2);
        outputData.setDayIndex(4);
        assertEquals(outputData.getDayIndex(), 4);
    }

}


