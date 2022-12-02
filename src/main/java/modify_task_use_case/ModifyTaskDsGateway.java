package modify_task_use_case;

/** Task Modification DsGateway Interface. Provides methods which are implemented
 * by ModifyTaskDataAccess to perform the application logic for this use case.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 12, 2022
 * Last Modified: Dec 2, 2022
 */
public interface ModifyTaskDsGateway {
    boolean taskExistsByTitle(String title, int dayIndex);
    void save(ModifyTaskDsInputData dsInputData);
}
