package clear_all_use_case;

/**
 * Instances of this class are returned and set back
 * to the controller, with the success instance
 * attributes indicating the success of clearing all.
 *
 * @author Ricky Fung
 */
public class ClearAllOutputData {
    private boolean success;

    public ClearAllOutputData() {
        this.success = false;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
