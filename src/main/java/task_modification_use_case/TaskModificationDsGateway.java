/**
 * Task Modification DsGateway Interface.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 12, 2022
 * Last Modified: Nov 19, 2022
 */
package task_modification_use_case;

public interface TaskModificationDsGateway {
    boolean taskExistsByTitle(String title, int dayID);
    void save(TaskModificationDsInputData dsInputData);
}
