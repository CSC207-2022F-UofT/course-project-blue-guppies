import create_event_use_case.CreateEventScreen;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // create calendar screen
        JFrame calendarScreen = new JFrame("Clean Calendar");
        calendarScreen.setLayout(new BorderLayout());
        JPanel p = new JPanel();
        p.add(new JLabel("To become the main calendar view"));
        calendarScreen.add(p, BorderLayout.CENTER);
        calendarScreen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // initialize the create event screen
        JFrame createEventScreenFrame = new JFrame("Create Event");
        CreateEventScreen createEventScreenPanel = new CreateEventScreen(createEventScreenFrame);
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
