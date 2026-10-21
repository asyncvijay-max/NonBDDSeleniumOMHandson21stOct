package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public WebDriver initialDriver()
    {
        WebDriver driver;

        // mvn clean test -Dbrowser=chrome (pass browser as System property via CL)
        //if not provided,the value "chrome" is picked by default

        String browserType = System.getProperty("browser","chrome");

        switch(browserType.toLowerCase())
        {
            case "chrome" ->
            {
                WebDriverManager.chromedriver().setup();
                 driver = new ChromeDriver();
                break;
            }

            case "firefox" ->
            {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }

            default -> throw new IllegalStateException("Invalid browser");


        }


        // Action item: We will refactor implicit to explicit time later.
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       driver.manage().window().maximize();

      return driver;
    }
}

//Important NOTE:
//As of now(during test case prepartion phase), we will put implicit wait
//Later we will use explicit wait using WebdriverWait in the Base Page
//Never mix implicit wait with explicit wait
//To get started, during initial scripting, use implicit wait, it just checks the presence of element in the DOM,
//implicit waits doesnot check other things like visibility of elem, whether elem can interact etc


