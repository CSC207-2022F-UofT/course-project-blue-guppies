package create_task_use_case;

import strategies.DayToIndexConverter;

/**
 * Task Creation Controller Class; invokes the implementation of createTask given
 * by CreateTaskInteractor to execute the application logic.
 *
 * @author Fardin Faruk
 */
public class CreateTaskController {

    private final CreateTaskInputBoundary inputBoundary;
    private final DayToIndexConverter converter;

    public CreateTaskController(CreateTaskInputBoundary inputBoundary, DayToIndexConverter converter) {
        this.inputBoundary = inputBoundary;
        this.converter = converter;
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
        int dayIndex = this.converter.convertDayNameToIndex(day);
        CreateTaskInputData taskInputData = new CreateTaskInputData(title, dayIndex);
        return inputBoundary.create(taskInputData);
    }

}
