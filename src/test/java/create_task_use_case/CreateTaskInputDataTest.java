package create_task_use_case;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreateTaskInputDataTest {
    @Test
    public void testGetTitle(){
        CreateTaskInputData inputData = new CreateTaskInputData("Finish 207", false, 3);
        assertEquals(inputData.getTitle(), "Finish 207");
    }
    @Test
    public void testSetTitle(){
        CreateTaskInputData inputData = new CreateTaskInputData("Finish 207 Project", false, 3);
        inputData.setTitle("Finish Use Case");
        assertEquals(inputData.getTitle(), "Finish Use Case");
    }
    @Test
    public void testGetCompleted(){
        CreateTaskInputData inputData = new CreateTaskInputData("Hi Reviewer", false, 2);
        assertFalse(inputData.getCompleted());
    }
    @Test
    public void testSetCompleted(){
        CreateTaskInputData inputData = new CreateTaskInputData("Get Some Friends", false, 5);
        inputData.setCompleted(true);
        assertTrue(inputData.getCompleted());
    }
    @Test
    public void testGetDayID(){
        CreateTaskInputData outputData = new CreateTaskInputData("Office Hours", true, 3);
        assertEquals(outputData.getDayIndex(), 3);
    }
}
