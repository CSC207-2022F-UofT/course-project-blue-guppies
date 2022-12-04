package screens;

import clear_all_use_case.ClearAllController;
import clear_all_use_case.ClearAllOutputData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Map;

/**
 * The screen for the main week view. Links all use cases together.
 * @author Anna Myllyniemi
 */
public class WeekViewScreen extends JFrame implements WindowListener, ActionListener {
    private static final int HEIGHT = 550 / 2;
    private static final int WIDTH = 1100 / 7;
    private final Map<String, Object> controllers;
    private final Map<String, JFrame> screens;
    private final JPanel[][] panels = new JPanel[2][7];


    /**
     * Create the screen showing all tasks and events for every day of the week and all buttons for each use case.
     *
     * @param screens  Map of all the screens used throughout the program
     * @param controllers Map of all the controllers that need to be used directly from the WeekViewScreen
     */
    public WeekViewScreen(Map<String, JFrame> screens, Map<String, Object> controllers) {
        super();
        setTitle("Clean Calendar");
        addWindowListener(this);

        this.controllers = controllers;
        this.screens = screens;

        JPanel panel = new JPanel(new BorderLayout());

        //Create the toolbar.
        JToolBar toolBar = new JToolBar("Still draggable");
        addButtons(toolBar);

        // Set up the main part of the panel with each day of the week and its tasks and event boxes.
        JPanel dayBoxes = setupDayBoxes();
        JPanel weekDayLabels = setupWeekDayLabels();
        JPanel weekDayBoxesAndLabels = new JPanel(new BorderLayout());
        weekDayBoxesAndLabels.add(weekDayLabels, BorderLayout.NORTH);
        weekDayBoxesAndLabels.add(dayBoxes, BorderLayout.CENTER);

        JPanel rowLabels = setupRowLabels();

        setupDummyEventsAndTasks();

        //Lay out the main panel.
        panel.add(toolBar, BorderLayout.PAGE_START);
        panel.add(weekDayBoxesAndLabels, BorderLayout.CENTER);
        panel.add(rowLabels, BorderLayout.WEST);
        this.add(panel);
    }

    private static JPanel setupRowLabels() {
        JPanel rowLabels = new JPanel(new GridLayout(2, 1));

        JPanel taskLabelHolder = new JPanel(new BorderLayout());
        JLabel tasksLabel = new JLabel("TASKS", SwingConstants.CENTER);
        taskLabelHolder.add(tasksLabel, BorderLayout.CENTER);
        rowLabels.add(taskLabelHolder);

        JPanel eventLabelHolder = new JPanel(new BorderLayout());
        JLabel eventLabel = new JLabel("EVENTS", SwingConstants.CENTER);
        eventLabelHolder.add(eventLabel, BorderLayout.CENTER);

        rowLabels.add(eventLabelHolder);
        return rowLabels;
    }

    private JPanel setupWeekDayLabels() {
        JPanel weekDayLabels = new JPanel(new GridLayout(1, 7));
        weekDayLabels.setPreferredSize(new Dimension(WIDTH * 7, 15));
        weekDayLabels.add(new JLabel("SUNDAY", SwingConstants.CENTER));
        weekDayLabels.add(new JLabel("MONDAY", SwingConstants.CENTER));
        weekDayLabels.add(new JLabel("TUESDAY", SwingConstants.CENTER));
        weekDayLabels.add(new JLabel("WEDNESDAY", SwingConstants.CENTER));
        weekDayLabels.add(new JLabel("THURSDAY", SwingConstants.CENTER));
        weekDayLabels.add(new JLabel("FRIDAY", SwingConstants.CENTER));
        weekDayLabels.add(new JLabel("SATURDAY", SwingConstants.CENTER));
        return weekDayLabels;
    }

    private JPanel setupDayBoxes() {
        JPanel week = new JPanel(new GridLayout(2, 7));
        for (int i = 0; i < panels.length; i++) {
            for (int j = 0; j < panels[i].length; j++) {
                JPanel halfDay = new JPanel();
                halfDay.setLayout(new BoxLayout(halfDay, BoxLayout.Y_AXIS));
                if (i == 0) {
                    halfDay.setBackground(new Color(245, 255 - j * 2, 255));
                } else {
                    halfDay.setBackground(new Color(255, 255 - j * 2, 240));
                }
                halfDay.setAutoscrolls(true);
                halfDay.setBorder(BorderFactory.createLineBorder(Color.black));
                panels[i][j] = halfDay;
                JScrollPane scrollPane = new JScrollPane(halfDay);
                scrollPane.setPreferredSize(new Dimension(WIDTH, HEIGHT));
                week.add(scrollPane);
            }
        }
        return week;
    }

    /**
     * This method is temporary and should be replaced with one that populates it with tasks and events from a
     * ViewModel.
     */
    private void setupDummyEventsAndTasks() {
        for (int j = 0; j < panels[0].length; j++) {
            for (int k = 0; k < 20; k++) {
                JButton b = new JButton("task " + k);
                b.addActionListener(this);
                b.setActionCommand("task " + j + " 0 task " + k);
                panels[0][j].add(b);
            }
        }
        for (int j = 0; j < panels[1].length; j++) {
            for (int k = 0; k < 20; k++) {
                JButton b = new JButton("11:30-15:30 lunch");
                b.addActionListener(this);
                b.setActionCommand("event " + j + " 11:30 15:30 event " + k);
                panels[1][j].add(b);
            }
        }
    }

    /* TODO write a method that populates the screen with all the tasks and events on startup.
        Probably call this method from the constructor.
     */

    /*
    TODO write a method that updates a specific box.
     probably remove all the buttons from the JPanel and then get all the [tasks or events] for that day and
     make new buttons. this would be called when the observer is made aware of a change to the view model.
     completed tasks should have their button background changed to grey or strikethrough the text, or both.

     */

    // when a change happens set clickTaskScreen and clickEventScreen to not visible.

    private void addButtons(JToolBar toolBar) {
        JButton newTask = new JButton("New Task");
        newTask.addActionListener(this);
        newTask.setActionCommand("create task");
        toolBar.add(newTask);

        JButton newEvent = new JButton("New Event");
        newEvent.addActionListener(this);
        newEvent.setActionCommand("create event");
        toolBar.add(newEvent);

        JButton clear = new JButton("Clear Week");
        clear.addActionListener(this);
        clear.setActionCommand("clear all");
        toolBar.add(clear);
    }


    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("create event")) {
            screens.get("create event").setVisible(true);
        } else if (e.getActionCommand().equals("create task")) {
            screens.get("create task").setVisible(true);
        } else if (e.getActionCommand().equals("clear all")) {
            int confirmed = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to clear this week?", "Clear Week Message Box",
                    JOptionPane.YES_NO_OPTION);

            if (confirmed == JOptionPane.YES_OPTION) {
                ClearAllOutputData outputData = ((ClearAllController)controllers.get("clear all")).clearAll();
                if (outputData.getSuccess()) {
                    JOptionPane.showMessageDialog(new JFrame(), "Week cleared");
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Error. Please try again");

                }

            }
        } else if (e.getActionCommand().contains("event")) {

            // the following should be later changed to get all these values from the view model but at present they are
            // encoded in a string that is saved as the action command for a task or event.
            ((ClickEventScreen)screens.get("click event")).setDayIndex(e.getActionCommand().charAt(6) - 48);
            ((ClickEventScreen)screens.get("click event")).setStartTime(e.getActionCommand().substring(8,13));
            ((ClickEventScreen)screens.get("click event")).setEndTime(e.getActionCommand().substring(14,19));
            ((ClickEventScreen)screens.get("click event")).setEventTitle(e.getActionCommand().substring(20));

            screens.get("click event").setVisible(true);
        } else if (e.getActionCommand().contains("task")) {
            ((ClickTaskScreen)screens.get("click task")).setDayIndex(e.getActionCommand().charAt(5) - 48);
            ((ClickTaskScreen)screens.get("click task")).setTaskCompleted(
                    Boolean.parseBoolean(e.getActionCommand().substring(7, 8)));
            ((ClickTaskScreen)screens.get("click task")).setTaskTitle(e.getActionCommand().substring(9));

            screens.get("click task").setVisible(true);
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
        int confirmed = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to exit the program?", "Exit Program Message Box",
                JOptionPane.YES_NO_OPTION);

        if (confirmed == JOptionPane.YES_OPTION) {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
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