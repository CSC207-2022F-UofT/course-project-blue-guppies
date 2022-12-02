/**
 * Complete Task Ds Gateway Interface.
 * Author: Fardin Faruk
 * Modified By: N/A
 * Created: Nov 26, 2022
 * Last Modified: N/A
 */
package complete_task_use_case;

public interface CompleteTaskDsGateway {
    void save(CompleteTaskDsInputData dsInputData);
    boolean existsByTitle(String title, int dayIndex);
}
