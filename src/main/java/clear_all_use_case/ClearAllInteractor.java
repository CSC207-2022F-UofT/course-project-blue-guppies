package clear_all_use_case;

/**
 * Implements the clearAll method and
 * calls outputBoundary and dsGateway to clear.
 *
 * @author Ricky Fung
 */
public class ClearAllInteractor implements ClearAllInputBoundary {

    private final ClearAllOutputBoundary outputBoundary;
    private final ClearAllDsGateway dsGateway;

    public ClearAllInteractor(ClearAllOutputBoundary outputBoundary, ClearAllDsGateway dsGateway) {
        this.outputBoundary = outputBoundary;
        this.dsGateway = dsGateway;
    }

    /**
     * Executes the application logic required for clearing.
     *
     * @return CleaAllOutputData instance attributes which contains the information
     * of the success for clearing.
     */
    @Override
    public ClearAllOutputData clearAll() {
        ClearAllOutputData response = new ClearAllOutputData();
        dsGateway.save();
        return outputBoundary.prepareSuccessView(response);
    }
}
