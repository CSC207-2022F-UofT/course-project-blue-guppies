package create_task_use_case;

/**
 * Create Task Controller Class; invokes the implementation of createTask given
 *  * by CreateTaskInteractor to execute the application logic.
 *
 * @author Fardin Faruk
 */
public class CreateTaskController {

    private final CreateTaskInputBoundary inputBoundary;

    public CreateTaskController(CreateTaskInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    CreateTaskOutputData createTask(String title, String day){
        CreateTaskInputData taskInputData = new CreateTaskInputData(title, day);

        return inputBoundary.create(taskInputData);
    }
}
