package task_modification_use_case;

public class TaskModificationFailed extends RuntimeException {
    public TaskModificationFailed(String error) { super(error); }
}
