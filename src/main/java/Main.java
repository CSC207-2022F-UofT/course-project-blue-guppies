import clear_all_use_case.ClearAllController;
import complete_task_use_case.CompleteTaskController;
import create_event_use_case.*;
import create_task_use_case.*;
import data_access.DataAccess;
import delete_event_use_case.DeleteEventController;
import delete_task_use_case.*;
import entities.EventFactory;
import entities.TaskFactory;
import modify_event_use_case.ModifyEventController;
import modify_task_use_case.*;
import screens.*;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // TODO Document everything
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
        CreateTaskOutputBoundary createTaskOutputBoundary = new CreateTaskPresenter();
        CreateTaskDsGateway createTaskDsGateway = new CreateTaskDataAccess();
        TaskFactory taskFactory = new TaskFactory();
        CreateTaskInputBoundary createTaskInputBoundary = new CreateTaskInteractor(taskFactory,
                createTaskOutputBoundary, createTaskDsGateway);
        CreateTaskController createTaskController = new CreateTaskController(createTaskInputBoundary);

        // initialize modify task classes
        ModifyTaskOutputBoundary modifyTaskPresenter = new ModifyTaskPresenter();
        ModifyTaskDataAccess dsGateway = new ModifyTaskDataAccess();
        ModifyTaskInputBoundary modifyTaskInteractor = new ModifyTaskInteractor(modifyTaskPresenter, dsGateway);
        ModifyTaskController modifyTaskController = new ModifyTaskController(modifyTaskInteractor);

        // initialize delete task classes
        DeleteTaskOutputBoundary deleteTaskOutputBoundary = new DeleteTaskPresenter();
        DeleteTaskDsGateway deleteTaskDsGateway = new DeleteTaskDataAccess();
        DeleteTaskInputBoundary deleteTaskInteractor = new DeleteTaskInteractor(deleteTaskOutputBoundary,
                deleteTaskDsGateway);
        DeleteTaskController deleteTaskController = new DeleteTaskController(deleteTaskInteractor);

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
        view.pack();
        view.setVisible(true);

    }
}
