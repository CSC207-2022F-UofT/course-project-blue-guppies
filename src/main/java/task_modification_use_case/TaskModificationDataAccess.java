package task_modification_use_case;

public class TaskModificationDataAccess implements TaskModificationDsGateway {

    public TaskModificationDataAccess() {}

    @Override

    public boolean taskExistsByTitle(String title, int dayID) {
        return true;
    }
}
