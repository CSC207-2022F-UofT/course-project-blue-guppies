/**
 * Task Modification Presenter Class.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 12, 2022
 * Last Modified: Dec 1, 2022
 */
package modify_task_use_case;

public class ModifyTaskPresenter implements ModifyTaskOutputBoundary {
    /**
     * @param outputData contains the newTitle of the task modified as well as the
     * corresponding dayIndex.
     *
     * @return the same ModifyTaskOutputData object with its isSuccessfullyModified attribute
     * set to True, and errorMessage set to an empty string.
     */
    @Override
    public ModifyTaskOutputData prepareSuccessView(ModifyTaskOutputData outputData) {
        outputData.setSuccessfullyModified(true);
        outputData.setErrorMessage("");
        return outputData;
    }

    /**
     * @param outputData contains the newTitle of the task modified as well as the
     * corresponding dayIndex.
     *
     * @return the same ModifyTaskOutputData object with its isSuccessfullyModified attribute
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
