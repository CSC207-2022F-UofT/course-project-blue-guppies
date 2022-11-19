package modify_event_use_case;

public interface ModifyEventOutputBoundary {
    public ModifyEventOutputData prepareSuccessView(ModifyEventOutputData outputData);

    public ModifyEventOutputData prepareFailView(ModifyEventOutputData outputData);
}
