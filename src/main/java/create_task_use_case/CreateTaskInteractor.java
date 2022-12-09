package create_task_use_case;

import entities.Task;

/**
 * Task Creation Interactor Class. Implements the createTask method provides
 * by the input boundary and orchestrates the application logic for the use case.
 * @author Fardin Faruk
 */

public class CreateTaskInteractor implements CreateTaskInputBoundary {
    final CreateTaskDsGateway dsGateway;
    final CreateTaskOutputBoundary outputBoundary;

    final private String[] DAYS_OF_WEEK = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public CreateTaskInteractor(CreateTaskOutputBoundary outputBoundary,
                                CreateTaskDsGateway dsGateway){
        this.outputBoundary = outputBoundary;
        this.dsGateway = dsGateway;
    }


    /**
     * Executes the application logic required to create a Task with a given dayIndex by calling the appropriate
     * dsGateway and Output Boundary methods.
     *
     * @param inputData A CreateTaskInputData instance which contains the dayIndex of the Day object which contains
     * the task and title of the Task.
     * @return A CreateTaskOutputData instance which contains title, dayIndex, errorMessage
     * and isSuccessfully modified attributes, such that the latter two indicate whether the
     * use case was successful.
     */
    @Override
    public CreateTaskOutputData create(CreateTaskInputData inputData) {
        Task task = new Task(inputData.getTitle());
        CreateTaskOutputData createTaskData = new CreateTaskOutputData(task.getTitle(), inputData.getDayIndex());
        if (dsGateway.existsByTitle(inputData.getTitle(), inputData.getDayIndex())){
            return outputBoundary.prepareFailView(createTaskData,"There already exists a task with name: " +
                    "'" + inputData.getTitle() +"' on " + DAYS_OF_WEEK[inputData.getDayIndex()]);
        }
        CreateTaskDsInputData DsData = new CreateTaskDsInputData(task, inputData.getDayIndex());
        dsGateway.save(DsData);
        return outputBoundary.prepareSuccessView(createTaskData);
    }
}
