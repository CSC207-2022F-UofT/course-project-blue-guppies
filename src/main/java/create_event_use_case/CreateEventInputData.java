package create_event_use_case;

public class CreateEventInputData {
    private final String title;
    private final String startTime;
    private final String endTime;
    private final int dayIndex;

    public CreateEventInputData(String title, String startTime, String endTime, String day) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        switch (day){
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
                break; // if no match assume Saturday
        }
    }

    public String getTitle() {
        return title;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public int getDayIndex() {
        return dayIndex;
    }
}
