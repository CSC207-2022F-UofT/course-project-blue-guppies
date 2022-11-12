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

    JPasswordField startTime = new JPasswordField(15);
    JPasswordField endTime = new JPasswordField(15);

    public CreateEventScreen() {
        JLabel screenTitle = new JLabel("Create Event Screen");
        screenTitle.setAlignmentX(Component.CENTER_ALIGNMENT);


        ButtonGroup group = new ButtonGroup();
        group.add(sundayButton);
        group.add(mondayButton);
        group.add(tuesdayButton);
        group.add(wednesdayButton);
        group.add(thursdayButton);
        group.add(fridayButton);
        group.add(saturdayButton);

        sundayButton.addActionListener(this);
        mondayButton.addActionListener(this);
        tuesdayButton.addActionListener(this);
        wednesdayButton.addActionListener(this);
        thursdayButton.addActionListener(this);
        fridayButton.addActionListener(this);
        saturdayButton.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(sundayButton);
        this.add(mondayButton);
        this.add(tuesdayButton);
        this.add(wednesdayButton);
        this.add(thursdayButton);
        this.add(fridayButton);
        this.add(saturdayButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("yo yo yo");
    }

}
