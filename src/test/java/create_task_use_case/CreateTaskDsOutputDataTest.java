package create_task_use_case;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CreateTaskDsOutputDataTest {

    @Test
    public void testGetTitle(){
        CreateTaskDsOutputData outputData = new CreateTaskDsOutputData("Exam", true, 0);
        assertEquals(outputData.getTitle(), "Exam");
    }
    @Test
    public void testSetTitle(){
        CreateTaskDsOutputData outputData = new CreateTaskDsOutputData("Podcast", true, 0);
        outputData.setTitle("Start a Podcast");
        assertEquals(outputData.getTitle(), "Start a Podcast");
    }
    @Test
    public void testGetCompleted(){
        CreateTaskDsOutputData outputData = new CreateTaskDsOutputData("Anime", true, 0);
        assertTrue(outputData.getCompleted());
    }
    @Test
    public void testSetCompleted(){
        CreateTaskDsOutputData outputData = new CreateTaskDsOutputData("Anime", true, 0);
        outputData.setCompleted(false);
        assertFalse(outputData.getCompleted());
    }
    @Test
    public void testGetDayID(){
        CreateTaskDsOutputData outputData = new CreateTaskDsOutputData("Meal Prep", true, 0);
        assertEquals(outputData.getDayID(), 0);
    }
    @Test
    public void testSetDayID(){
        CreateTaskDsOutputData outputData = new CreateTaskDsOutputData("Meal Prep", true, 2);
        outputData.setDayID(4);
        assertEquals(outputData.getDayID(), 4);
    }

}


