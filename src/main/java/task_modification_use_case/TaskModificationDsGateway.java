package task_modification_use_case;

public interface TaskModificationDsGateway {
    boolean taskExistsByTitle(String title, int dayId);
}
