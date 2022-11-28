package modify_event_use_case;

import java.time.LocalTime;

public class ModifyEventController {
    public ModifyEventOutputData modify(String title, int dayIndex, String newTitle, String newStart, String newEnd){
        return new ModifyEventOutputData("clean room", 0, "clean bedroom",
                LocalTime.parse("11:30"), LocalTime.parse("12:30"));
    }

}
