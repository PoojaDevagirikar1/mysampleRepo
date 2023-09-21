
package com.application.utils.commonmethods;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;

import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Action;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.FluentWait;

import org.openqa.selenium.support.ui.Wait;


 

public class CommonMethods {

 

    private static Logger logger = LogManager.getLogger(CommonMethods.class.getName());

    final public static String selectByIndexString = "selectByIndex_";

    final public static String kendoArrowXpathLocator = "//span[contains(@class,'k-i-arrow') or contains(@class,'k-i-arrow-s')]";


    // Function to wait for give seconds

    public static boolean waitForGivenSeconds(int seconds) {

        boolean aReturnValue = false;

        try {

            logger.info("waitForGivenSeconds: Going to wait for " + seconds + " seconds");

            TimeUnit.SECONDS.sleep(seconds);

            aReturnValue = true;

            logger.info("waitForGivenSeconds: " + seconds + " seconds wait over");

        } catch (Exception e) {

            logger.error("waitForGivenSeconds: Error occured: \n" + e.getMessage());

        }

        return aReturnValue;

    }

 

    // Function to make sure that the passed element is in clickable state.

    // The element passed should be not null

    public static boolean waitForWebElementToBeClickable(WebElement element, WebDriver driver) {

        boolean aReturnValue = false;

        try {

            // ToDo:- Implement the fragmented approach if required. It give

            // more stability.

            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)

                //    .withTimeout(Integer.parseInt(ConfigurationProperties.getProperty("timeOutForElementPolling")),

                //            TimeUnit.SECONDS)

                //    .pollingEvery(Integer.parseInt(ConfigurationProperties.getProperty("smallWait")), TimeUnit.SECONDS)

                    .ignoring(NoSuchElementException.class);

            wait.until(ExpectedConditions.elementToBeClickable(element));

            logger.info("waitForWebElementToBeClickable: Element is clickable now");

            aReturnValue = true;

        } catch (Exception e) {

            logger.error("waitForWebElementToBeClickable: Error occured: \n" + e.getMessage());

        }

        return aReturnValue;

    }


 

    // Function to make sure that the passed element is in visible state.

    // The element passed should be not null

    public static boolean waitForWebElementToBeVisible(WebElement element, WebDriver driver) {

        boolean aReturnValue = false;

        try {
        	logger.info("waitForWebElementToBeVisible: Element is visbile now");

            aReturnValue = true;

        } catch (Exception e) {

            logger.error("waitForWebElementToBeVisible: Error occured: \n" + e.getMessage());

        }

        return aReturnValue;

    }

 

    // The element passed should be not null

    public static boolean waitForWebElementToBeInvisible(WebElement element, WebDriver driver) {

        boolean aReturnValue = false;

        try {

            aReturnValue = true;

        } catch (Exception e) {

            logger.error("waitForWebElementToBeInvisible: Error occured: \n" + e.getMessage());

        }

        return aReturnValue;

    }

 

    public static boolean isElementEnabled(WebElement element) {

        try {

            return element.isEnabled();

        } catch (Exception e) {

            logger.error("isElementEnabled: Error occured: \n" + e.getMessage());

        }

        return false;

    }

 

    public static boolean verifyForOptionalElementByXpath(String xpathLocator, WebDriver driver, int timeOut) {

        Boolean aReturnValue = null;

        try {

            // ToDo:- Implement the fragmented approach if required. It give

            // more stability.
        	logger.info("verifyForOptionalElementByXpath: Optional Element Present");

            aReturnValue = true;

        } catch (Exception e) {

            logger.error("verifyForOptionalElementByXpath: Optional Element Not Present");

            aReturnValue = false;

        }

        return aReturnValue;

    }

 

    // hover mouse to a particular element

    public static boolean hoverMouseToAnElement(WebElement element, WebDriver driver) {

        boolean aReturnValue = false;

        try {

            Actions builder = new Actions(driver);

            Action mouseHover = builder.moveToElement(element).build();

            mouseHover.perform();

            // 23 Jan 2020: This is for firefox browser. Without this wait, it is not working as expected. 

            waitForGivenSeconds(1);

            logger.info("hoverMouseToAnElement: Mouse hover performed");

            aReturnValue = true;

        } catch (Exception e) {

            logger.error("hoverMouseToAnElement: Error occured: \n" + e.getMessage());

        }

        return aReturnValue;

    }

 

    // This is for checking the invisibility of the SpinnerIcon. This function

    // makes sure that the page is fully loaded.

    // This is application specific function

    public static boolean waitForSpinnerElementToBeInvisible(WebDriver driver) {

        boolean aReturnValue = false;

        WebElement spinnerIcon = null;

        try {

            spinnerIcon = driver.findElement(By.xpath("//img[@src[contains(., 'spinner')]]"));

 

            if (waitForWebElementToBeInvisible(spinnerIcon, driver))

                logger.info("waitForSpinnerElementToBeInvisible: Spinner icon dissapeared");

            else

                logger.info(

                        "waitForSpinnerElementToBeInvisible: Time exceeded for validating the invisibility of Spinner Icon.");

//            jsScrollToBottomAndBackToTopOfAPage(driver);

            aReturnValue = true;

 

        } catch (Exception e) {

            logger.warn("waitForSpinnerElementToBeInvisible: Error occured: \n" + e.getMessage());

        } finally {

            spinnerIcon = null;

        }

        return aReturnValue;

    }


    // This is for checking the invisibility of the SpinnerIcon in Contract Page. This function

        // makes sure that the page is fully loaded.

        // This is application specific function

        public static boolean waitForSpinnerElementToBeInvisibleInContract(WebDriver driver) {

            boolean aReturnValue = false;

            WebElement spinnerIcon = null;

            try {

                spinnerIcon = driver.findElement(By.xpath("//div[@class[contains(., 'spinner')]] | //img[@src[contains(., 'spinner')]]"));

 

                if (waitForWebElementToBeInvisible(spinnerIcon, driver))

                    logger.info("waitForSpinnerElementToBeInvisible: Spinner icon dissapeared");

                else

                    logger.info(

                            "waitForSpinnerElementToBeInvisible: Time exceeded for validating the invisibility of Spinner Icon.");


//                jsScrollToBottomAndBackToTopOfAPage(driver);

                aReturnValue = true;

 

            } catch (Exception e) {

                logger.warn("waitForSpinnerElementToBeInvisible: Error occured: \n" + e.getMessage());

            } finally {

                spinnerIcon = null;

            }

            return aReturnValue;

        }

 

    // Element to get find a Web Element based on strategy and locator passed.

    // On successful completion, element will be returned else null will be

    // returned

    public static boolean isWebElementLoadedCorrectly(String strategy, String locator, WebDriver driver) {

        boolean loadedCorrectly = false;

        try {

            switch (strategy.toLowerCase()) {

            case "xpath":

                driver.findElement(By.xpath(locator));

                loadedCorrectly = true;

                break;

            case "name":

                driver.findElement(By.name(locator));

                loadedCorrectly = true;

                break;

            case "id":

                driver.findElement(By.id(locator));

                loadedCorrectly = true;

                break;

            case "cssselector":

                driver.findElement(By.cssSelector(locator));

                loadedCorrectly = true;

                break;

            case "classname":

                driver.findElement(By.className(locator));

                loadedCorrectly = true;

                break;

            case "partiallinktext":

                driver.findElement(By.partialLinkText(locator));

                loadedCorrectly = true;

                break;

            case "tagname":

                driver.findElement(By.tagName(locator));

                loadedCorrectly = true;

                break;

            case "linktext":

                driver.findElement(By.linkText(locator));

                loadedCorrectly = true;

                break;

            default:

                logger.error("findWebElement(): Locator strategy not defined");

            }

        } catch (Exception e) {

            logger.error("findWebElement(): Exception occured while finding the element");

        }

        return loadedCorrectly;

    }

 

    // Function for drag and drop

    public static boolean performDragAndDrop(WebElement source, WebElement destination, WebDriver driver) {

        boolean aReturnValue = false;

        try {

            Actions actions = new Actions(driver);

            actions.dragAndDrop(source, destination).build().perform();

//            actions.clickAndHold(source).moveToElement(destination).release(source).build().perform();

            aReturnValue = true;

            logger.info("performDragAndDrop(): Drag and Drop successfully performed");

        }

        catch(Exception e) {

            logger.info("performDragAndDrop(): Error occured" + e.getMessage());

        }

        return aReturnValue;

    }


    

}
