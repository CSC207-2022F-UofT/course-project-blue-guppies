package create_event_use_case;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateEventScreen extends JPanel implements ActionListener {
    String day = "Sunday";
    JTextField title = new JTextField();
    JTextField startTime = new JTextField();
    JTextField endTime = new JTextField();

    public CreateEventScreen() {
        super(new GridBagLayout());

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

    @Override
    public void actionPerformed(ActionEvent evt) {
        if ("create".equals(evt.getActionCommand())) {
            System.out.println("create");
            // call controller
        }
        else if ("cancel".equals(evt.getActionCommand())) {
            System.out.println("cancel");
            this.setVisible(false);
            JOptionPane.showMessageDialog(this,"hello");
        }
        // user has clicked a radio button and the day variable should be updated
        else {
            day = evt.getActionCommand();
            System.out.println(day);
        }
    }
}
