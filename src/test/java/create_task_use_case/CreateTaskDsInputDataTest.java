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
    public void testGetDayIndex(){
        CreateTaskDsInputData outputData = new CreateTaskDsInputData("Meal Prep", 0);
        assertEquals(outputData.getDayIndex(), 0);
    }
}


