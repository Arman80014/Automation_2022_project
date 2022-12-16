package MY_Practice_0001;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Intercom_Test {

    public static void main(String[] args) throws InterruptedException {


        //setting up driver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        //going to intercom webpage
        driver.get("https://www.intercom.com");

Thread.sleep(3000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement myView = driver.findElement(By.xpath("//*[text()='SMS']"));
        jse.executeScript("arguments[0].scrollIntoView(true);",myView);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='SMS']")).click();

        for (int i =0; i<3; i++){

        WebElement WebBar = driver.findElements(By.xpath("//*[@class='jsx-3653846008 menu-item-link menu-item-link-dropdown']")).get(i);
        Thread.sleep(2000);
        WebBar.click();

driver.findElement(By.xpath("//*[text()='Get started']")).click();

driver.findElement(By.xpath("//*[@id='Email_field']")).sendKeys("Armanh9494@yahoo.com");
driver.findElement(By.xpath("//*[@class='submit-button']")).click();




        }




    }//end of main







}// end of class
