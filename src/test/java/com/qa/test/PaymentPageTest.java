package com.qa.test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.ItemsPage;
import com.qa.pages.LoginPage;
import com.qa.pages.PaymentPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PaymentPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    ItemsPage itemsPage;
    PaymentPage paymentPage;

    public PaymentPageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        paymentPage = new PaymentPage();
        System.out.println("test items page 1");
        homePage = loginPage.login(properties.getProperty("email"), properties.getProperty("password"));
        itemsPage = homePage.items();
        itemsPage.addToCart();
        paymentPage.payment();
    }

    @Test
    public void Test() {
        System.out.println("payment page");
    }
}
