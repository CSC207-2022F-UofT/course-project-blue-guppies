package create_event_use_case;

import entities.Event;

import java.time.LocalTime;

class CreateEventDsInputData {
    private final String title;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final int dayIndex;
    private final Event newEvent;

    /**
     * Data passed into the DsGateway containing relevent information for storing the new Event into the data access.
     *
     * @param title The title of the Event
     * @param startTime The start time of the Event
     * @param endTime The end time of the Event
     * @param dayIndex The index of the day the Event occurs on
     * @param newEvent The actual Event entity
     */
    CreateEventDsInputData(String title, LocalTime startTime, LocalTime endTime, int dayIndex, Event newEvent) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dayIndex = dayIndex;
        this.newEvent = newEvent;
    }

    // use this constructor once DataAccessEvent is refactored to be Event
//    /**
//     * Data passed into the DsGateway containing relevant information for adding the new Event into the data access.
//     *
//     * @param dayIndex The index of the day the Event occurs on
//     * @param newEvent The actual Event entity
//     */
//    CreateEventDsInputData(int dayIndex, Event newEvent) {
//        this.dayIndex = dayIndex;
//        this.newEvent = newEvent;
//    }

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
