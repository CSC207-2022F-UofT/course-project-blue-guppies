import clear_all_use_case.ClearAllController;
import complete_task_use_case.CompleteTaskController;
import create_event_use_case.*;
import create_task_use_case.CreateTaskController;
import data_access.DataAccess;
import delete_event_use_case.DeleteEventController;
import delete_task_use_case.DeleteTaskController;
import entities.EventFactory;
import modify_event_use_case.ModifyEventController;
import modify_task_use_case.*;
import screens.*;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // TODO Initialize all use cases
        // TODO Initialize all screens
        DataAccess gateway = new DataAccess();

        // initialize create event classes
        CreateEventOutputBoundary createEventPresenter = new CreateEventPresenter();
        EventFactory eventFactory = new EventFactory();
        CreateEventInputBoundary createEventInteractor = new CreateEventInteractor(
                gateway, createEventPresenter, eventFactory);
        CreateEventController createEventController = new CreateEventController(createEventInteractor);

        // initialize modify event classes
        ModifyEventController modifyEventController = new ModifyEventController();

        // initialize delete event classes
        DeleteEventController deleteEventController = new DeleteEventController();

        // initialize create task classes
        CreateTaskController createTaskController = new CreateTaskController();

        // initialize modify task classes
        ModifyTaskOutputBoundary modifyTaskPresenter = new ModifyTaskPresenter();
        ModifyTaskDataAccess dsGateway = new ModifyTaskDataAccess();
        ModifyTaskInputBoundary modifyTaskInteractor = new ModifyTaskInteractor(modifyTaskPresenter, dsGateway);
        ModifyTaskController modifyTaskController = new ModifyTaskController(modifyTaskInteractor);

        // initialize delete task classes
        DeleteTaskController deleteTaskController = new DeleteTaskController();

        // initialize complete task classes
        CompleteTaskController completeTaskController = new CompleteTaskController();

        // initialize clear all tasks and events classes
        ClearAllController clearAllController = new ClearAllController();

        // initialize the screens
        CreateEventScreen createEventScreen = new CreateEventScreen(createEventController);
        CreateTaskScreen createTaskScreen = new CreateTaskScreen(createTaskController);
        ModifyTaskScreen modifyTaskScreen = new ModifyTaskScreen(modifyTaskController);
        ModifyEventScreen modifyEventScreen = new ModifyEventScreen(modifyEventController);
        ClickTaskScreen taskMenu = new ClickTaskScreen(modifyTaskScreen, deleteTaskController, completeTaskController);
        ClickEventScreen eventMenu = new ClickEventScreen(modifyEventScreen, deleteEventController);

        // could move below lines to their constructors
        createEventScreen.pack();
        createEventScreen.setVisible(false);
        createTaskScreen.pack();
        createTaskScreen.setVisible(false);
        modifyTaskScreen.pack();
        modifyTaskScreen.setVisible(false);
        modifyEventScreen.pack();
        modifyEventScreen.setVisible(false);
        taskMenu.pack();
        taskMenu.setVisible(false);
        eventMenu.pack();
        eventMenu.setVisible(false);

        Map<String, JFrame> screens = new HashMap<>();
        Map<String, Object>  controllers = new HashMap<>();

        controllers.put("clear all", clearAllController);

        screens.put("create event", createEventScreen);
        screens.put("create task", createTaskScreen);
        screens.put("modify event", modifyEventScreen);
        screens.put("modify task", modifyTaskScreen);
        screens.put("click task", taskMenu);
        screens.put("click event", eventMenu);

        WeekViewScreen view = new WeekViewScreen(screens, controllers);
        System.out.println("event 6 11:30 01:30 event title");
        System.out.println("task 3 task title");
//
//        // create calendar screen
//        JFrame calendarScreen = new JFrame("Clean Calendar");
//        calendarScreen.setLayout(new BorderLayout());
//        JPanel p = new JPanel();
//        p.add(new JLabel("To become the main calendar view"));
//        calendarScreen.add(p, BorderLayout.CENTER);
//        calendarScreen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//
//        // add a button to create a new event
//        JButton addEvent = new JButton("New Event");
//        addEvent.addActionListener(e -> createEventScreen.setVisible(true));
//        p.add(addEvent);
//
//        // add a button to create a new task
//        JButton addTask = new JButton("New Task");
//        addTask.addActionListener(e -> createTaskScreen.setVisible(true));
//        p.add(addTask);
//
//        // add a button ot modify a task.
//        JButton modifyTask = new JButton("Modify Task");
//        modifyTaskScreen.setDay(0);
//        modifyTaskScreen.setOldTitle("clean house");
//        modifyTask.addActionListener(e -> modifyTaskScreen.setVisible(true));
//        p.add(modifyTask);
//
//
//        JButton openTaskMenu = new JButton("Task menu");
//        taskMenu.setTaskTitle("clean house");
//        taskMenu.setDayId(0);
//        openTaskMenu.addActionListener(e -> taskMenu.setVisible(true));
//        p.add(openTaskMenu);
//        calendarScreen.pack();
//        calendarScreen.setVisible(true);



    }
}
