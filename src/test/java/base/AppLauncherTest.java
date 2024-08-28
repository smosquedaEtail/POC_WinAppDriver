package base;

import io.appium.java_client.MobileBy;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Set;
import java.util.function.Function;

public class AppLauncherTest extends BaseTest{

    @Test
    public void testAppLaucher() throws MalformedURLException {
        WebDriverWait wait1 = new WebDriverWait(driver, 15);
        wait1.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("MainForm1")));
        Actions move = new Actions(driver);
        move.moveToElement(driver.findElementByName("Merchant row 0")).perform();
        move.moveByOffset(122,0).perform();
        move.click().perform();
        WebDriverWait wait2 = new WebDriverWait(driver, 25);
        wait2.until((Function<WebDriver, Boolean>) webDriver -> {
            try {
                Thread.sleep(25000); // Sleep for 25 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true; // Condition is met after sleep
        });
        move.moveToElement(driver.findElementByName("Close")).click().perform();

        DesiredCapabilities desktopCapabilities = new DesiredCapabilities();
        desktopCapabilities.setCapability("platformName", "Windows");
        desktopCapabilities.setCapability("deviceName", "WindowsPC");
        desktopCapabilities.setCapability("app", "Root");

        WindowsDriver desktopSession = new WindowsDriver(new URL("http://127.0.0.1:4723/wd/hub"), desktopCapabilities);
        WebElement BHWebElement = desktopSession.findElementByName("Etail Vantage Platform - EVP - By Etail Solutions");
        String EvpWinHandleStr = BHWebElement.getAttribute("NativeWindowHandle");
        int EvpWinHandleInt = Integer.parseInt(EvpWinHandleStr);
        String EvpWinHandleHex = Integer.toHexString(EvpWinHandleInt);

        DesiredCapabilities EvpCapabilities = new DesiredCapabilities();
        EvpCapabilities.setCapability("platformName", "Windows");
        EvpCapabilities.setCapability("deviceName", "WindowsPC");
        EvpCapabilities.setCapability("appTopLevelWindow", EvpWinHandleHex);
        System.out.println("Evp Handle is: " + EvpWinHandleHex);

        WindowsDriver EvpSession = new WindowsDriver(new URL("http://127.0.0.1:4723/wd/hub"), EvpCapabilities);

        System.out.println(EvpSession.findElementByAccessibilityId("splitContainerControl1").getText());


    }
}
