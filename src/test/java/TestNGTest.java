import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNGTest {

    @Test
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sachini Nayanathara\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.phptravels.net/");

        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.name("email")).sendKeys("mercury@gmail.com");
        driver.findElement(By.name("password")).sendKeys("mercury");
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg btn-block effect ladda-button waves-effect']")).click();
    }

}
