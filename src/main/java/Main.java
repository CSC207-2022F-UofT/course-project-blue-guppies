import create_event_use_case.*;
import entities.EventFactory;
import screens.CreateEventScreen;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        CreateEventDsGateway gateway = new CreateEventDataAccess();

        // initialize create event classes
        CreateEventOutputBoundary createEventPresenter = new CreateEventPresenter();
        EventFactory eventFactory = new EventFactory();
        CreateEventInputBoundary createEventInteractor = new CreateEventInteractor(
                gateway, createEventPresenter, eventFactory);
        CreateEventController createEventController = new CreateEventController(createEventInteractor);


        // create calendar screen
        JFrame calendarScreen = new JFrame("Clean Calendar");
        calendarScreen.setLayout(new BorderLayout());
        JPanel p = new JPanel();
        p.add(new JLabel("To become the main calendar view"));
        calendarScreen.add(p, BorderLayout.CENTER);
        calendarScreen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // initialize the create event screen
        JFrame createEventScreenFrame = new JFrame("Create Event");
        CreateEventScreen createEventScreenPanel = new CreateEventScreen(createEventScreenFrame,
                createEventController);
        createEventScreenFrame.add(createEventScreenPanel);

        // add a button to create a new event
        JButton addEvent = new JButton("New Event");
        addEvent.addActionListener(e -> createEventScreenFrame.setVisible(true));
        p.add(addEvent);

        createEventScreenFrame.pack();
        createEventScreenFrame.setVisible(false);
        calendarScreen.pack();
        calendarScreen.setVisible(true);


    }
}
