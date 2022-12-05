package screens;

import clear_all_use_case.ClearAllController;
import clear_all_use_case.ClearAllOutputData;
import data_access.WeekDataAccess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * The screen for the main week view. Links all use cases together.
 * @author Anna Myllyniemi
 */
public class WeekViewScreen extends JFrame implements WindowListener, ActionListener, ViewModelObserver{
    private static final int HEIGHT = 550 / 2;
    private static final int WIDTH = 1100 / 7;
    private final Map<String, Object> controllers;
    private final Map<String, JFrame> screens;
    private final JPanel[][] panels = new JPanel[2][7];
    private final ViewModelBoundary viewModel;


    /**
     * Create the screen showing all tasks and events for every day of the week and all buttons for each use case.
     *
     * @param screens  Map of all the screens used throughout the program
     * @param controllers Map of all the controllers that need to be used directly from the WeekViewScreen
     */
    public WeekViewScreen(Map<String, JFrame> screens, Map<String, Object> controllers, ViewModelBoundary viewModel) {
        super();
        setTitle("Clean Calendar");
        addWindowListener(this);

        this.controllers = controllers;
        this.screens = screens;
        this.viewModel = viewModel;

        JPanel panel = new JPanel(new BorderLayout());

        //Create the toolbar.
        JToolBar toolBar = new JToolBar("Toolbar popout");
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

    @Override
    public void updateEventSectionOnDay(int dayIndex, ArrayList<String> eventTitles, ArrayList<String> startTimes,
                                        ArrayList<String> endTimes) {
        panels[1][dayIndex].removeAll();
        for (int i = 0; i < eventTitles.size(); i++) {
            JButton b = new JButton();
            b.setText(startTimes.get(i) + "-" + endTimes.get(i) + " " + eventTitles.get(i));
            b.addActionListener(this);
            b.setActionCommand(dayIndex + "event" + eventTitles.get(i));

            panels[1][dayIndex].add(b);
        }
        screens.get("click event").setVisible(false);
        SwingUtilities.updateComponentTreeUI(this);
    }

    @Override
    public void updateTaskSectionOnDay(int dayIndex, ArrayList<String> taskTitles,
                                       ArrayList<Boolean> taskCompletionStatuses) {
        panels[0][dayIndex].removeAll();
        for (int i = 0; i < taskTitles.size(); i++) {
            JButton b = new JButton(taskTitles.get(i));
            b.addActionListener(this);
            b.setActionCommand(dayIndex + "task" + taskTitles.get(i));

            // Make buttons for completed tasks have a lighter background and italicized font.
            if (taskCompletionStatuses.get(i)) {
                b.setBackground(new Color(240, 240, 240));
                Font italics = new Font (b.getFont().toString(), Font.ITALIC, b.getFont().getSize());
                b.setFont(italics);
            }
            panels[0][dayIndex].add(b);
        }
        screens.get("click task").setVisible(false);
        SwingUtilities.updateComponentTreeUI(this);
    }


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
            String eventTitle = e.getActionCommand().substring(6);
            int dayIndex = e.getActionCommand().charAt(0) - 48;
            ((ClickEventScreen)screens.get("click event")).setDayIndex(dayIndex);
            ((ClickEventScreen)screens.get("click event")).setStartTime(((ViewModel)viewModel).getEventStartTime(
                    dayIndex, eventTitle));
            System.out.println(((ViewModel)viewModel).getEventStartTime(
                    dayIndex, eventTitle));
            ((ClickEventScreen)screens.get("click event")).setEndTime(((ViewModel)viewModel).getEventEndTime(
                    dayIndex, eventTitle));
            ((ClickEventScreen)screens.get("click event")).setEventTitle(eventTitle);

            screens.get("click event").setVisible(true);
        } else if (e.getActionCommand().contains("task")) {
            String taskTitle = e.getActionCommand().substring(5);
            int dayIndex = e.getActionCommand().charAt(0) - 48;
            ((ClickTaskScreen)screens.get("click task")).setDayIndex(dayIndex);
            ((ClickTaskScreen)screens.get("click task")).setTaskCompleted(((ViewModel)viewModel).getTaskCompletion(
                    dayIndex, taskTitle));
            ((ClickTaskScreen)screens.get("click task")).setTaskTitle(taskTitle);

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
            try {
                WeekDataAccess.writeObject(WeekDataAccess.getDays());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
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
        // TODO uncomment line
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
