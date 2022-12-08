package modify_event_use_case;

/**
 * The Output Boundary Interface for modifying events. Contains methods for preparing Success and Failure views.
 *
 * @author Daniel Livshits
 */
public interface ModifyEventOutputBoundary {
    ModifyEventOutputData prepareSuccessView(ModifyEventOutputData outputData);

    ModifyEventOutputData prepareFailView(ModifyEventOutputData outputData, String failureMessage);
}
