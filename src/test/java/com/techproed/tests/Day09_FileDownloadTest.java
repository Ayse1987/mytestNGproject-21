package com.techproed.tests;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Day09_FileDownloadTest extends TestBase {
    //    Create a class:FileDownloadTest
//    downloadTest()
//    In the downloadTest() method, do the following test:
//    Go to https://the-internet.herokuapp.com/download
//    Download flower.jpeg file
//    Then verify if the file downloaded successfully
    @Test
    public void downloadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        //    Download flower.jpeg file
        driver.findElement(By.linkText("flower.jpeg")).click();
        //    Then verify if the file downloaded successfully
        Thread.sleep(2000);
//        I know the flower.jpeg will be in Downloads folder if download is successful
//        To verify if a path exist in out download folder I follow these steps:
//        1. Find the path of flower.jpeg file
//        filePath = home directory + /Downloads folder + file name with extension
        String flowerPath=System.getProperty("user.home")+"/Downloads/flower.jpeg";
//                                                         "\\Downloads\\flower.jpeg"
//        Alter path :        /Users/techproed/Desktop/flower.jpeg
//      Then verify if the file downloaded successfully
        boolean isExist = Files.exists(Paths.get(flowerPath));
        Assert.assertTrue(isExist);
    }
}