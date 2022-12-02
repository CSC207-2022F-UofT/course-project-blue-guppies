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
        int dayIndex = 0; // if no match assume sunday
        switch (day){
            case "Monday":
                dayIndex = 1;
            case "Tuesday":
                dayIndex = 2;
            case "Wednesday":
                dayIndex = 3;
            case "Thursday":
                dayIndex = 4;
            case "Friday":
                dayIndex = 5;
            case "Saturday":
                dayIndex = 6;
        }
        CreateTaskInputData taskInputData = new CreateTaskInputData(title, dayIndex);

        return inputBoundary.create(taskInputData);
    }
}
