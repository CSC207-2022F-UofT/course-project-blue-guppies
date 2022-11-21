import create_event_use_case.*;
import data_access.DataAccess;
import entities.EventFactory;
import screens.CreateEventScreen;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        DataAccess gateway = new DataAccess();

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
        CreateEventScreen createEventScreen = new CreateEventScreen(createEventController);

        // add a button to create a new event
        JButton addEvent = new JButton("New Event");
        addEvent.addActionListener(e -> createEventScreen.setVisible(true));
        p.add(addEvent);

        createEventScreen.pack();
        createEventScreen.setVisible(false);
        calendarScreen.pack();
        calendarScreen.setVisible(true);


    }
}
