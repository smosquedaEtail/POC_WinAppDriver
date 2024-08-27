package base;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Iterator;

public class AppLauncherTest extends BaseTest{

    @Test
    public void testAppLaucher(){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("MainForm1")));
        System.out.println(driver.findElementByAccessibilityId("MainForm1").getText());
        System.out.println(driver.findElementByName("Merchant row 0").getText());
        Actions move = new Actions(driver);
        move.moveToElement(driver.findElementByName("Merchant row 0")).perform();
        move.moveByOffset(122,0).perform();
        String mwh=driver.getWindowHandle();
        move.click().perform();
        var allWindowHandles = driver.getWindowHandles();


        var ite= new Iterator<>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        };
        while(ite.hasNext()){
            String popUpHandle = ite.next().toString();
            if(!popUpHandle.contains(mwh)){
               driver.switchTo().window(popUpHandle);
            }
        }



        







    }
}
