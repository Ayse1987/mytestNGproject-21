package com.techproed.derstekrar;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class Day08_WindowHandleExample extends TestBase {
   // Create a new Class Tests package: Day08_WindowHandleExample
//        Method name:windowHandle
//        Given user is on the https://the-internet.herokuapp.com/windows
    @Test
    public void Test(){
        driver.get("https://the-internet.herokuapp.com/windows");
        String handle=driver.getWindowHandle();
        driver.findElement(By.partialLinkText("Click Here")).click();
        Set<String> setHandles=driver.getWindowHandles();
        String newWindow="";
        for(String w:setHandles){
            if(w!=handle){
                newWindow=w;

            }
        }
        driver.switchTo().window(newWindow);
        System.out.println(driver.getTitle());

        boolean isdisplayed=driver.findElement(By.xpath("//h3")).isDisplayed();
        Assert.assertTrue(isdisplayed);
        driver.switchTo().window(handle);
        System.out.println(driver.getTitle());

    }


}
