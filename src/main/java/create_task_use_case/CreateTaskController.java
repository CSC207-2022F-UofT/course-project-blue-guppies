package create_task_use_case;

/**
 * Task Creation Controller Class; invokes the implementation of createTask given
 * by CreateTaskInteractor to execute the application logic.
 *
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
     * @param day   The index in string representation of the Day object which will contain a new task.
     * @param title The title of the Task which will be created.
     * @return A CreateTaskOutputData instance which indicates whether the execution of
     * the use case was successful.
     */
    public CreateTaskOutputData createTask(String day, String title){
        int dayIndex;
        switch (day) {
            case "Sunday":
                dayIndex = 0;
                break;
            case "Monday":
                dayIndex = 1;
                break;
            case "Tuesday":
                dayIndex = 2;
                break;
            case "Wednesday":
                dayIndex = 3;
                break;
            case "Thursday":
                dayIndex = 4;
                break;
            case "Friday":
                dayIndex = 5;
                break;
            default:
                dayIndex = 6;
                break;
            // if no match assume Saturday
        }
        CreateTaskInputData taskInputData = new CreateTaskInputData(title, dayIndex);
        return inputBoundary.create(taskInputData);
    }

}
