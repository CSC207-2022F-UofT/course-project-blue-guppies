package modify_event_use_case;

/**
 * Input boundary interface. Contains a modify method that returns Output Data.
 * @author Daniel Livshits
 */
public interface ModifyEventInputBoundary {
    ModifyEventOutputData modify(ModifyEventInputData inputData);
}
