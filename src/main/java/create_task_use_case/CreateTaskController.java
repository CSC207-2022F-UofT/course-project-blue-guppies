/**
 * Create Task Controller Class.
 * Author: Fardin Faruk
 * Modified By: Fardin Faruk
 * Created: Nov 19, 2022
 * Last Modified: Nov 27, 2022
 */
package create_task_use_case;

public class CreateTaskController {

    private final CreateTaskInputBoundary inputBoundary;

    public CreateTaskController(CreateTaskInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    CreateTaskOutputData createTask(String title, String day){
        CreateTaskInputData taskInputData = new CreateTaskInputData(title, day);

        return inputBoundary.create(taskInputData);
    }
}
