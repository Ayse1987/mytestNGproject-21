package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import java.util.Set;

public class Day23_HandlingCookies extends TestBase {
    @Test
    public void handleCookies(){
        driver.get("https://www.amazon.com");
        Set<Cookie> allCookies=driver.manage().getCookies();//return all cookies

        int numOfCookies=allCookies.size();
        System.out.println("Num Of Cookies"+numOfCookies);//total num of cookies

        //print all cookies one by one
        for(Cookie w:allCookies){
            System.out.println(("Name: "+w.getName()));
            System.out.println("Value :"+w.getValue());
            //it has key value pairs, not understandable by user
        }
        //Get cookies based on the name
        System.out.println("Cooki named ubid-main"+driver.manage().getCookieNamed("ubid-main"));

        //Add new cookie
        Cookie myCookies=new Cookie("MyBestCookies","1223654");
        driver.manage().addCookie(myCookies);
        allCookies=driver.manage().getCookies();
        int newNumOfCookies=allCookies.size();
        System.out.println("Num Of Cookies  :"+newNumOfCookies);

        //Delete cookies
        driver.manage().deleteCookieNamed("skin");
        allCookies=driver.manage().getCookies();
        System.out.println("Number of cookies :"+allCookies.size());


        //Delete all cookies
        driver.manage().deleteAllCookies();
        allCookies=driver.manage().getCookies();
        System.out.println("Number of cookies :"+allCookies.size());
        driver.close();
    }
}
