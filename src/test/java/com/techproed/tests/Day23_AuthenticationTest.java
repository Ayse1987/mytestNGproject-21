package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day23_AuthenticationTest extends TestBase {
    @Test
    public void basicAuth(){
        //When Authentication popup arize you can handle like this. entering the data like key value pairs
        //as it is below then enter the url without https:// since we wrore it at the beginning
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        //https://username:password@URL//For authentication use this text,
        // no need to use https:// for the second time
       boolean congratExist=driver.findElement(By.xpath("//*[contains(text(),'Congratulations!')]")).isDisplayed();
        Assert.assertTrue(congratExist);


    }
}
