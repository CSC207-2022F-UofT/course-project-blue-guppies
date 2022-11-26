/**
 * Task Modification Controller Class.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 12, 2022
 * Last Modified: Nov 19, 2022
 */
package modify_task_use_case;

public class ModifyTaskController {
    private ModifyTaskInputBoundary inputBoundary;

    public ModifyTaskController(ModifyTaskInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    ModifyTaskOutputData modifyTask(int dayID, String newTitle, String title) {
        ModifyTaskInputData inputData = new ModifyTaskInputData(
                dayID, newTitle, title
        );
        return inputBoundary.modifyTask(inputData);
    }
}
