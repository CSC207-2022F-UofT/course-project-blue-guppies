/**
 * Complete Task Controller Class.
 * Author: Fardin Faruk
 * Modified By: N/A
 * Created: Nov 26, 2022
 * Last Modified: N/A
 */
package complete_task_use_case;

public class CompleteTaskController {
    private CompleteTaskInputBoundary inputBoundary;

    public CompleteTaskController(CompleteTaskInputBoundary inputBoundary){
        this.inputBoundary = inputBoundary;
    }

    CompleteTaskOutputData completeTask(int dayID, String title){
        CompleteTaskInputData inputData = new CompleteTaskInputData(dayID, title);
        return inputBoundary.completeTask(inputData);
    }

}
