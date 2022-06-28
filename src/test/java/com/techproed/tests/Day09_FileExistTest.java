package com.techproed.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Day09_FileExistTest {
    @Test
    public void isExist(){
//        We cannot automate desktop applications with selenium
//        But we can use JAVA to understand a file path exist in our computers
//        OR WE CAN GET TEH PATH DYNAMICALLY USING JAVA
        String homePath=System.getProperty("user.home");
        System.out.println(homePath);//   /Users/techproed
//      String pathOfFile="/Users/techproed/Desktop/flower.jpeg";
        String pathOfFile=homePath+"/Desktop/flower.jpeg"; //Users/techproed/Desktop/flower.jpeg
//        Check if the file exist on your computer?
        boolean isExist=Files.exists(Paths.get(pathOfFile));// Returns true if pathOfFile exist on the computer, returns false otherwise
        Assert.assertTrue(isExist);
    }
}
