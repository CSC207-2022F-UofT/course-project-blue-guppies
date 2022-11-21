/**
 * Create Task DsGateway Interface.
 * Author: Fardin Faruk
 * Modified By: N/A
 * Created: Nov 19, 2022
 * Last Modified: N/A
 */
package create_task_use_case;

public interface CreateTaskDsGateway {
    boolean existsByTitle(String title, int dayID);

    void save(CreateTaskDsOutputData taskData);
}
