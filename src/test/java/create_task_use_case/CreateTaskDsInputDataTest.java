package create_task_use_case;

import entities.Task;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Task Creation Ds Input Data Test Cases.
 * @author Fardin Faruk
 */
public class CreateTaskDsInputDataTest {

    @Test
    public void testGetTitle(){
        Task exam = new Task("Exam");
        CreateTaskDsInputData inputData = new CreateTaskDsInputData(exam, 0);
        assertEquals("Exam", inputData.getTask().getTitle());
    }
    @Test
    public void testGetDayIndex(){
        Task mealPrep = new Task("Meal Prep");
        CreateTaskDsInputData inputData = new CreateTaskDsInputData(mealPrep, 0);
        assertEquals(0, inputData.getDayIndex());
    }
}


