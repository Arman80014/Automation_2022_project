package Day7_102222;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T1_Select_Statement {
    public static void main(String[] args) throws InterruptedException {
//setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing the chrome window
        options.addArguments("start-maximized","incognito");
//        options.addArguments("headless");
        //for mac use "start-fullscreen"
//        options.addArguments("start-fullscreen");
        //define the webdriver and pass the options into the method
        WebDriver driver = new ChromeDriver(options);
//go to google page
        driver.navigate().to("https://www.mlcalc.com");

        //wait few seconds
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Show advanced options']")).click();
        Thread.sleep(2000);

        //use select command for month dropdown
        WebElement startMonth = driver.findElement(By.xpath("//*[@name='sm']"));
        Select startMonthDropDown = new Select(startMonth);
        //select by visible text
        startMonthDropDown.selectByVisibleText("Nov");
        //use select command for year
        WebElement startYear = driver.findElement(By.xpath("//*[@name='sy']"));
        Select startYearDropDown = new Select(startYear);
        startYearDropDown.selectByVisibleText("2023");



       // driver.findElement(By.xpath("//*[@name='sy']")).click();
        //driver.findElement(By.xpath("//*[text()='2023']")).click();


    }//end of main
}//end of java class
