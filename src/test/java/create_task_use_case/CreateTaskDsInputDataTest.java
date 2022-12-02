package create_task_use_case;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CreateTaskDsInputDataTest {

    @Test
    public void testGetTitle(){
        CreateTaskDsInputData outputData = new CreateTaskDsInputData("Exam", 0);
        assertEquals(outputData.getTitle(), "Exam");
    }
    @Test
    public void testSetTitle(){
        CreateTaskDsInputData outputData = new CreateTaskDsInputData("Podcast", 0);
        outputData.setTitle("Start a Podcast");
        assertEquals(outputData.getTitle(), "Start a Podcast");
    }
    @Test
    public void testGetDayIndex(){
        CreateTaskDsInputData outputData = new CreateTaskDsInputData("Meal Prep", 0);
        assertEquals(outputData.getDayIndex(), 0);
    }
    @Test
    public void testSetDayIndex(){
        CreateTaskDsInputData outputData = new CreateTaskDsInputData("Meal Prep", 2);
        outputData.setDayIndex(4);
        assertEquals(outputData.getDayIndex(), 4);
    }

}


