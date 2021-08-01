package cleanTest;

import activities.whenDo.CreateTaskScreen;
import activities.whenDo.DeleteTaskScreen;
import activities.whenDo.MainScreen;

import activities.whenDo.UpdateTaskScreen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session.Session;

import java.net.MalformedURLException;

public class WhenDoTest {

    private MainScreen mainScreen= new MainScreen();
    private CreateTaskScreen createTaskScreen= new CreateTaskScreen();
    private UpdateTaskScreen updateTaskScreen= new UpdateTaskScreen();
    private DeleteTaskScreen deleteTaskScreen= new DeleteTaskScreen();


    @Test
    public void verifyCreateTask() throws MalformedURLException {
        String title="CLEAN";
        mainScreen.addTaskButton.click();
        createTaskScreen.titleTextBox.SetValue(title);
        createTaskScreen.descriptionTextBox.SetValue("this is a description");
        createTaskScreen.saveButton.click();
        Assertions.assertEquals(title,mainScreen.nameTaskLabel.getText(),"ERROR! task was not created");
    }
    @Test
    public void verifyUpdateTask() throws MalformedURLException {
        String titleCrear="CREATE";
        String titleUpdate="UPDATE";
        mainScreen.addTaskButton.click();
        createTaskScreen.titleTextBox.SetValue(titleCrear);
        createTaskScreen.descriptionTextBox.SetValue("this is a description");
        createTaskScreen.saveButton.click();
        mainScreen.nameTaskLabel.click();
        updateTaskScreen.titleTextBox.SetValue(titleUpdate);
        updateTaskScreen.saveButton.click();
        Assertions.assertEquals(titleUpdate,mainScreen.nameTaskLabel.getText(),"ERROR! task was not update");
    }

    @Test
    public void verifyDeleteTask() throws MalformedURLException {
        String title="PARA BORRAR";
        mainScreen.addTaskButton.click();
        createTaskScreen.titleTextBox.SetValue(title);
        createTaskScreen.descriptionTextBox.SetValue("this is a description");
        createTaskScreen.saveButton.click();
        mainScreen.nameTaskLabel.click();
        deleteTaskScreen.deleteButton.click();
        deleteTaskScreen.confirmDeleteButton.click();
        Assertions.assertFalse(mainScreen.nameTaskLabel.getFindElement(), "ERROR! task was not delete");
    }


    @AfterEach
    public void close() throws MalformedURLException {
        Session.getInstance().closeSession();
    }
}