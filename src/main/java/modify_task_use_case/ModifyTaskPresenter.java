package modify_task_use_case;

/** Task Modification Presenter Class. Implements the prepareSuccessView and prepareFailView
 * methods in the output boundary, by mutating the ModifyTaskOutputData object that is
 * passed on as a parameter, appropriately.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 12, 2022
 * Last Modified: Dec 2, 2022
 */
public class ModifyTaskPresenter implements ModifyTaskOutputBoundary {
    /** Mutate the ModifyTaskOutputData instance provided by setting its
     * isSuccessfullyModified attribute to true, and errorMessage to the empty string.
     * @param outputData Contains the newTitle of the task modified as well as the
     * corresponding dayIndex.
     * @return The same ModifyTaskOutputData object with its isSuccessfullyModified attribute
     * set to True, and errorMessage set to an empty string.
     */
    @Override
    public ModifyTaskOutputData prepareSuccessView(ModifyTaskOutputData outputData) {
        outputData.setSuccessfullyModified(true);
        outputData.setErrorMessage("");
        return outputData;
    }

    /** Mutate the ModifyTaskOutputData instance provided by setting its
     * isSuccessfullyModified attribute to false, and errorMessage to a non-empty string.
     * @param outputData Contains the newTitle of the task modified as well as the
     * corresponding dayIndex.
     * @return The same ModifyTaskOutputData object with its isSuccessfullyModified attribute
     * set to True, and errorMessage set to an empty string.
     */
    @Override
    public ModifyTaskOutputData prepareFailView(
            ModifyTaskOutputData outputData,
            String errorMessage
    ) {
        outputData.setSuccessfullyModified(false);
        outputData.setErrorMessage(errorMessage);
        return outputData;
    }
}
