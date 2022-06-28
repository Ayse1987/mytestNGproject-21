package com.techproed.derstekrar;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day08_Syncronization1 extends TestBase {
    @Test
    public void test() {


        //Create a class:Day09_Synchronization1. Create a method: synchronization1
//    Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//    Click on remove button
        driver.findElement(By.xpath("(//button)[1]")).click();
        WebDriverWait wait=new WebDriverWait(driver,30);
        String expectedNote="It's gone!";

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        String  actualNote=driver.findElement(By.id("message")).getText();
        //Assert.assertEquals(actualNote,expectedNote);
        System.out.println(actualNote);

        driver.findElement(By.xpath("(//button)[1]")).click();
        WebElement note=driver.findElement(By.id("message"));
        wait.until(ExpectedConditions.visibilityOf(note));
        //Assert.assertEquals(note.getText(),"It's back!");




        //    =========IMPLICIT WAIT IS ALREADY IN THE DRIVER CLASS======
//    And verify the message is equal to “It's gone!”
//    WebElement goneMessageElement=driver.findElement(By.xpath("//p[@id='message']"));
//    String goneMessageText=goneMessageElement.getText();
//    Assert.assertEquals(goneMessageText,"It's gone!");
//    =========EXPLICIT WAIT================
//    Step 1 for explicit wait: Create wait object
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //    Step 2 Use wait object with an EXPECTED CONDITION
//    WAITING FOR By.xpath("//p[@id='message']")  UP TO 10 SECONDS
//    IF THAT ELEMENT IS VISIBLE IN 10 SECONDS THEN IT WILL RETURN THE ELEMENT
//    SO WE DON'T NEED TO USE findElement IF WE ARE USING EXPLICIT WAIT
//        WebElement goneMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
//        String goneMessageText = goneMessageElement.getText();
//        Assert.assertEquals(goneMessageText, "It's back!");

//    COMPLETE AS HOMEWORK. REPEAT LINE 36,37,38. JUST REPLACE The Locator and variable names
//    Then click on Add button
        driver.findElement(By.xpath("//button[1]")).click();
        //    And verify the message is equal to “It's back!”
        //BELOW DOES 2 THINGS:
        //1. waits up to 10 seconds
        //2. returns as webelement
        WebElement backMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        String bachMessageText = backMessage.getText();
        String expectedBackMessage = "It's back!";
       // Assert.assertEquals(bachMessageText, expectedBackMessage);
//    visibilityOfElementLocated one odf the most used explicit wait
//    this waits for the locator to be visible on the page
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Are you all right");

    }
    @Test
    public void test2(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement box=driver.findElement(By.xpath("//input[@type='text']"));
        System.out.println(box.isEnabled());
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(box));
        System.out.println(box.isEnabled());



    }
}