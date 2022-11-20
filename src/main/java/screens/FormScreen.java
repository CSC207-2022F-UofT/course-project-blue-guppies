package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public abstract class FormScreen extends JFrame implements ActionListener, WindowListener {
    // Event title
    protected final JTextField title = new JTextField();
    protected FormScreen(String windowTitle) {
        super(windowTitle);
        this.addWindowListener(this);
    }

    protected GridBagConstraints initializeConstraints() {
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.BOTH; // use all available vertical and horizontal space

        // padding of 5 px on everything
        constraints.insets.top = 5;
        constraints.insets.bottom = 5;
        constraints.insets.left = 5;
        constraints.insets.right = 5;

        return constraints;
    }

    protected void addHeader(JPanel panel, GridBagConstraints constraints, String header) {
        // Add screen title to form
        constraints.gridy = 0; // row 0
        constraints.gridwidth = 7; // sets component to span 7 columns
        JLabel screenTitle = new JLabel(header, JLabel.CENTER);
        screenTitle.setFont(new Font(screenTitle.getFont().toString(), Font.BOLD, 16));
        screenTitle.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(screenTitle, constraints);
    }

    protected void addTitleField(JPanel panel, GridBagConstraints constraints, int rowIndex, String labelText) {
        JLabel titleLabel = new JLabel(labelText);
        // Add event title field and its label
        constraints.gridwidth = 1; // component spans 1 column
        constraints.gridy = rowIndex;
        constraints.gridx = 0; // col 0
        panel.add(titleLabel, constraints);
        constraints.gridwidth = 6; // component spans 6 columns
        constraints.gridx = 1; // col 1
        panel.add(title, constraints);
    }

    /**
     * Add create/save and cancel buttons to form
     * @param panel the JPanel the buttons will be added to
     * @param constraints the GridBagConstraints for the buttons
     * @param rowIndex the row of the form the buttons are to be added to
     * @param button1 the name of the left button, either modify or create
     */
    protected void addFormButtons(JPanel panel, GridBagConstraints constraints, int rowIndex, String button1) {
         // Create buttons and add action listeners
        JButton leftButton = new JButton(button1);
        leftButton.setActionCommand(button1);

        JButton cancel = new JButton("Cancel");
        cancel.setActionCommand("Cancel");

        leftButton.addActionListener(this);
        cancel.addActionListener(this);

        // Add buttons
        constraints.gridy = rowIndex;
        constraints.gridwidth = 5; // component spans 5 columns
        constraints.gridx = 0; // col 0
        panel.add(leftButton, constraints);
        constraints.gridx = 5; // col 5
        constraints.gridwidth = 2; // component spans 2 columns
        panel.add(cancel, constraints);
    }

    /**
     * Reset the form values to the default
     */
    protected abstract void resetForm();


    @Override
    public void windowOpened(WindowEvent e) {}

    /**
     * Invoked when the user attempts to close the window
     * from the window's system menu.
     *
     * @param e the event to be processed
     */
    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("\nx button");
        resetForm();
    }

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}


    @Override
    public void windowActivated(WindowEvent e) {}


    @Override
    public void windowDeactivated(WindowEvent e) {}
}
