import create_event_use_case.CreateEventScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame application = new JFrame("Clean Calendar");
        JPanel calendarScreen = new JPanel();

        CreateEventScreen createEventScreen = new CreateEventScreen();

        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        screens.add(createEventScreen, "welcome");

        JButton addEvent = new JButton("New Event");
        addEvent.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                cardLayout.show(screens, "create event");
            }
        });

        application.pack();
        application.setVisible(true);


    }
}
