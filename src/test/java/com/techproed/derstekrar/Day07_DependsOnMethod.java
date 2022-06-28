package com.techproed.derstekrar;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day07_DependsOnMethod {


        @Test(priority=3,dependsOnMethods = "searchResultTest")
        public void logIn(){
            System.out.println("Login Test");
            Assert.assertTrue(true);
        }
        @Test(dependsOnMethods = "logIn")//1. logIn runs before the homePage
        public void homePage(){          //homePage method only runs if logIn PASS.
            //Otherwise homePage will be SKIPPED
            //homePage depends on logIn method
            System.out.println("Home Page Test");
        }
        @Test(priority = 1)
        public void search(){
            System.out.println("Search Test");
        }
        @Test(priority = 2)
        public void searchResultTest(){
            System.out.println("Search Result Test");
        }
    }


