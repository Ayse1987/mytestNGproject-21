package com.techproed.derstekrar;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day07_AlertTest extends TestBase {
    //    Go to https://the-internet.herokuapp.com/javascript_alerts
//    Create a class: AlertTest
//    Create setUp method
//    Create 3 test methods:
//    acceptAlert() => click on the first alert, verify the text “I am a JS Alert” , click OK ,
//    and Verify “You successfuly clicked an alert”

//    dismissAlert()=> click on the second alert, verify text "I am a JS Confirm”, click cancel,
//    and Verify “You clicked: Cancel”

//    sendKeysAlert()=> click on the third alert, verify text “I am a JS prompt”,
//    type “Hello Word”, click OK, and Verify “You entered: Hello Word”


    @Test
    public void acceptAlert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
       String actualAlertText= driver.switchTo().alert().getText();
       String expectedAlertText="I am a JS Alert";
        Assert.assertEquals(expectedAlertText,actualAlertText);
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        String expectedResult="You successfully clicked an alert";
        String actualResult= driver.findElement(By.id("result")).getText();
      Assert.assertEquals(expectedResult,actualResult);

    }
    @Test
    public void Test2(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        String actualAlert=driver.switchTo().alert().getText();
        String expectedAlert="I am a JS Confirm";
        Assert.assertEquals(expectedAlert,actualAlert);
        driver.switchTo().alert().dismiss();
        String actualResult=driver.findElement(By.id("result")).getText();
        String expectedResult="You clicked: Cancel";

    }
    @Test
    public void Test3(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("(//*[contains(text(),'Prompt')])[2]")).click();
        String actualAlert=driver.switchTo().alert().getText();
        String expectedAlert="I am a JS prompt";
        Assert.assertEquals(expectedAlert,actualAlert);
        driver.switchTo().alert().sendKeys("Hello World");
        driver.switchTo().alert().accept();
       String actualResult= driver.findElement(By.id("result")).getText();
       Assert.assertEquals(actualResult,"You entered: Hello Word");


    }






}
