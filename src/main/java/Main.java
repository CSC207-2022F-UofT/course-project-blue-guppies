import create_event_use_case.CreateEventScreen;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        JFrame application = new JFrame("Clean Calendar");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);
        CreateEventScreen createEventScreen = new CreateEventScreen();
        screens.add(createEventScreen, "welcome");
        cardLayout.show(screens, "create event");
        application.pack();
        application.setVisible(true);
    }
}
