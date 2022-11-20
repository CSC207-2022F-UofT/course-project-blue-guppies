package modify_event_use_case;

public interface ModifyEventOutputBoundary {
    ModifyEventOutputData prepareSuccessView(ModifyEventOutputData outputData);

    ModifyEventOutputData prepareFailView(ModifyEventOutputData outputData);
}
