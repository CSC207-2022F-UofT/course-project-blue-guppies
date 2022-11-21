/**
 * Task Modification Controller Class.
 * Author: Raghav Arora
 * Modified By: Anna Myllyniemi
 * Created: Nov 12, 2022
 * Last Modified: Nov 20, 2022
 */
package modify_task_use_case;

public class ModifyTaskController {
    private final ModifyTaskInputBoundary inputBoundary;

    public ModifyTaskController(ModifyTaskInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public ModifyTaskOutputData modifyTask(int dayId, String newTitle, String title) {
        ModifyTaskInputData inputData = new ModifyTaskInputData(
                dayId, newTitle, title
        );
        return inputBoundary.modifyTask(inputData);
    }
}

