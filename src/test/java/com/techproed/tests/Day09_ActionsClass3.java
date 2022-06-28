package com.techproed.tests;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.lang.reflect.AccessibleObject;
public class Day09_ActionsClass3 extends TestBase {
    @Test
    public void keysUpDown(){
//        Go to google
//        Send 'iPhone X prices' => convert small letter capital vice versa.
//        Highlight the search box by double clicking
        driver.get("https://www.google.com");
         driver.findElement(By.xpath("//*[.='I agree']")).click();
        WebElement searchBox=driver.findElement(By.name("q"));
//        searchBox.sendKeys("iPhone X prices"); //Normal search
        Actions actions = new Actions(driver);
//        actions.keyDown("WEBELEMENT ","COMMAND LIKE KeysUp or KeysDown or KeysShift")
        actions.
                keyDown(searchBox, Keys.SHIFT). //Pressing SHIFT on keyboard
                sendKeys("iphone x prices").    //sending small letter and expecting capitol letters being typed
                keyUp(searchBox, Keys.SHIFT).   //Unpressing SHIFT on keyboard
                sendKeys(" too expensive").     //sending normal letters because no longer pressing shift
                perform();                      //performing the task
//        INPUT             OUTPUT
//        iPhone X prices => IPHONE X PRICES  because I am testing if capital letter search works
//        keyDown     (       searchBox,       Keys.SHIFT      ).
//        PRESS               ELEMENT          SHIFT on keyboard
    }
}

