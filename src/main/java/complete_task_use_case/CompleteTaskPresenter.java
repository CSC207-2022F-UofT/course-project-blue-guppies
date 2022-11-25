package complete_task_use_case;

public class CompleteTaskPresenter implements  CompleteTaskOutputBoundary {
    @Override
    public CompleteTaskOutputData prepareSuccessView(CompleteTaskOutputData task) {
        task.setSuccessfullyCreated(true);
        return task;
    }
}
