package modify_event_use_case;

/**
 * Input boundary interface. Contains a modify method, which should execute application logic in an implementing class.
 *
 * @author Daniel Livshits
 */
public interface ModifyEventInputBoundary {
    ModifyEventOutputData modify(ModifyEventInputData inputData);
}
