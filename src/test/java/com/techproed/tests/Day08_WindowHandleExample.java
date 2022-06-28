package com.techproed.tests;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Set;
public class Day08_WindowHandleExample extends TestBase {
    @Test
    public void windowHandle() throws InterruptedException {
//        Create a new Class Tests package: Day08_WindowHandleExample
//        Method name:windowHandle
//        Given user is on the https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");
//        Then user verifies the text : “Opening a new window”
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
//        Then user verifies the title of the page is “The Internet”
        Assert.assertEquals(driver.getTitle(),"The Internet");
//        When user clicks on the “Click Here” button
        driver.findElement(By.linkText("Click Here")).click();
//        Then user verifies the new window title is “New Window”
//        Then user verifies the text:  “New Window”
//        When user goes back to the previous window and then verifies the title : “The Internet”
//        Driver is on the Window 1:
//        System.out.println(driver.getCurrentUrl());
        String window1=driver.getWindowHandle();// returns the id of the current window
        Set<String> allWindows=driver.getWindowHandles();//returns all windows.
//        allwindows has window1 and window2
//        How do you handle multiple windows?
//        switch to the windows.
        for (String eachWindow:allWindows){
//            System.out.println("Window Handles : "+eachWindow);
            Thread.sleep(2000);
//            This switches window 1 first then window2 So I need to use if condition so I don't switch to window1
//            driver.switchTo().window(eachWindow);
//            System.out.println(driver.getCurrentUrl());
//            If driver is NOT on window1 then switch to th other window
            if(!eachWindow.equals(window1)) {
                driver.switchTo().window(eachWindow);
                System.out.println(driver.getCurrentUrl());
            }
        }
        //            Now driver is on the new window
//        Then user verifies the new window title is “New Window”
        Assert.assertEquals(driver.getTitle(),"New Window");
//        Print the heading text New Window
        System.out.println(driver.findElement(By.xpath("//h3")).getText());
//        When user goes back to the previous window and then verifies the title : “The Internet”
//      DRIVER IS ON WINDOW 2
//        To switch window1 we need to use the loop again
        String window2=driver.getWindowHandle();//getting the window2 handle
        for (String eachWindow:allWindows){
            Thread.sleep(2000);
            if(!eachWindow.equals(window2)) {
                driver.switchTo().window(eachWindow);
            }
        }
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"The Internet");
    }
}