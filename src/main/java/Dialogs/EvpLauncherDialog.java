package Dialogs;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;

public class EvpLauncherDialog {

    static WindowsDriver driver;
    //private By

    public EvpLauncherDialog(WindowsDriver driver){ this.driver = driver;}

    public EvpHomeDialog clickEvpHomeDialog(){
        clickLink("");
        return new EvpHomeDialog(driver);
    }

    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

}
