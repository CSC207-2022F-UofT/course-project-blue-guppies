package modify_task_use_case;

/**
 * Task Modification Input Boundary Interface. Provides the modifyTask method, which
 * is invoked in the ModifyTaskController class, and is implemented by ModifyTaskInteractor,
 * @author Raghav Arora
 */
public interface ModifyTaskInputBoundary {
    ModifyTaskOutputData modifyTask(ModifyTaskInputData inputData);
}
