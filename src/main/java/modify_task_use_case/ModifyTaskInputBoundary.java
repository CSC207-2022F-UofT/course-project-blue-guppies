package modify_task_use_case;

/** Task Modification Input Boundary Interface. Provides the modifyTask method, which
 * is invoked in the ModifyTaskController class, and is implemented by ModifyTaskInteractor,
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 12, 2022
 * Last Modified: Dec 2, 2022
 */
public interface ModifyTaskInputBoundary {
    ModifyTaskOutputData modifyTask(ModifyTaskInputData inputData);
}
