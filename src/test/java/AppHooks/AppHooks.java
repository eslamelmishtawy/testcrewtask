package AppHooks;

import com.driverfactory.DriverFactory;
import com.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class AppHooks {
    private DriverFactory driverFactory;
    private ConfigReader configReader;
    private WebDriver driver;
    Properties p;

    @Before(order = 0)
    public void getProperty(){
        configReader = new ConfigReader();
        p = configReader.init_prop();
    }
    @Before(order = 1)
    public void launchBrowser(){
        String browser = p.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browser);
    }

    @After(order = 0)
    public void quitBrowser(){
        driver.quit();
    }
    @After(order = 1)
    public void tearDown(Scenario sc) {
        if (sc.isFailed()) {
            //take screenshot
            String screenshotName = sc.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            sc.attach(sourcePath, "image/png", screenshotName);

        }
    }

}
