/**
 * Delete Task OutputData Class.
 * Author: Ricky Fung
 * Modified By: Ricky Fung
 * Created: Nov 19, 2022
 * Last Modified: Nov 19, 2022
 */
package task_deletion_use_case;

public class DeleteTaskOutputData {
    private String label;
    private int inputDay;
    private boolean success = true;
    private String failure = null;

    public DeleteTaskOutputData(int inputDay, String label) {
        this.inputDay = inputDay;
        this.label = label;
    }

    int getInputDay() {
        return inputDay;
    }

    String getLabel() {
        return label;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getFailure() {
        return failure;
    }

    public void setFailure(String failure) {
        this.failure = failure;
    }
}
