package activities.whenDo;

import controlAppium.Button;
import org.openqa.selenium.By;

public class DeleteTaskScreen {
    public Button deleteButton= new Button(By.id("com.vrproductiveapps.whendo:id/deleteItem"));
    public Button confirmDeleteButton= new Button(By.id("android:id/button1"));

}
