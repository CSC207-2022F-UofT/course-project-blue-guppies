package create_task_use_case;

import entities.TaskFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreateTaskInteractorTest {
    private final static CreateTaskOutputBoundary createTaskPresenter = new CreateTaskPresenter();
    private final static CreateTaskDataAccess createTaskDataAccess = new CreateTaskDataAccess();
    private final static TaskFactory taskFactory = new TaskFactory();
    @Test
    public void createTest(){
        CreateTaskInputData inputData = new CreateTaskInputData("Finish Unit Test", false, 3);
        CreateTaskInteractor createTaskInteractor = new CreateTaskInteractor(taskFactory, createTaskPresenter,
                createTaskDataAccess);
        CreateTaskOutputData createTaskOutputData = createTaskInteractor.create(inputData);
        assertTrue(createTaskOutputData.isSuccessfullyCreated());
    }
}
