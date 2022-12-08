package modify_event_use_case;

import screens.ViewModelBoundary;

/**
 * The presenter class. Takes in outputData and updates it as necessary to prepare a Success or Failure view.
 *
 * @author Daniel Livshits
 */
public class ModifyEventPresenter implements ModifyEventOutputBoundary {
    private final ViewModelBoundary viewModelBoundary;

    public ModifyEventPresenter(ViewModelBoundary viewModelBoundary) {
        this.viewModelBoundary = viewModelBoundary;
    }

    /**
     * Updates the ViewModel according to the parameters from the outputData.
     *
     * @param outputData - An instance of output data for successful modification.
     * @return The instance of output data, after updating the view model.
     */
    @Override
    public ModifyEventOutputData prepareSuccessView(ModifyEventOutputData outputData) {
        viewModelBoundary.modifyEvent(outputData.getDayIndex(), outputData.getTitle(), outputData.getNewTitle(),
                outputData.getNewStartTime(), outputData.getNewEndTime());
        return outputData;
    }

    /**
     * Sets the instance of OutputData to represent a failure state and returns it.
     *
     * @param outputData The instance of OutputData for a failing modification.
     * @return The same instance of outputData with successState changed to false.
     */
    @Override
    public ModifyEventOutputData prepareFailView(ModifyEventOutputData outputData, String failureMessage) {
        outputData.setFailureMessage(failureMessage);
        outputData.setSuccessfullyModified(false);
        return outputData;
    }
}
