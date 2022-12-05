package create_event_use_case;

/**
 * Presenter class for the Create Event use case. Implements the methods provided
 * by the Output Boundary, which address the scenarios where event creation is either
 * successful or unsuccessful.
 *
 * @author Anna Myllyniemi, Raghav Arora
 */
public class CreateEventPresenter implements CreateEventOutputBoundary {

    /**
     * Mark the successful creation of an event by setting the 'success' instance attribute
     * of the Output Data object provided to true.
     *
     * @param outputData The OutputData object whose 'success' instance attribute will
     * be set to true.
     * @return The mutated OutputData object.
     */
    @Override
    public CreateEventOutputData prepareSuccessView(CreateEventOutputData outputData) {
        outputData.setSuccess(true);
        // view model call
        return outputData;
    }

    /**
     * Mark the failure of creation of an event by setting the 'success' instance attribute
     * of the Output Data object provided to false, and setting the errorMessage attribute
     * to an appropriate error message.
     *
     * @param outputData The OutputData object whose 1. 'success' instance attribute will
     * be set to false, and, 2. 'errorMessage' attribute will be set to errorMessage.
     * @param errorMessage The error message representing why event creation failed.
     * @return The mutated OutputData object.
     */
    @Override
    public CreateEventOutputData prepareFailView(CreateEventOutputData outputData, String errorMessage) {
        outputData.setErrorMessage(errorMessage);
        outputData.setSuccess(false);
        return outputData;
    }
}
