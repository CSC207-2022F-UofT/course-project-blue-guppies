/**
 * Create Task Interactor Class.
 * Author: Fardin Faruk
 * Modified By: N/A
 * Created: Nov 19, 2022
 * Last Modified: N/A
 */
package create_task_use_case;

import entities.Task;
import entities.TaskFactory;

public class CreateTaskInteractor implements CreateTaskInputBoundary {
    final CreateTaskDsGateway createTaskDsGateway;
    final CreateTaskPresenter createTaskPresenter;
    final TaskFactory taskFactory;

    public CreateTaskInteractor(TaskFactory taskFactory, CreateTaskPresenter createTaskPresenter,
                                CreateTaskDsGateway createTaskDsGateway){
        this.taskFactory = taskFactory;
        this.createTaskPresenter = createTaskPresenter;
        this.createTaskDsGateway = createTaskDsGateway;
    }


    @Override
    public CreateTaskOutputData create(CreateTaskInputData createTaskInputData) {
        if (createTaskDsGateway.existsByTitle(createTaskInputData.getTitle(), createTaskInputData.getDayID())){
            return createTaskPresenter.prepareFailView("Task with the same name already exists.");
        }
        Task task = taskFactory.createTask(createTaskInputData.getTitle());
        CreateTaskDsOutputData createTaskDsData = new CreateTaskDsOutputData(task.getTitle(), task.getCompleted(),
                createTaskInputData.getDayID());
        createTaskDsGateway.save(createTaskDsData);

        CreateTaskOutputData createTaskData = new CreateTaskOutputData(task.getTitle(), task.getCompleted(),
                createTaskInputData.getDayID());
        System.out.println(createTaskData);
        return createTaskPresenter.prepareSuccessView(createTaskData);
    }
}
