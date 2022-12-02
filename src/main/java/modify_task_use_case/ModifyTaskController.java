/**
 * Task Modification Controller Class.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 12, 2022
 * Last Modified: Dec 1, 2022
 */
package modify_task_use_case;

public class ModifyTaskController {
    private final ModifyTaskInputBoundary inputBoundary;

    /**
     * @param inputBoundary instance which is used to invoke the application logic
     * for the yse case. Instance is implicitly of type ModifyTaskInteractor.
     */
    public ModifyTaskController(ModifyTaskInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * @param dayIndex of the Day object containing the Task instance we want to modify.
     * @param newTitle of the Task whose title will be changed (to newTitle).
     * @param title i.e. existing title of the Task whose title attribute will be changed.
     * @return A ModifyTaskOutputData instance which indicates whether the execution of
     * the use case was successful.
     */
    ModifyTaskOutputData modifyTask(int dayIndex, String newTitle, String title) {
        ModifyTaskInputData inputData = new ModifyTaskInputData(
                dayIndex, newTitle, title
        );
        return inputBoundary.modifyTask(inputData);
    }
}
