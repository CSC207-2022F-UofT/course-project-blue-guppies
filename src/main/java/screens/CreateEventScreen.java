/**
 * Creates a screen with the form a user fills out when making a new event consisting of 7 radio
 * buttons representing the days of the week; text fields for the event title, start time, and
 * end time; and create and cancel buttons. When the user clicks either the window's x button or the
 * cancel button, the fields of the form reset in preparation for the next time the form is used and
 * the window is hidden.
 * Author: Anna Myllyniemi
 * Modified by: NA
 * Date created: Nov 14 2022
 * Last modified: Nov 15 2022
 */

package screens;

import create_event_use_case.CreateEventController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CreateEventScreen extends JPanel implements ActionListener, WindowListener {
    // Day of the week the user has currently selected
    private String day = "Sunday";

    // Event title
    private final JTextField title = new JTextField();

    // Start time of the event
    private final JTextField startTime = new JTextField();

    // End time of the event
    private final JTextField endTime = new JTextField();

    private final JFrame window;
    private final CreateEventController createEventController;

    /**
     * Creates a JPanel with 7 radio buttons, 3 JTextFields and their labels, and two JButtons
     * @param frame the JFrame the JPanel is going to be added to
     * @param controller the controller to call when the user hits the create button
     */
    public CreateEventScreen(JFrame frame, CreateEventController controller) {
        super(new GridBagLayout());
        this.window = frame;
        createEventController = controller;
        window.addWindowListener(this);

        // each row has 7 "columns"
        // rows and columns accessed similar to indexing

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.BOTH; // use all available vertical and horizontal space

        // padding of 5 px on everything
        constraints.insets.top = 5;
        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;

        // Add screen title to form
        constraints.gridy = 0; // row 0
        constraints.gridwidth = 7; // sets component to span 7 columns
        JLabel screenTitle = new JLabel("Create a new event", JLabel.CENTER);
        screenTitle.setFont(new Font(screenTitle.getFont().toString(), Font.BOLD, 16));
        screenTitle.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.add(screenTitle, constraints);


        // Add radio buttons for day of the week to form

        // Create radio buttons for each day of the week with Sunday selected by default
        JRadioButton sundayButton = new JRadioButton("Sunday");
        sundayButton.setActionCommand("Sunday");
        sundayButton.setSelected(true);

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
        constraints.gridwidth = 1; // each radio button takes 1 column
        constraints.gridy = 1; // row 1
        constraints.gridx = 0; // col 0
        this.add(sundayButton, constraints);
        constraints.gridx = 1; // col 1
        this.add(mondayButton, constraints);
        constraints.gridx = 2; // col 2
        this.add(tuesdayButton, constraints);
        constraints.gridx = 3; // col 3
        this.add(wednesdayButton, constraints);
        constraints.gridx = 4; // col 4
        this.add(thursdayButton, constraints);
        constraints.gridx = 5; // col 5
        this.add(fridayButton, constraints);
        constraints.gridx = 6; // col 6
        this.add(saturdayButton, constraints);


        // Add title, start time, and end time fields to form

        // Create labels for JTextFields and connect them to their JTextFields
        JLabel titleLabel = new JLabel("Event Title:");
        titleLabel.setLabelFor(title); // potentially related to accessibility if mnemonic key is also set
        JLabel startTimeLabel = new JLabel("Start time:");
        startTimeLabel.setLabelFor(startTime);
        JLabel endTimeLabel = new JLabel("End time:");
        endTimeLabel.setLabelFor(endTime);

        // Add event title field and its label
        constraints.gridwidth = 1; // component spans 1 column
        constraints.gridy = 2; // row 2
        constraints.gridx = 0; // col 0
        this.add(titleLabel, constraints);
        constraints.gridwidth = 6; // component spans 6 columns
        constraints.gridx = 1; // col 1
        this.add(title, constraints);

        // add start and end time and their labels
        constraints.gridwidth = 1; // component spans 1 column
        constraints.gridy = 3; // row 3
        constraints.gridx = 1; // col 1
        this.add(startTimeLabel, constraints);
        constraints.gridx = 4; // col 4
        this.add(endTimeLabel, constraints);
        constraints.gridx = 2; // col 2
        this.add(startTime, constraints);
        constraints.gridx = 5; // col 5
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
        constraints.gridy = 4; // row 4
        constraints.gridwidth = 5; // component spans 5 columns
        constraints.gridx = 0; // col 0
        this.add(create, constraints);
        constraints.gridx = 5; // col 5
        constraints.gridwidth = 2; // component spans 2 columns
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
            createEventController.create(day, title.getText(), startTime.getText(), endTime.getText());

            // clear fields in form (only if successful)
            // add success check etc.
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
        // user has clicked a radio button and the day variable should be updated to reflect it
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
