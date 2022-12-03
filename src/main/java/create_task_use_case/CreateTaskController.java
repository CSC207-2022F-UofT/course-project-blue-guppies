package create_task_use_case;

/**
 * Task Creation Controller Class; invokes the implementation of createTask given
 * by CreateTaskInteractor to execute the application logic.
 * @author Fardin Faruk
 */
public class CreateTaskController {

    private final CreateTaskInputBoundary inputBoundary;

    public CreateTaskController(CreateTaskInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    CreateTaskOutputData createTask(String day, String title){
        CreateTaskInputData taskInputData = new CreateTaskInputData(title, day);

        return inputBoundary.create(taskInputData);
    }
}
