package complete_task_use_case;

/**
 * Task Completion Controller Class; invokes the implementation of completeTask given
 * by CompleteTaskInteractor to execute the application logic.
 * @author Fardin Faruk
 */
public class CompleteTaskController {
    private final CompleteTaskInputBoundary inputBoundary;

    public CompleteTaskController(CompleteTaskInputBoundary inputBoundary){
        this.inputBoundary = inputBoundary;
    }

    public CompleteTaskOutputData completeTask(int dayIndex, String title, boolean taskCompleted){
        CompleteTaskInputData inputData = new CompleteTaskInputData(dayIndex, title, taskCompleted);
        return inputBoundary.completeTask(inputData);
    }

}
