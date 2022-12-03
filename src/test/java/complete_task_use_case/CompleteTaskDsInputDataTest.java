package complete_task_use_case;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CompleteTaskDsInputDataTest {
    @Test
    public void testGetDayIndex(){
        CompleteTaskDsInputData dsInputData = new CompleteTaskDsInputData(0, "Lunch");
        assertEquals(dsInputData.getDayIndex(),0);
    }
    @Test
    public void testGetTitle(){
        CompleteTaskDsInputData dsInputData = new CompleteTaskDsInputData(2, "Dinner");
        assertEquals(dsInputData.getTitle(),"Dinner");
    }
}
