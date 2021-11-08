package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {
    @FindBy(xpath  = "//a[@title = 'Women']")
    WebElement womenButton;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public ItemsPage items() {
        womenButton.click();
        return new ItemsPage();
    }
}
