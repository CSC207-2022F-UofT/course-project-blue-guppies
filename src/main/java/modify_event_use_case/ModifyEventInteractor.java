/**
 * Interactor for the Modify Event use case. Calls the dsGateway and Output Boundary to modify the event.
 * Author: Daniel Livshits
 * Created: Nov 19, 2022
 * Modified by:
 * Last Modified: Nov 19, 2022
 */
package modify_event_use_case;

public class ModifyEventInteractor implements ModifyEventInputBoundary{
    private final ModifyEventOutputBoundary outputBoundary;
    private final ModifyEventDsGateway dsGateway;

    public ModifyEventInteractor(ModifyEventOutputBoundary outputBoundary, ModifyEventDsGateway dsGateway){
        this.outputBoundary = outputBoundary;
        this.dsGateway = dsGateway;
    }

    /**
     * Modifies the desired event by making calls to the outputBoundary and dsGateway, if there are no conflicts.
     * If there is a naming conflict or time conflict, creates an instance of Output Data representing the corresponding
     * failure state.
     * @param inputData - the data required to modify the desired event.
     * @return an instance of output data, containing the necessary information about the success or failure of
     * the modification.
     */
    @Override
    public ModifyEventOutputData modify(ModifyEventInputData inputData){
        ModifyEventOutputData outputData = new ModifyEventOutputData(inputData.getTitle(), inputData.getDayIndex(),
                inputData.getNewTitle(), inputData.getNewStartTime(), inputData.getNewEndTime());
        if(dsGateway.titleExistsInDay(inputData.getDayIndex(), inputData.getNewTitle())){
            outputData.setFailureType("Title");
            return outputBoundary.prepareFailView(outputData);
        }
        else if (dsGateway.isTimeConflict(inputData.getDayIndex(), inputData.getTitle(), inputData.getNewStartTime(),
                inputData.getNewEndTime())){
            outputData.setFailureType("Time");
            return outputBoundary.prepareFailView(outputData);
        }
        ModifyEventDsInputData dataAccessInput = new ModifyEventDsInputData(inputData.getDayIndex(), inputData.getTitle(),
                inputData.getNewTitle(), inputData.getNewStartTime(), inputData.getNewEndTime());
        dsGateway.save(dataAccessInput);

        return outputBoundary.prepareSuccessView(outputData);
    }
}
