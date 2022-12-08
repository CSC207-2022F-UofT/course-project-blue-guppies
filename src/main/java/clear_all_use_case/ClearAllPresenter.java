package clear_all_use_case;

import screens.ViewModelBoundary;

/**
 * Implements the prepareSuccessView methods in
 * ClearAllOutputBoundary.
 *
 * @author Ricky Fung
 */
public class ClearAllPresenter implements ClearAllOutputBoundary {
    private final ViewModelBoundary viewModel;

    public ClearAllPresenter(ViewModelBoundary viewModel) {
        this.viewModel = viewModel;
    }

    /**
     * Sets success of the ClearAllOutputData instance to true.
     *
     * @param outputData An instance of ClearAllOutputData.
     * @return The ClearAllOutputData object with the success attribute set to true.
     */
    @Override
    public ClearAllOutputData prepareSuccessView(ClearAllOutputData outputData) {
        viewModel.clearAll();
        outputData.setSuccess(true);
        return outputData;
    }
}
