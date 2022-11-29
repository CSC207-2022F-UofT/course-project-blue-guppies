/**
 * Clearing Controller Class.
 * Author: Ricky Fung
 * Modified By: Ricky Fung
 * Created: Nov 29, 2022
 * Last Modified: Nov 29, 2022
 */
package clearing_use_case;

public class ClearingController {
    private final ClearingInputBoundary inputBoundary;

    public ClearingController(ClearingInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    ClearingOutputData clearing() {
        return inputBoundary.clearing();
    }
}
