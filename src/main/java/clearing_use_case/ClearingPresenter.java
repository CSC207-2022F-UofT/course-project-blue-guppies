/**
 * Clearing Presenter Class.
 * Author: Ricky Fung
 * Modified By: Ricky Fung
 * Created: Nov 29, 2022
 * Last Modified: Nov 29, 2022
 */
package clearing_use_case;

public class ClearingPresenter implements ClearingOutputBoundary {

    @Override
    public ClearingOutputData prepareSuccessView(ClearingOutputData response) {
        response.setSuccess(true);
        return response;
    }
}
