package com.techproed.derstekrar;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day08_iframeTest extends TestBase {
     /*Create a class: Day08_IFrameTest
Create a method: iframeTest
Go to https://the-internet.herokuapp.com/iframe
Verify the Bolded text contains “Editor”
Locate the text box
Delete the text in the text box
Type “This text box is inside the iframe”
Verify the text Elemental Selenium text is displayed on the page*/

    @Test
    public void iframeTest(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        String expression=driver.findElement(By.xpath("//h3")).getText();
        System.out.println(expression);
        Assert.assertTrue(expression.contains("Editor"));
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.xpath("//p")).clear();
        driver.findElement(By.xpath("//p")).sendKeys("This text box is inside the iframe");
        driver.switchTo().parentFrame();
        boolean elementalSelenium=driver.findElement(By.partialLinkText("Elemental")).isDisplayed();
        Assert.assertTrue(elementalSelenium);


    }
}
