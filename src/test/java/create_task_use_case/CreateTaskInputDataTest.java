package create_task_use_case;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreateTaskInputDataTest {
    @Test
    public void testGetTitle(){
        CreateTaskInputData inputData = new CreateTaskInputData("Finish 207", "Tuesday");
        assertEquals(inputData.getTitle(), "Finish 207");
    }
    @Test
    public void testGetDayIndex(){
        CreateTaskInputData outputData = new CreateTaskInputData("Office Hours", "Tuesday");
        assertEquals(outputData.getDayIndex(), 2);
    }
}
