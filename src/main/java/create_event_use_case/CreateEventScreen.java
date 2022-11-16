package create_event_use_case;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CreateEventScreen extends JPanel implements ActionListener, WindowListener {
    String day = "Sunday";
    JTextField title = new JTextField();
    JTextField startTime = new JTextField();
    JTextField endTime = new JTextField();

    JFrame window;

    public CreateEventScreen(JFrame frame) {
        super(new GridBagLayout());
        this.window = frame;
        window.addWindowListener(this);

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets.top = 5;
        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;

        // Add screen title to form
        constraints.gridy = 0;
        constraints.gridwidth = 7;
        JLabel screenTitle = new JLabel("Create a new event", JLabel.CENTER);
        screenTitle.setFont(new Font(screenTitle.getFont().toString(), Font.BOLD, 16));
        screenTitle.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.add(screenTitle, constraints);


        // Add radio buttons for day of the week to form

        // Create radio buttons for each day of the week with Sunday selected by default
        JRadioButton sundayButton = new JRadioButton("Sunday");
        sundayButton.setActionCommand("Sunday");
        sundayButton.setSelected(true);
        sundayButton.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

        JRadioButton mondayButton = new JRadioButton("Monday");
        mondayButton.setActionCommand("Monday");

        JRadioButton tuesdayButton = new JRadioButton("Tuesday");
        tuesdayButton.setActionCommand("Tuesday");

        JRadioButton wednesdayButton = new JRadioButton("Wednesday");
        wednesdayButton.setActionCommand("Wednesday");

        JRadioButton thursdayButton = new JRadioButton("Thursday");
        thursdayButton.setActionCommand("Thursday");

        JRadioButton fridayButton = new JRadioButton("Friday");
        fridayButton.setActionCommand("Friday");

        JRadioButton saturdayButton = new JRadioButton("Saturday");
        saturdayButton.setActionCommand("Saturday");
        saturdayButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));

        // Add action listeners to all radio buttons
        sundayButton.addActionListener(this);
        mondayButton.addActionListener(this);
        tuesdayButton.addActionListener(this);
        wednesdayButton.addActionListener(this);
        thursdayButton.addActionListener(this);
        fridayButton.addActionListener(this);
        saturdayButton.addActionListener(this);

        // Group the radio buttons together
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(sundayButton);
        radioGroup.add(mondayButton);
        radioGroup.add(tuesdayButton);
        radioGroup.add(wednesdayButton);
        radioGroup.add(thursdayButton);
        radioGroup.add(fridayButton);
        radioGroup.add(saturdayButton);

        // Add the radio buttons
        constraints.gridwidth = 1;
        constraints.gridy = 1;
        constraints.gridx = 0;
        this.add(sundayButton, constraints);
        constraints.gridx = 1;
        this.add(mondayButton, constraints);
        constraints.gridx = 2;
        this.add(tuesdayButton, constraints);
        constraints.gridx = 3;
        this.add(wednesdayButton, constraints);
        constraints.gridx = 4;
        this.add(thursdayButton, constraints);
        constraints.gridx = 5;
        this.add(fridayButton, constraints);
        constraints.gridx = 6;
        this.add(saturdayButton, constraints);


        // Add title, start time, and end time fields to form

        // Create labels for JTextFields and connect them to their JTextFields
        JLabel titleLabel = new JLabel("Event Title:");
        titleLabel.setLabelFor(title);
        JLabel startTimeLabel = new JLabel("Start time:");
        startTimeLabel.setLabelFor(startTime);
        JLabel endTimeLabel = new JLabel("End time:");
        endTimeLabel.setLabelFor(endTime);

        // Add padding
//        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));
//        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));


        // Add event title field and its label
        constraints.gridwidth = 1;
        constraints.gridy = 2;
        constraints.gridx = 0;
        this.add(titleLabel, constraints);
        constraints.gridwidth = 6;
        constraints.gridx = 1;
        this.add(title, constraints);

        // add start and end time and their labels
        constraints.gridwidth = 1;
        constraints.gridy = 3;
        constraints.gridx = 1;
        this.add(startTimeLabel, constraints);
        constraints.gridx = 4;
        this.add(endTimeLabel, constraints);
        constraints.gridwidth = 1;
        constraints.gridx = 2;
        this.add(startTime, constraints);
        constraints.gridx = 5;
        this.add(endTime, constraints);


        // Add create and cancel buttons to form

        // Create buttons and add action listeners
        JButton create = new JButton("Create");
        create.setActionCommand("create");

        JButton cancel = new JButton("Cancel");
        cancel.setActionCommand("cancel");


        create.addActionListener(this);
        cancel.addActionListener(this);

        // Add buttons
        constraints.gridy = 4;
        constraints.gridwidth = 5;
        constraints.gridx = 0;
        this.add(create, constraints);
        constraints.gridx = 5;
        constraints.gridwidth = 2;
        this.add(cancel, constraints);
    }

    /**
     * @param evt the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        if ("create".equals(evt.getActionCommand())) {
            System.out.println("create");
            System.out.println(title.getText());
            System.out.println(day);
            System.out.println(startTime.getText());
            System.out.println(endTime.getText());
            // call controller
            title.setText("");
            startTime.setText("");
            endTime.setText("");
        }
        else if ("cancel".equals(evt.getActionCommand())) {
            System.out.println("cancel");
            window.setVisible(false);
            title.setText("");
            startTime.setText("");
            endTime.setText("");
        }
        // user has clicked a radio button and the day variable should be updated
        else {
            day = evt.getActionCommand();
            System.out.println(day);
        }
    }

    /**
     * Invoked the first time a window is made visible.
     *
     * @param e the event to be processed
     */
    @Override
    public void windowOpened(WindowEvent e) {

    }

    /**
     * Invoked when the user attempts to close the window
     * from the window's system menu.
     *
     * @param e the event to be processed
     */
    @Override
    public void windowClosing(WindowEvent e) {
        // clear form
        title.setText("");
        startTime.setText("");
        endTime.setText("");
    }

    /**
     * Invoked when a window has been closed as the result
     * of calling dispose on the window.
     *
     * @param e the event to be processed
     */
    @Override
    public void windowClosed(WindowEvent e) {

    }

    /**
     * Invoked when a window is changed from a normal to a
     * minimized state. For many platforms, a minimized window
     * is displayed as the icon specified in the window's
     * iconImage property.
     *
     * @param e the event to be processed
     * @see Frame#setIconImage
     */
    @Override
    public void windowIconified(WindowEvent e) {

    }

    /**
     * Invoked when a window is changed from a minimized
     * to a normal state.
     *
     * @param e the event to be processed
     */
    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    /**
     * Invoked when the Window is set to be the active Window. Only a Frame or
     * a Dialog can be the active Window. The native windowing system may
     * denote the active Window or its children with special decorations, such
     * as a highlighted title bar. The active Window is always either the
     * focused Window, or the first Frame or Dialog that is an owner of the
     * focused Window.
     *
     * @param e the event to be processed
     */
    @Override
    public void windowActivated(WindowEvent e) {


    }

    /**
     * Invoked when a Window is no longer the active Window. Only a Frame or a
     * Dialog can be the active Window. The native windowing system may denote
     * the active Window or its children with special decorations, such as a
     * highlighted title bar. The active Window is always either the focused
     * Window, or the first Frame or Dialog that is an owner of the focused
     * Window.
     *
     * @param e the event to be processed
     */
    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
