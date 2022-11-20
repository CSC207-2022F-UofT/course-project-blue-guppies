package modify_event_use_case;

import java.time.LocalTime;

public class ModifyEventController {
    private final ModifyEventInputBoundary inputBoundary;

    public ModifyEventController(ModifyEventInputBoundary inputBound){
        this.inputBoundary = inputBound;
    }

    public ModifyEventOutputData Modify(String title, int dayIndex, String newTitle, LocalTime newStart, LocalTime newEnd){
        ModifyEventInputData inputData = new ModifyEventInputData(title, dayIndex, newTitle, newStart, newEnd);
        return inputBoundary.Modify(inputData);
    }
}
