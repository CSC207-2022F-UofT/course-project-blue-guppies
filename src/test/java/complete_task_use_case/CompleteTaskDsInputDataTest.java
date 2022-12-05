package complete_task_use_case;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Task Completion Ds Input Data Test Cases.
 * @author Fardin Faruk
 */
public class CompleteTaskDsInputDataTest {
    @Test
    public void testGetDayIndex(){
        CompleteTaskDsInputData dsInputData = new CompleteTaskDsInputData(0, "Lunch", false);
        assertEquals(dsInputData.getDayIndex(),0);
    }

    @Test
    public void testGetTitle(){
        CompleteTaskDsInputData dsInputData = new CompleteTaskDsInputData(2, "Dinner", true);
        assertEquals(dsInputData.getTitle(),"Dinner");
    }
}
