/**
 * Task Modification Controller Class.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 12, 2022
 * Last Modified: Nov 19, 2022
 */
package task_modification_use_case;

public class TaskModificationController {
    private TaskModificationInputBoundary inputBoundary;

    public TaskModificationController(TaskModificationInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    TaskModificationOutputData modifyTask(int dayId, String newTitle, String title) {
        TaskModificationInputData inputData = new TaskModificationInputData(
                dayId, newTitle, title
        );
        return inputBoundary.modifyTask(inputData);
    }
}
