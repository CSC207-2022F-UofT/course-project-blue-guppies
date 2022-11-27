package create_task_use_case;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class CreateTaskPresenterTest {
    @Test
    public void TestPrepareSuccessView(){
        CreateTaskOutputData createTaskOutputData = new CreateTaskOutputData("Test Task", false, 0, "");
        CreateTaskPresenter createTaskPresenter = new CreateTaskPresenter();
        CreateTaskOutputData outputData = createTaskPresenter.prepareSuccessView(createTaskOutputData);
        assertTrue(outputData.isSuccessfullyCreated);
    }
    @Test
    public void TestPrepareFailView(){
        CreateTaskOutputData createTaskOutputData = new CreateTaskOutputData("Test Task", false, 0, "");
        CreateTaskPresenter createTaskPresenter = new CreateTaskPresenter();
        CreateTaskOutputData outputData = createTaskPresenter.prepareFailView(createTaskOutputData,
                "There already exists a task with name: 'Test Task' on Wednesday");
        assertFalse(outputData.isSuccessfullyCreated);
        assertEquals(outputData.getErrorMessage(),
                "There already exists a task with name: 'Test Task' on Wednesday");
    }
}
