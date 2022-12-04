package clear_all_use_case;

/**
 * Implements the prepareSuccessView methods in ClearAllOutputBoundary.
 * @author Ricky Fung
 */
public class ClearAllPresenter implements ClearAllOutputBoundary {

    /**
     * Sets success of the ClearAllOutputData instance to true.
     * @param outputData An instance of ClearAllOutputData.
     * @return The ClearAllOutputData object with the success attribute set to true.
     */
    @Override
    public ClearAllOutputData prepareSuccessView(ClearAllOutputData outputData) {
        outputData.setSuccess(true);
        return outputData;
    }
}
