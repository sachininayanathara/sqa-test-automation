package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(xpath  = "//a[@class='login']")
    WebElement signInButton;

    @FindBy(xpath = "//input[@ id='email']")
    WebElement eMail;

    @FindBy(xpath = "//input[@ name='passwd']")
    WebElement password;

    @FindBy(xpath = "//*[@id='SubmitLogin']")
    WebElement submitButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public HomePage login(String email, String pswd) {
        signInButton.click();
        System.out.println("Login");
        eMail.sendKeys(email);
        password.sendKeys(pswd);
        submitButton.click();
        return new HomePage();
    }

}
