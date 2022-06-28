package com.techproed.derstekrar;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day09_FileDownload extends TestBase {
    @Test
    public void download() throws InterruptedException {
        //    Create a class:FileDownloadTest
//    downloadTest()
//    In the downloadTest() method, do the following test:
//    Go to https://the-internet.herokuapp.com/download
//    Download flower.jpeg file
//    Then verify if the file downloaded successfully
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.partialLinkText("box.png")).click();
        Thread.sleep(2000);
        String homepath=System.getProperty("user.home");
        String pathfile=homepath+"/Downloads/box.png";
        boolean isExist= Files.exists(Paths.get(pathfile));
        Assert.assertTrue(isExist);
    }
}
