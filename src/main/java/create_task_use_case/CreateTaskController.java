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

    CreateTaskOutputData create(String title, boolean completed, String day){
        CreateTaskInputData taskInputData = new CreateTaskInputData(title, completed, day);

        return createTaskInput.create(taskInputData);
    }
}
