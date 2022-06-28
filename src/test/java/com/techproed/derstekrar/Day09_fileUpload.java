package com.techproed.derstekrar;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Day09_fileUpload extends TestBase {
    @Test
    public void uploadtest() throws InterruptedException {
       // Class Name: FileUploadTest
//        Method Name: fileUploadTest
//        When user goes to https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile=driver.findElement(By.id("file-upload"));
        String homePath=System.getProperty("user.home");
        System.out.println(homePath);
        String pathfile=homePath+"/Downloads/flower.jpeg";
        chooseFile.sendKeys(pathfile);
        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(2000);



//        Thread.sleep(2000);
    }
}
