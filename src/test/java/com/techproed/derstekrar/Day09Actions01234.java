package com.techproed.derstekrar;

import com.techproed.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day09Actions01234 {
    //    Create a class: ActionsClass1
//    Create a test method : contextClickMethod() and test the following scenario:
//    Given user is on the https://the-internet.herokuapp.com/context_menu
//    When use Right clicks on the box
//    Then verify the alert message is “You selected a context menu”
//    Then accept the alert

    @Test
    public void test03(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement box=driver.findElement(By.id("hot-spot"));
        Actions action=new Actions(driver);
        action.contextClick(box).perform();
        String actuslMessage=driver.switchTo().alert().getText();
        Assert.assertEquals("You selected a context menu",actuslMessage);
        driver.switchTo().alert().accept();
    }
    @Test
    public void test3() throws InterruptedException {
        //       Create a class: ActionClass2
//        Create test method : hoverOver() and test the following scenario:
//        Given user is on the https://www.amazon.com/
//        When use click on “Account” link
//        Then verify the page title contains “Your Account”
        //        Given user is on the https://www.amazon.com/
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
        WebElement account=driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        Actions actions=new Actions(driver);
        WebElement createList=driver.findElement(By.xpath("//span[.='Account']"));
        actions.moveToElement(account).pause(2).click(createList).perform();
       // Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());

    }
    @Test
    public void action3(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
       WebElement agree= driver.findElement(By.xpath("//*[.='I agree']"));
       Actions actions=new Actions(driver);
       actions.click(agree).perform();
      WebElement searchbox= driver.findElement(By.name("q"));
       actions.keyDown(searchbox,Keys.SHIFT).sendKeys("iphone").
               keyUp(searchbox,Keys.SHIFT).sendKeys(" expensive").
               perform();

    }
    @Test
    public void action4(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).sendKeys(Keys.PAGE_UP).
                sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.ARROW_UP).perform();





    }
}
