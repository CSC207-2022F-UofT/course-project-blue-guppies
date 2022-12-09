package complete_task_use_case;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Task Completion Input Data Test Cases.
 * @author Fardin Faruk
 */
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
}
