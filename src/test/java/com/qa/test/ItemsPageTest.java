package com.qa.test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.ItemsPage;
import com.qa.pages.LoginPage;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemsPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    ItemsPage itemsPage;

    public ItemsPageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        System.out.println("test items page 1");
        homePage = loginPage.login(properties.getProperty("email"), properties.getProperty("password"));
        itemsPage = homePage.items();
        itemsPage.addToCart();
        Logger log = Logger.getLogger("devpinoyLogger");
        log.info("opening website");
    }
    
    @Test
    public void Test() {
        System.out.println("test items page");
    }
}
