package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemsPage extends TestBase {
    @FindBy(xpath = "//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[1]/img")
    WebElement item1;

    @FindBy(xpath = "//*[@id='center_column']/ul/li[2]/div/div[1]/div/a[1]/img")
    WebElement item2;

    @FindBy(xpath = "//*[@id='center_column']/ul/li[1]/div/div[2]/div[2]/a[1]/span")
    WebElement addToCart1;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[1]/span")
    WebElement addToCart2;

    @FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span")
    WebElement continueShopping;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
    WebElement checkOut;

    public ItemsPage() {
        PageFactory.initElements(driver, this);
    }

    public PaymentPage addToCart() {
        Actions actions = new Actions(driver);
        WebDriverWait wait1 = new WebDriverWait(driver,60);
        actions.moveToElement(item1).perform();
        wait1.until(ExpectedConditions.elementToBeClickable(addToCart1)).click();
        continueShopping.click();
        WebDriverWait wait2 = new WebDriverWait(driver,60);
        actions.moveToElement(item2).perform();
        wait2.until(ExpectedConditions.elementToBeClickable(addToCart2)).click();
        checkOut.click();
        return new PaymentPage();
    }
}
