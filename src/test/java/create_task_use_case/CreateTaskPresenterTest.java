package create_task_use_case;

import org.junit.jupiter.api.Test;

public class CreateTaskPresenterTest {
    @Test
    public void TestPrepareSuccessView(){
        CreateTaskOutputData createTaskOutputData = new CreateTaskOutputData("Test Task", false, 0);
        CreateTaskPresenter createTaskPresenter = new CreateTaskPresenter();
        createTaskPresenter.prepareSuccessView(createTaskOutputData);
    }
    // Prepare Fail View does nothing to test for now, test cases will be updated upon GUI integration
}
