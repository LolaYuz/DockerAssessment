package utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementUtils {
    private static Actions actions = new Actions(Driver.getDriver());

    // Method to check if element is displayed
    public static boolean isElementDisplayed(WebElement element){
        boolean check;
        try{
            check = element.isDisplayed();
        }
        catch (NoSuchElementException e){
            check = false;
        }
        return check;
    }
//Method to move/hover over the webelement
    public static void moveToElement(WebElement element){
        actions.moveToElement(element).perform();
    }
}