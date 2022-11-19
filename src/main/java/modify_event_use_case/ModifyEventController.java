package modify_event_use_case;

import java.time.LocalTime;

public class ModifyEventController {
    private final ModifyEventInputBoundary inputBoundary;

    public ModifyEventController(ModifyEventInputBoundary inputBound){
        this.inputBoundary = inputBound;
    }

    public ModifyEventOutputData Modify(String title, int day, String newTitle, LocalTime newStart, LocalTime newEnd){
        ModifyEventInputData inputData = new ModifyEventInputData(title, day, newTitle, newStart, newEnd);
        return inputBoundary.Modify(inputData);
    }
}
