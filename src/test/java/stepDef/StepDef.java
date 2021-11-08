package stepDef;

import com.qa.base.TestBase;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class StepDef extends TestBase {

    @Given("browser is open")
    public void browser_is_open () {
        String browserName = properties.getProperty("browser");
        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sachini Nayanathara\\Downloads\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(properties.getProperty("url"));
    }

    @When("user enters password and email")
    public void enter_email_and_password(){
        driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();
        driver.findElement(By.xpath("//input[@ id='email']")).sendKeys("haputhanthri.sn@gmail.com");
        driver.findElement(By.xpath("//input[@ name='passwd']")).sendKeys("test123");
    }

    @Then("login successfully")
    public void click_login(){
        driver.findElement(By.xpath("//*[@id='SubmitLogin']")).click();
    }

    @Given("section is selected")
    public void select_section(){
        driver.findElement(By.xpath("//a[@title = 'Women']")).click();
    }

    @When("add items")
    public void add_item1() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[1]/img"))).perform();
        WebDriverWait wait1 = new WebDriverWait(driver, 60);
        wait1.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[2]/div[2]/a[1]/span")))).click();
        driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span")).click();
        actions.moveToElement(driver.findElement(By.xpath("//*[@id='center_column']/ul/li[2]/div/div[1]/div/a[1]/img"))).perform();
        WebDriverWait wait2 = new WebDriverWait(driver, 60);
        wait2.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[1]/span")))).click();
        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")).click();
    }

    @And("complete payment")
    public void complete_payment(){
        driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=order&step=1']")).click();
        driver.findElement(By.xpath("//button[@name='processAddress']")).click();
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("//button[@name='processCarrier']")).click();
        driver.findElement(By.xpath("//a[@class='cheque']")).click();
        driver.findElement(By.xpath("//*[@id='cart_navigation']/button/span")).click();
        driver.findElement(By.xpath("//a[@title='Back to orders']")).click();
        driver.findElement(By.xpath("//*[@id='order-list']/tbody/tr[1]/td[6]")).click();
    }
}




