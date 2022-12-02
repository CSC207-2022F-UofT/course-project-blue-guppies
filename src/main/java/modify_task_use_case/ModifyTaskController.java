package modify_task_use_case;

/** Task Modification Controller Class; invokes the implementation of modifyTask given
 * by ModifyTaskInteractor to execute the application logic.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 12, 2022
 * Last Modified: Dec 2, 2022
 */
public class ModifyTaskController {
    private final ModifyTaskInputBoundary inputBoundary;

    /**
     * @param inputBoundary Instance which is used to invoke the application logic
     * for the yse case. Instance is implicitly of type ModifyTaskInteractor.
     */
    public ModifyTaskController(ModifyTaskInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /** Assembles dayIndex, newTitle and title into a ModifyTaskInputData object and
     * calls the implementation of modifyTask given by the interactor/input boundary.
     * @param dayIndex Of the Day object containing the Task instance we want to modify.
     * @param newTitle Of the Task whose title will be changed (to newTitle).
     * @param title i.e. Existing title of the Task whose title attribute will be changed.
     * @return A ModifyTaskOutputData instance which indicates whether the execution of
     * the use case was successful.
     */
    public ModifyTaskOutputData modifyTask(int dayIndex, String newTitle, String title) {
        ModifyTaskInputData inputData = new ModifyTaskInputData(
                dayIndex, newTitle, title
        );
        return inputBoundary.modifyTask(inputData);
    }
}
