/**
 * Create Task Interactor Class.
 * Author: Fardin Faruk
 * Modified By: Fardin Faruk
 * Created: Nov 19, 2022
 * Last Modified: Nov 26, 2022
 */
package create_task_use_case;

import entities.Task;
import entities.TaskFactory;

public class CreateTaskInteractor implements CreateTaskInputBoundary {
    final CreateTaskDsGateway createTaskDsGateway;
    final CreateTaskOutputBoundary createTaskOutputBoundary;
    final TaskFactory taskFactory;

    public CreateTaskInteractor(TaskFactory taskFactory, CreateTaskOutputBoundary createTaskOutputBoundary,
                                CreateTaskDsGateway createTaskDsGateway){
        this.taskFactory = taskFactory;
        this.createTaskOutputBoundary = createTaskOutputBoundary;
        this.createTaskDsGateway = createTaskDsGateway;
    }


    @Override
    public CreateTaskOutputData create(CreateTaskInputData createTaskInputData) {
        if (createTaskDsGateway.existsByTitle(createTaskInputData.getTitle(), createTaskInputData.getDayID())){
            return createTaskOutputBoundary.prepareFailView("Task with the same name already exists.");
        }
        Task task = taskFactory.createTask(createTaskInputData.getTitle());
        CreateTaskDsOutputData createTaskDsData = new CreateTaskDsOutputData(task.getTitle(), task.getCompleted(),
                createTaskInputData.getDayID());
        createTaskDsGateway.save(createTaskDsData);

        CreateTaskOutputData createTaskData = new CreateTaskOutputData(task.getTitle(), task.getCompleted(),
                createTaskInputData.getDayID());
        System.out.println(createTaskData);
        return createTaskOutputBoundary.prepareSuccessView(createTaskData);
    }
}
