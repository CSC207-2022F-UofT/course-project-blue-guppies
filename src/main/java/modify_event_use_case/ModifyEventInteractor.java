package modify_event_use_case;

import java.time.LocalTime;

/**
 * Interactor for the Modify Event use case. Calls the dsGateway and Output Boundary to appropriately execute
 * application logic.
 *
 * @author Daniel Livshits
 */
public class ModifyEventInteractor implements ModifyEventInputBoundary {
    private final ModifyEventOutputBoundary outputBoundary;
    private final ModifyEventDsGateway dsGateway;

    private static final String[] DAYS_OF_WEEK = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public ModifyEventInteractor(ModifyEventOutputBoundary outputBoundary, ModifyEventDsGateway dsGateway) {
        this.outputBoundary = outputBoundary;
        this.dsGateway = dsGateway;
    }

    /**
     * Modifies the desired event by making calls to the outputBoundary and dsGateway, if there are no conflicts.
     * If there is a naming conflict or time conflict, or if the times are invalid in some way,
     * creates an instance of Output Data representing the corresponding failure state.
     *
     * @param inputData - The data required to modify the desired event.
     * @return An instance of output data, containing the necessary information about the success or failure of
     * the modification.
     */
    @Override
    public ModifyEventOutputData modify(ModifyEventInputData inputData) {
        if (!dsGateway.titleExistsInDay(inputData.getDayIndex(), inputData.getTitle())) {
            String failMessage = "There is no event called " + inputData.getTitle() + " on " +
                    DAYS_OF_WEEK[inputData.getDayIndex()] + "!";
            ModifyEventOutputData outputData = new ModifyEventOutputData(inputData.getTitle(), inputData.getDayIndex(),
                    inputData.getNewTitle(), null, null);
            return outputBoundary.prepareFailView(outputData, failMessage);
        }
        if (!(inputData.getNewStartTime().matches("[01][0-9]:[0-5][0-9]|2[0-3]:[0-5][0-9]")) ||
                !(inputData.getNewEndTime().matches("[01][0-9]:[0-5][0-9]|2[0-3]:[0-5][0-9]"))) {
            ModifyEventOutputData outputData = new ModifyEventOutputData(inputData.getTitle(), inputData.getDayIndex(),
                    inputData.getNewTitle(), null, null);
            String failMessage = "The start and end times are not valid times!";
            return outputBoundary.prepareFailView(outputData, failMessage);
        }
        LocalTime newStartTime = LocalTime.parse(inputData.getNewStartTime());
        LocalTime newEndTime = LocalTime.parse(inputData.getNewEndTime());
        ModifyEventOutputData outputData = new ModifyEventOutputData(inputData.getTitle(), inputData.getDayIndex(),
                inputData.getNewTitle(), newStartTime, newEndTime);
        if (newStartTime.isAfter(newEndTime) || newStartTime.equals(newEndTime)) {
            String failMessage = "The new start time is not before the new end time!";
            return outputBoundary.prepareFailView(outputData, failMessage);
        }
        if (!(inputData.getTitle().equals(inputData.getNewTitle())) &&
                dsGateway.titleExistsInDay(inputData.getDayIndex(), inputData.getNewTitle())) {
            String failMessage = "The title " + inputData.getNewTitle() + " was already used for another event on " +
                   DAYS_OF_WEEK[inputData.getDayIndex()] + ".";
            return outputBoundary.prepareFailView(outputData, failMessage);
        }
        if (dsGateway.isTimeConflict(inputData.getDayIndex(), inputData.getTitle(), newStartTime,
                newEndTime)) {
            String failMessage = "The new times for the event " + inputData.getTitle() +
                    " conflict with another event on " + DAYS_OF_WEEK[inputData.getDayIndex()] + ".";
            return outputBoundary.prepareFailView(outputData, failMessage);
        }
        ModifyEventDsInputData dataAccessInput = new ModifyEventDsInputData(inputData.getDayIndex(), inputData.getTitle(),
                inputData.getNewTitle(), newStartTime, newEndTime);
        dsGateway.save(dataAccessInput);

        return outputBoundary.prepareSuccessView(outputData);
    }
}
