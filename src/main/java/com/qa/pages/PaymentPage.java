package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends TestBase {
    @FindBy(xpath = "//a[@href='http://automationpractice.com/index.php?controller=order&step=1']")
    WebElement summaryCheckOutButton;

    @FindBy(xpath = "//button[@name='processAddress']")
    WebElement addressCheckOutButton;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement shippingCheckbox;

    @FindBy(xpath = "//button[@name='processCarrier']")
    WebElement shippingCheckOutButton;

    @FindBy(xpath = "//a[@class='cheque']")
    WebElement paymentCheckOutButton;

    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button/span")
    WebElement confirmOrderButton;

    @FindBy(xpath = "//a[@title='Back to orders']")
    WebElement backToOrdersButton;

    @FindBy(xpath = "//*[@id='order-list']/tbody/tr[1]/td[6]")
    WebElement invoice;

    public PaymentPage() {
        PageFactory.initElements(driver, this);
    }

    public void payment() {
        summaryCheckOutButton.click();
        addressCheckOutButton.click();
        shippingCheckbox.click();
        shippingCheckOutButton.click();
        paymentCheckOutButton.click();
        confirmOrderButton.click();
        backToOrdersButton.click();
        invoice.click();
    }

//    public void summaryCheckOut() {
//        summaryCheckOutButton.click();
//        return;
//    }
//
//    public void addressCheckOut() {
//        addressCheckOutButton.click();
//        return;
//    }
//
//    public void shippingCheckOut() {
//        shippingCheckbox.click();
//        shippingCheckOutButton.click();
//        return;
//    }
//
//    public void paymentCheckOut() {
//        paymentCheckOutButton.click();
//        return;
//    }
//
//    public void confirmOrder() {
//        confirmOrderButton.click();
//        return;
//    }

}
