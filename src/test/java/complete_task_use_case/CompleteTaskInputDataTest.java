package complete_task_use_case;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompleteTaskInputDataTest {
    @Test
    public void testGetDayIndex(){
        CompleteTaskDsInputData dsInputData = new CompleteTaskDsInputData(1, "Orange");
        assertEquals(dsInputData.getDayIndex(),1);
    }
    @Test
    public void testGetTitle(){
        CompleteTaskDsInputData dsInputData = new CompleteTaskDsInputData(3, "Apple");
        assertEquals(dsInputData.getTitle(),"Apple");
    }
    @Test
    public void testSetTitle() {
        CompleteTaskDsInputData dsInputData = new CompleteTaskDsInputData(4, "Banana");
        dsInputData.setTitle("Milk");
        assertEquals(dsInputData.getTitle(), "Milk");
    }
}
