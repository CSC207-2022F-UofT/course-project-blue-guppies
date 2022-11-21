/**
 * Task Modification Failed Class.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 12, 2022
 * Last Modified: Nov 19, 2022
 */
package modify_task_use_case;

public class ModifyTaskFailed extends RuntimeException {
    public ModifyTaskFailed(String error) { super(error); }
}
