package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public WebDriver initialDriver()
    {
      WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();


       //Important NOTE:
      //As of now(during test case prepartion phase), we will put implicit wait
      //Later we will use explicit wait using WebdriverWait in the Base Page
      //Never mix implicit wait with explicit wait
      //To get started, during initial scripting, use implicit wait, it just checks the presence of element in the DOM,
      //implicit waits doesnot check other things like visibility of elem, whether elem can interact etc

        // Action item: We will refactor implicit to explicit time later.
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      return driver;
    }
}
