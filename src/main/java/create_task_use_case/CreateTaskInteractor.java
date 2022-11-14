package create_task_use_case;

import entities.Task;
import entities.TaskFactory;

public class CreateTaskInteractor implements CreateTaskInputBoundary {
    // TODO: CreateTaskDSThings for Data Persistence
    // TODO: CreateTask Presenter Things
    final TaskFactory taskFactory;

    public CreateTaskInteractor(TaskFactory taskFactory){
        this.taskFactory = taskFactory;
    }


    @Override
    public CreateTaskResponseModel create(CreateTaskRequestModel requestModel) {
        Task task = taskFactory.createTask(requestModel.getTitle());
        // TODO: Check existence on Gateway
        // TODO: Save on gateway
        CreateTaskResponseModel taskRequestModel = new CreateTaskResponseModel(task.getTitle(), task.getCompleted());
        return null;
    }
}
