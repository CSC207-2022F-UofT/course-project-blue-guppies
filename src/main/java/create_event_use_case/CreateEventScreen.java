package create_event_use_case;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.showMessageDialog;

public class CreateEventScreen extends JPanel implements ActionListener{
    JRadioButton sundayButton = new JRadioButton("Sunday");
    JRadioButton mondayButton = new JRadioButton("Monday");
    JRadioButton tuesdayButton = new JRadioButton("Tuesday");
    JRadioButton wednesdayButton = new JRadioButton("Wednesday");
    JRadioButton thursdayButton = new JRadioButton("Thursday");
    JRadioButton fridayButton = new JRadioButton("Friday");
    JRadioButton saturdayButton = new JRadioButton("Saturday");

    JTextField title = new JTextField(15);

    JTextField startTime = new JTextField(15);
    JTextField endTime = new JTextField(15);

    public CreateEventScreen() {
        JLabel screenTitle = new JLabel("Create a new event");
        screenTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton cancel = new JButton("Cancel");
        JButton create = new JButton("Create");

        JLabel titleLabel = new JLabel("Task Title:");
        JLabel startTimeLabel = new JLabel("Start time:");
        JLabel endTimeLabel = new JLabel("End time:");

        JPanel buttons = new JPanel();
        buttons.add(create);
        buttons.add(cancel);

        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(sundayButton);
        radioGroup.add(mondayButton);
        radioGroup.add(tuesdayButton);
        radioGroup.add(wednesdayButton);
        radioGroup.add(thursdayButton);
        radioGroup.add(fridayButton);
        radioGroup.add(saturdayButton);

//        sundayButton.addActionListener(this);
//        mondayButton.addActionListener(this);
//        tuesdayButton.addActionListener(this);
//        wednesdayButton.addActionListener(this);
//        thursdayButton.addActionListener(this);
//        fridayButton.addActionListener(this);
//        saturdayButton.addActionListener(this);
        create.addActionListener(this);
        cancel.addActionListener(this);

        this.add(screenTitle);
        this.add(sundayButton);
        this.add(mondayButton);
        this.add(tuesdayButton);
        this.add(wednesdayButton);
        this.add(thursdayButton);
        this.add(fridayButton);
        this.add(saturdayButton);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(titleLabel);
        this.add(title);
        this.add(startTimeLabel);
        this.add(startTime);
        this.add(endTimeLabel);
        this.add(endTime);
        this.add(create);
        this.add(cancel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("yo yo yo");
    }

}
