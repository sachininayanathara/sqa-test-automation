package com.qa.test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.ItemsPage;
import com.qa.pages.LoginPage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    ItemsPage itemsPage;
    private static final Logger logger = LogManager.getLogger(HomePageTest.class);
    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homePage = new HomePage();
        homePage = loginPage.login(properties.getProperty("email"), properties.getProperty("password"));
        PropertyConfigurator.configure("C:\\Users\\Sachini Nayanathara\\Documents\\Projects\\SQA_Assignment_Test\\src\\log4j.properties");
        logger.info("opening website");
        itemsPage = homePage.items();
    }

    @Test
    public void Test() {
        System.out.println("test");
    }
}
