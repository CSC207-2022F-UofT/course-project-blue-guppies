package modify_task_use_case;

/**
 * Task Modification DsInputData Class. Instances of type ModifyTaskDsInputData are
 * passed on to the gateway to execute the use case's application logic.
 * @author Raghav Arora
 */
class ModifyTaskDsInputData {
    private final int dayIndex;
    private final String newTitle;
    private String title;

    ModifyTaskDsInputData(int dayIndex, String newTitle, String title) {
        this.dayIndex = dayIndex;
        this.newTitle = newTitle;
        this.title = title;
    }

    protected String getNewTitle() { return this.newTitle; }

    protected int getDayIndex() { return this.dayIndex; }

    protected String getTitle() { return this.title; }

}
