/**
 * Task Modification Data Access Class.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 12, 2022
 * Last Modified: Nov 19, 2022
 */
package task_modification_use_case;

public class TaskModificationDataAccess implements TaskModificationDsGateway {

    public TaskModificationDataAccess() {}

    @Override
    public boolean taskExistsByTitle(String title, int dayID) {
        return false;
    }

    @Override
    public void save(TaskModificationDsInputData dsInputData) {

    }
}
