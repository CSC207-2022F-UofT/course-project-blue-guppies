/**
 * Clearing Interactor Class.
 * Author: Ricky Fung
 * Modified By: Ricky Fung
 * Created: Nov 29, 2022
 * Last Modified: Nov 29, 2022
 */
package clearing_use_case;

public class ClearingInteractor implements ClearingInputBoundary {

    private final ClearingOutputBoundary outputBoundary;
    private final ClearingDsGateway dsGateway;

    public ClearingInteractor(ClearingOutputBoundary outputBoundary, ClearingDsGateway dsGateway) {
        this.outputBoundary = outputBoundary;
        this.dsGateway = dsGateway;
    }

    @Override
    public ClearingOutputData clearing() {
        ClearingOutputData response = new ClearingOutputData();
        dsGateway.saveInfo();
        return outputBoundary.prepareSuccessView(response);
    }
}
