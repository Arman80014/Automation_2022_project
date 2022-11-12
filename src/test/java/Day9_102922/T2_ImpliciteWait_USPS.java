package Day9_102922;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class T2_ImpliciteWait_USPS {

    public static void main(String[] args) {


        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing the chrome window
        options.addArguments("start-maximized", "incognito");
        //options.addArguments("headless");
        //options.addArguments("start-fullscreen");
        //define the webdriver and pass the options into the
        //define the chrome driver to use for your test
        //creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //navigate to usps home page
        driver.navigate().to("https://www.usps.com");


        //hover over to Send tab
        WebElement sendTab = driver.findElement(By.xpath("//*[@id='mail-ship-width']"));
        //declare mouse actions
        Actions actions = new Actions(driver);
        //always end with .perform()
        actions.moveToElement(sendTab).perform();


        //click on calculate a price using mouse click
        WebElement calculatePrice = driver.findElement(By.xpath("//li[@class='tool-calc']"));
        actions.moveToElement(calculatePrice).click().perform();


        //store ups home element as webElement
        WebElement uspsHome = driver.findElement(By.xpath("//*[@alt='USPS.com home']"));
        //right- clicking on usps hpome logo
        actions.moveToElement(uspsHome).contextClick().perform();
        //double clicking usps home page
        actions.moveToElement(uspsHome).doubleClick().perform();


    }//main
}//class