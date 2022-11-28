/**
 * The Output Boundary Interface for modifying events. Contains methods for preparing Success and Failure views.
 * Author: Daniel Livshits
 * Created: Nov 19, 2022
 * Modified by:
 * Last Modified: Nov 19, 2022
 */
package modify_event_use_case;

public interface ModifyEventOutputBoundary {
    ModifyEventOutputData prepareSuccessView(ModifyEventOutputData outputData);

    ModifyEventOutputData prepareFailView(ModifyEventOutputData outputData, String failureMessage);
}
