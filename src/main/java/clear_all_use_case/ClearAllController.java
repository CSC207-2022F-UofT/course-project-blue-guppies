package clear_all_use_case;

/**
 * Invokes the implementations of clearAll given by ClearAllInteractor to execute application logic.
 * @author Ricky Fung
 */
public class ClearAllController {
    private final ClearAllInputBoundary inputBoundary;

    public ClearAllController(ClearAllInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Implementation of clearAll is called by the inputBoundary
     * to execute the steps needed for clearing.
     *
     * @return An instance of ClearAllOutputData which shows if the
     * clearing is successful.
     */
    public ClearAllOutputData clearAll() {
        return inputBoundary.clearAll();
    }
}
