package com.qa.test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.ItemsPage;
import com.qa.pages.LoginPage;
import com.qa.pages.PaymentPage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class  LoginPageTest extends TestBase  {
    LoginPage loginPage;
    HomePage homePage;
    ItemsPage itemsPage;
    PaymentPage paymentPage;
    private static final Logger logger = LogManager.getLogger(HomePageTest.class);
    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        PropertyConfigurator.configure("C:\\Users\\Sachini Nayanathara\\Documents\\Projects\\SQA_Assignment_Test\\src\\log4j.properties");
        initialization();
        logger.info("opening website");
        loginPage = new LoginPage();
        homePage = new HomePage();
        paymentPage = new PaymentPage();
        homePage = loginPage.login(properties.getProperty("email"), properties.getProperty("password"));
        logger.info("logged in successfully");
        itemsPage = homePage.items();
        itemsPage.addToCart();
        logger.info("items added successfully");
        paymentPage.payment();
        logger.info("payment is done successfully");
    }

//    @Test
//    public void checkValidInvalidUser()
//    {
//        loginPage.login(properties.getProperty("email"), properties.getProperty("password_invalid"));
//        String bodyText = driver.findElement(By.tagName("body")).getText();
//        Assert.assertTrue(bodyText.contains("Invalid Password"), "Text not found!");
//    }
//
//    @Test
//    public void checkInvalidInvalidUser()
//    {
//        loginPage.login(properties.getProperty("email_invalid"), properties.getProperty("password"));
//        String bodyText = driver.findElement(By.tagName("body")).getText();
//        Assert.assertTrue(bodyText.contains("Invalid Email"), "Text not found!");
//    }
//
//    @Test
//    public void checkValidUser()
//    {
//        loginPage.login(properties.getProperty("email"), properties.getProperty("password"));
//    }

    @Test
    public void Test() {
        System.out.println("test");
     }

}
