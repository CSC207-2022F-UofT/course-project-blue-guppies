package complete_task_use_case;

import entities.TaskFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompleteTaskControllerTest {
    private final static CompleteTaskOutputBoundary createTaskPresenter = new CompleteTaskPresenter();
    private final static CompleteTaskDataAccess completeTaskDataAccess = new CompleteTaskDataAccess();
}
