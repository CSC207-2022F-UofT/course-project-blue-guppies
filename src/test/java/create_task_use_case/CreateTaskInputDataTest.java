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
        CreateTaskInputData inputData = new CreateTaskInputData("Finish 207", "Tuesday");
        assertEquals(inputData.getTitle(), "Finish 207");
    }
    @Test
    public void testGetDayIndexSunday(){
        CreateTaskInputData outputData = new CreateTaskInputData("Office Hours", "Sunday");
        assertEquals(outputData.getDayIndex(), 0);
    }
    @Test
    public void testGetDayIndexMonday(){
        CreateTaskInputData outputData = new CreateTaskInputData("Office Hours", "Monday");
        assertEquals(outputData.getDayIndex(), 1);
    }
    @Test
    public void testGetDayIndexTuesday(){
        CreateTaskInputData outputData = new CreateTaskInputData("Office Hours", "Tuesday");
        assertEquals(outputData.getDayIndex(), 2);
    }
    @Test
    public void testGetDayIndexWednesday(){
        CreateTaskInputData outputData = new CreateTaskInputData("Office Hours", "Wednesday");
        assertEquals(outputData.getDayIndex(), 3);
    }
    @Test
    public void testGetDayIndexThursday(){
        CreateTaskInputData outputData = new CreateTaskInputData("Office Hours", "Thursday");
        assertEquals(outputData.getDayIndex(), 4);
    }
    @Test
    public void testGetDayIndexFriday(){
        CreateTaskInputData outputData = new CreateTaskInputData("Office Hours", "Friday");
        assertEquals(outputData.getDayIndex(), 5);
    }
    @Test
    public void testGetDayIndexSaturday(){
        CreateTaskInputData outputData = new CreateTaskInputData("Office Hours", "Saturday");
        assertEquals(outputData.getDayIndex(), 6);
    }

}
