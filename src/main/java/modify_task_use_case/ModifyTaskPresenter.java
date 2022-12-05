package modify_task_use_case;

import screens.ViewModelBoundary;

/**
 * Task Modification Presenter Class. Implements the prepareSuccessView and prepareFailView
 * methods in the output boundary, by mutating the ModifyTaskOutputData object that is
 * passed on as a parameter, appropriately.
 * @author Raghav Arora
 */
public class ModifyTaskPresenter implements ModifyTaskOutputBoundary {
    private final ViewModelBoundary viewModelBoundary;

    public ModifyTaskPresenter() {
        viewModelBoundary = null;
    }

    public ModifyTaskPresenter(ViewModelBoundary viewModelBoundary) {
        this.viewModelBoundary = viewModelBoundary;
    }

    /**
     * Mutate the ModifyTaskOutputData instance provided by setting its
     * isSuccessfullyModified attribute to true, and errorMessage to the empty string.
     *
     * @param outputData A ModifyTaskOutputData instance which Contains the newTitle of the task modified
     * as well as the corresponding dayIndex.
     * @return The same ModifyTaskOutputData object with its isSuccessfullyModified attribute
     * set to True, and errorMessage set to an empty string.
     */
    @Override
    public ModifyTaskOutputData prepareSuccessView(ModifyTaskOutputData outputData) {
        outputData.setSuccessfullyModified(true);
        outputData.setErrorMessage("");
        if (viewModelBoundary != null) {
            viewModelBoundary.modifyTask(outputData.getDayIndex(), outputData.getOldTitle(), outputData.getTitle());
        }
        return outputData;
    }

    /**
     * Mutate the ModifyTaskOutputData instance provided by setting its
     * isSuccessfullyModified attribute to false, and errorMessage to a non-empty string.
     *
     * @param outputData A ModifyTaskOutputData instance which contains the newTitle of the task modified
     * as well as the corresponding dayIndex.
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
