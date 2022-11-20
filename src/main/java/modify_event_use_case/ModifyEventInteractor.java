package modify_event_use_case;

public class ModifyEventInteractor implements ModifyEventInputBoundary{
    private final ModifyEventOutputBoundary outputBoundary;
    private final ModifyEventDsGateway dsGateway;

    public ModifyEventInteractor(ModifyEventOutputBoundary outputBoundary, ModifyEventDsGateway dsGateway){
        this.outputBoundary =outputBoundary;
        this.dsGateway = dsGateway;
    }

    @Override
    public ModifyEventOutputData Modify(ModifyEventInputData inputData){
        ModifyEventOutputData outputData = new ModifyEventOutputData(inputData.getTitle(), inputData.getDayIndex(),
                inputData.getNewTitle(), inputData.getNewStartTime(), inputData.getNewEndTime());
        if(dsGateway.titleExistsInDay(inputData.getDayIndex(), inputData.getNewTitle())){
            outputData.setSuccessState(false);
            outputData.setFailureType("Title");
            return outputBoundary.prepareFailView(outputData);
        }
        else if (dsGateway.isTimeConflict(inputData.getDayIndex(), inputData.getTitle(), inputData.getNewStartTime(),
                inputData.getNewEndTime())){
            outputData.setSuccessState(false);
            outputData.setFailureType("Time");
            return outputBoundary.prepareFailView(outputData);
        }
        ModifyEventDataAccessInput dataAccessInput = new ModifyEventDataAccessInput(inputData.getDayIndex(), inputData.getTitle(),
                inputData.getNewTitle(), inputData.getNewStartTime(), inputData.getNewEndTime());
        dsGateway.save(dataAccessInput);

        return outputBoundary.prepareSuccessView(outputData);
    }
}
