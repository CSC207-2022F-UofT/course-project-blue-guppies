/**
 * Delete Task Controller Class.
 * Author: Ricky Fung
 * Modified By: Ricky Fung
 * Created: Nov 19, 2022
 * Last Modified: Nov 19, 2022
 */
package delete_task_use_case;

public class DeleteTaskController {
    private DeleteTaskInputBoundary inputBoundary;

    public DeleteTaskController(DeleteTaskInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    DeleteTaskOutputData deleteTask(int dayIndex, String taskTitle) {
        DeleteTaskInputData inputData = new DeleteTaskInputData(dayIndex, taskTitle);
        return inputBoundary.deleteTask(inputData);
    }
}