package create_task_use_case;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Task Creation Input Data Test Cases.
 * @author Fardin Faruk
 */
public class CreateTaskInputDataTest {
    @Test
    public void testGetTitle(){
        CreateTaskInputData inputData = new CreateTaskInputData("Finish 207", 2);
        assertEquals(inputData.getTitle(), "Finish 207");
    }
    @Test
    public void testGetDayIndexSunday(){
        CreateTaskInputData outputData = new CreateTaskInputData("Office Hours", 0);
        assertEquals(outputData.getDayIndex(), 0);
    }
    @Test
    public void testGetDayIndexMonday(){
        CreateTaskInputData outputData = new CreateTaskInputData("Office Hours", 1);
        assertEquals(outputData.getDayIndex(), 1);
    }
    @Test
    public void testGetDayIndexTuesday(){
        CreateTaskInputData outputData = new CreateTaskInputData("Office Hours", 2);
        assertEquals(outputData.getDayIndex(), 2);
    }
    @Test
    public void testGetDayIndexWednesday(){
        CreateTaskInputData outputData = new CreateTaskInputData("Office Hours", 3);
        assertEquals(outputData.getDayIndex(), 3);
    }
    @Test
    public void testGetDayIndexThursday(){
        CreateTaskInputData outputData = new CreateTaskInputData("Office Hours", 4);
        assertEquals(outputData.getDayIndex(), 4);
    }
    @Test
    public void testGetDayIndexFriday(){
        CreateTaskInputData outputData = new CreateTaskInputData("Office Hours", 5);
        assertEquals(outputData.getDayIndex(), 5);
    }
    @Test
    public void testGetDayIndexSaturday(){
        CreateTaskInputData outputData = new CreateTaskInputData("Office Hours", 6);
        assertEquals(outputData.getDayIndex(), 6);
    }

}
