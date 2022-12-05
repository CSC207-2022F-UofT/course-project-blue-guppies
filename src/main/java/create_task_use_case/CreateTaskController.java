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
    /**
     * Assembles day, title into a CreateTaskInputData object and
     * calls the implementation of createTask given by the interactor/input boundary.
     *
     * @param day The index in string representation of the Day object which will contain a new task.
     * @param title The title of the Task which will be created.
     * @return A CreateTaskOutputData instance which indicates whether the execution of
     * the use case was successful.
     */
    public CreateTaskOutputData createTask(String day, String title){
        CreateTaskInputData taskInputData = new CreateTaskInputData(title, day);

        return inputBoundary.create(taskInputData);
    }
}
