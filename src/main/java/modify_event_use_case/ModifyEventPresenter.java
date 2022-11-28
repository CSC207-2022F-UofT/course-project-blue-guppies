/**
 * The presenter class. Takes in outputData and updates it as necessary.
 * Author: Daniel Livshits
 * Created: Nov 19, 2022
 * Modified by:
 * Last Modified: Nov 19, 2022
 */
package modify_event_use_case;

public class ModifyEventPresenter implements ModifyEventOutputBoundary{
    /**
     * Updates the ViewModel according to the parameters from the outputData.
     * TODO: implement after the view model is implemented. GUI Dependent.
     * @param outputData - an instance of output data for successful modification.
     * @return the instance of output data, after updating the view model.
     */
    @Override
    public ModifyEventOutputData prepareSuccessView(ModifyEventOutputData outputData) {
        return outputData;
    }

    /**
     * Sets the instance of OutputData to represent a failure state and returns it.
     * @param outputData the instance of OutputData for a failing modification.
     * @return outputData with successState changed to false
     */
    @Override
    public ModifyEventOutputData prepareFailView(ModifyEventOutputData outputData, String failureMessage) {
        outputData.setFailureMessage(failureMessage);
        outputData.setSuccessfullyModified(false);
        return outputData;
    }
}
