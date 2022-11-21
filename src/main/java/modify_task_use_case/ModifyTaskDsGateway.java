/**
 * Task Modification DsGateway Interface.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 12, 2022
 * Last Modified: Nov 19, 2022
 */
package modify_task_use_case;

public interface ModifyTaskDsGateway {
    boolean taskExistsByTitle(String title, int dayID);
    void save(ModifyTaskDsInputData dsInputData);
}
