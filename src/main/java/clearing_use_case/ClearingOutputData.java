/**
 * Clearing OutputData Class.
 * Author: Ricky Fung
 * Modified By: Ricky Fung
 * Created: Nov 29, 2022
 * Last Modified: Nov 29, 2022
 */
package clearing_use_case;

public class ClearingOutputData {
    private boolean success;

    public ClearingOutputData(){
        this.success = false;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
