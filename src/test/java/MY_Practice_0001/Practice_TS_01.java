package MY_Practice_0001;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Practice_TS_01 {
public static void main (String[] args){

    //initiating weddriver with chrome option
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized" , "incognito");
    WebDriver driver = new ChromeDriver(options);

    //going to pnc webpage
    driver.navigate().to("https://www.pnc.com");























}//end of main
}//end of java class
