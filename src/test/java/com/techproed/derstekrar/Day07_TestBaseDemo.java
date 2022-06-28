package com.techproed.derstekrar;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day07_TestBaseDemo extends TestBase {
    @Test
    public void test01(){
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Apple"+ Keys.ENTER);
        System.out.println(driver.getPageSource());
        Assert.assertTrue(driver.getPageSource().contains("Computer"));//Computer i de kabul etti cok dogru bir test olmadi


    }
}
