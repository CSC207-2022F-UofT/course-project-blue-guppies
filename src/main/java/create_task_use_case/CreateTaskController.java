/**
 * Create Task Controller Class.
 * Author: Fardin Faruk
 * Modified By: N/A
 * Created: Nov 19, 2022
 * Last Modified: N/A
 */
package create_task_use_case;

public class CreateTaskController {

    final CreateTaskInputBoundary createTaskInput;

    public CreateTaskController(CreateTaskInputBoundary createTaskInput) {
        this.createTaskInput = createTaskInput;
    }

    CreateTaskOutputData createTask(String title, boolean completed, int dayID){
        CreateTaskInputData taskInputData = new CreateTaskInputData(title, completed, dayID);

        return createTaskInput.create(taskInputData);
    }
}
