package base;

import Dialogs.EvpLauncherDialog;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    static WindowsDriver driver;
    static WindowsDriver rootDriver;
    protected EvpLauncherDialog evpLauncherDialog;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "C:\\Etail\\Master\\Launcher\\AppLauncher.exe");
        capabilities.setCapability("deviceName", "ESV-QA-12");
        capabilities.setCapability("ms:waitForAppLaunch", "10");
        driver = new WindowsDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        evpLauncherDialog = new EvpLauncherDialog(driver);


    }



    //@AfterClass
    //public void tearDown() {driver.quit();}

    }



