package create_event_use_case;

import entities.Event;

import java.time.LocalTime;

/**
 * Ds Input Data class for the Create Event use case. Instances of this class
 * are passed on to the Ds Gateway to execute the application logic.
 *
 * @author Anna Myllyniemi, Raghav Arora
 */
class CreateEventDsInputData {
    private final String title;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final int dayIndex;
    private final Event newEvent;


    /**
     * Data passed into the DsGateway containing relevant information for adding the new Event into the data access.
     *
     * @param dayIndex The index of the day the Event occurs on
     * @param newEvent The actual Event entity
     */
    CreateEventDsInputData(int dayIndex, Event newEvent) {
        this.dayIndex = dayIndex;
        this.newEvent = newEvent;
        this.title = newEvent.getTitle();
        this.startTime = newEvent.getStartTime();
        this.endTime = newEvent.getEndTime();
    }

    Event getNewEvent() {
        return newEvent;
    }

    String getTitle() {
        return title;
    }

    LocalTime getStartTime() {
        return startTime;
    }

    LocalTime getEndTime() {
        return endTime;
    }

    int getDayIndex() {
        return dayIndex;
    }

}
