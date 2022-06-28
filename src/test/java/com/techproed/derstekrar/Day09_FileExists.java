package com.techproed.derstekrar;

import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day09_FileExists  {
    @Test
    public void file(){
       String homePath= System.getProperty("user.home");
        System.out.println(homePath);
        String filePath=homePath+"/Desktop/flower.jpeg";
        boolean fileExist= Files.exists(Paths.get(filePath));
        System.out.println(fileExist);
        String tercumePath=homePath+"/Desktop/Home office ek dokuman/Tercume Son.docx";
        boolean Terc=Files.exists(Paths.get(tercumePath));
        System.out.println(Terc);
    }

}
