package Reusable_library;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;

import static org.openqa.selenium.By.*;

public class ReusableActions_Loggers {

    ///reusable method to define and launch webdriver
    public static WebDriver setUpDriver() {
        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add argument to chrome options
        options.addArguments("start-maximized");
        //for mac use "start-fullscreen"
        //options.addArguments("start-fullscreen");
        //if above does not work on mac, then try --kiosk
        //options.addArguments("--kiosk");
        //initialize driver with chrome options
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }//end of setup driver method

    public static void clickAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(xpath(xpath)));
            element.click();
            logger.log(LogStatus.PASS,"Successfully click on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL,"Unable to click on : " + elementName + " for reason " + e);
            getScreenShot(driver, elementName, logger);



        }
    }//end of click action

    public static void clickActionByIndex(WebDriver driver, String xpath, int index, ExtentTest logger,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(xpath(xpath))).get(index).click();
            logger.log(LogStatus.PASS,"Successfully click on By index : " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL," unable to click on By index : " + elementName + " for reason " + e);
        }
    }

    public static void mouseHover(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //declare mouse actions
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(xpath(xpath)));
            actions.moveToElement(element).click().perform();
            logger.log(LogStatus.PASS,"Successfully hover on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to hover to element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL,"Unable to hover on : " + elementName + " for reason " + e);
        }
    }

    public static void doubleClick(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //declare mouse actions
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(xpath(xpath)));
            actions.moveToElement(element).doubleClick().perform();
        } catch (Exception e) {
            System.out.println("Unable to hover to element: " + elementName + " for reason: " + e);

        }
    }
    public static void sendKeysAction(WebDriver driver, String xpath, String userInput, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(xpath(xpath)));
            element.sendKeys(userInput);
            logger.log(LogStatus.PASS,"Successfully entered a value on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to send keys to : " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL,"Unable to send keys to : " + elementName + " for reason " + e);
        }
    }

    public static void submitAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(xpath(xpath)));
            element.submit();
            logger.log(LogStatus.PASS,"Successfully submit on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL,"Unable to submit on element : " + elementName + " for reason " + e);
        }
    }//end of submit action


    public static String getTextAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String textOutput = "";
        logger.log(LogStatus.PASS,"Successfully capture text " + elementName);
        logger.log(LogStatus.INFO,"Successfully capture text info " + elementName + " text for output " + textOutput) ;
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(xpath(xpath)));
            textOutput = element.getText();
        } catch (Exception e) {
            System.out.println("Unable to get text for : " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL,"Unable to get text for : " + elementName + " for reason " + e);
        }
        return textOutput;
    }


    public static void selectByTextAction(WebDriver driver, String xpath, String userInput,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(userInput);
            logger.log(LogStatus.PASS,"Successfully select by text");

        }catch(Exception e){
            System.out.println("unable to get dropDown : " + elementName + "for reason: " + e);
            logger.log(LogStatus.FAIL," unable to select by text " + elementName + " for reason " + e);
        }
    }//end of  selectByTextAction

    public static void switchToTabByIndex(WebDriver driver, int userInput,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(userInput));
            logger.log(LogStatus.PASS,"Successfully switch to tab");
        }catch(Exception e){
            System.out.println("Unable to switch tabs : " + elementName + "for reason" + e );
            logger.log(LogStatus.FAIL,"unable to switch tabs: " + elementName + "for reason" + e);
        }

    }//end of switchTabs

    public static void scrollByView(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;

            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(xpath(xpath)));

            jse.executeScript("arguments[0].scrollIntoView(true);", element);
            logger.log(LogStatus.PASS,"Successfully scroll by view");
        }catch(Exception e){
            System.out.println("unable to scroll: " + elementName + "for reason" + e);
            logger.log(LogStatus.FAIL,"unable to scroll by view: " + elementName + "for reason" + e);
        }//end of catch
    }//end of scrollByView

    public static String getTextActionByIndex(WebDriver driver, String xpath, int number, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String textOutput = "";
        try {
            ArrayList <WebElement> element = new ArrayList<>(wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(xpath(xpath))));
            textOutput = element.get(number).getText();
        } catch (Exception e) {
            System.out.println("Unable to get text for : " + elementName + " for reason: " + e);
        }//end of catch
        return textOutput;
    }//end of index by text

    public static void getScreenShot(WebDriver driver, String imageName, ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }//end of getScreenshot method

    public static void compareExpectedAndActualText(String expectedText, String actualText, ExtentTest logger) {
        if (actualText.equals(expectedText)) {
            logger.log(LogStatus.PASS, "Expected Text: " + expectedText + " and Actual Text: " + actualText + " match");
        }
        else{
            logger.log(LogStatus.FAIL, "Expected Text: " + expectedText + " and Actual Text: " + actualText + " does not match");
        }
    }//end of compareExpectedAndActualText






























}//end of class
