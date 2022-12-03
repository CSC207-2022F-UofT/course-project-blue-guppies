package create_task_use_case;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Task Creation Ds Input Data Test Cases.
 * @author Fardin Faruk
 */
public class CreateTaskDsInputDataTest {

    @Test
    public void testGetTitle(){
        CreateTaskDsInputData inputData = new CreateTaskDsInputData("Exam", 0);
        assertEquals("Exam", inputData.getTitle());
    }
    @Test
    public void testGetDayIndex(){
        CreateTaskDsInputData inputData = new CreateTaskDsInputData("Meal Prep", 0);
        assertEquals(0, inputData.getDayIndex());
    }
}


