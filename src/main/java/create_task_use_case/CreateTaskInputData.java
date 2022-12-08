package create_task_use_case;

/**
 * Task Creation Input Data Class. Parameters passed on to the method createTask
 * of the Controller class are assembled into CreateTaskInputData object before invoking
 * the implementation of createTask given by the interactor/input boundary.
 *
 * @author Fardin Faruk
 */
public class CreateTaskInputData {

    private final String title;
    private final int dayIndex;

    public CreateTaskInputData(String title, String dayIndex) {
        this.title = title;

        switch (dayIndex) {
            case "Sunday":
                this.dayIndex = 0;
                break;
            case "Monday":
                this.dayIndex = 1;
                break;
            case "Tuesday":
                this.dayIndex = 2;
                break;
            case "Wednesday":
                this.dayIndex = 3;
                break;
            case "Thursday":
                this.dayIndex = 4;
                break;
            case "Friday":
                this.dayIndex = 5;
                break;
            default:
                this.dayIndex = 6;
                break;
            // if no match assume Saturday
        }
    }


    String getTitle() {
        return title;
    }

    int getDayIndex() {
        return dayIndex;
    }

}
