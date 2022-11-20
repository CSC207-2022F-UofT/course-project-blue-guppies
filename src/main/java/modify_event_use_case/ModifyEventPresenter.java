package modify_event_use_case;

public class ModifyEventPresenter implements ModifyEventOutputBoundary{
    @Override
    public ModifyEventOutputData prepareSuccessView(ModifyEventOutputData outputData) {
        return outputData;
    }

    @Override
    public ModifyEventOutputData prepareFailView(ModifyEventOutputData outputData) {
        return outputData;
    }
}
