package task_modification_use_case;
import entities.TaskFactory;

public class TaskModificationInteractor implements TaskModificationInputBoundary {
    private TaskModificationOutputBoundary taskModificationOutputBoundary;
    private TaskModificationDsGateway taskModificationDsGateway;
}
