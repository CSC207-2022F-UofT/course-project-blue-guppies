/**
 * Create Task Interactor Class.
 * Author: Fardin Faruk
 * Modified By: Fardin Faruk
 * Created: Nov 19, 2022
 * Last Modified: Nov 27, 2022
 */
package create_task_use_case;

import entities.Task;
import entities.TaskFactory;

import java.lang.reflect.Array;

public class CreateTaskInteractor implements CreateTaskInputBoundary {
    final CreateTaskDsGateway dsGateway;
    final CreateTaskOutputBoundary outputBoundary;
    final TaskFactory taskFactory;

    final private String[] DAYSOFWEEK = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public CreateTaskInteractor(TaskFactory taskFactory, CreateTaskOutputBoundary outputBoundary,
                                CreateTaskDsGateway dsGateway){
        this.taskFactory = taskFactory;
        this.outputBoundary = outputBoundary;
        this.dsGateway = dsGateway;
    }



    @Override
    public CreateTaskOutputData create(CreateTaskInputData inputData) {
        Task task = taskFactory.createTask(inputData.getTitle());
        CreateTaskOutputData createTaskData = new CreateTaskOutputData(task.getTitle(), task.getCompleted(),
                inputData.getDayIndex(), "");
        if (dsGateway.existsByTitle(inputData.getTitle(), inputData.getDayIndex())){
            return outputBoundary.prepareFailView(createTaskData,"There already exists a task with name: " +
                    "'" + inputData.getTitle() +"' on " + DAYSOFWEEK[inputData.getDayIndex()]);
        }
        CreateTaskDsInputData DsData = new CreateTaskDsInputData(task.getTitle(), task.getCompleted(),
                inputData.getDayIndex());
        dsGateway.save(DsData);
        return outputBoundary.prepareSuccessView(createTaskData);
    }
}
