package com.qa.base;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

public class TestBase {

    public static WebDriver driver;
    public static Properties properties;

    public TestBase() {
        try {
            properties = new Properties();
            FileInputStream input = new FileInputStream("C:\\Users\\Sachini Nayanathara\\Documents\\Projects\\SQA_Assignment_Test\\src\\main\\java\\com\\qa\\config\\config.properties");
            properties.load(input);

            // get the property value and print it out
            System.out.println(properties.getProperty("url"));
            System.out.println(properties.getProperty("email"));
            System.out.println(properties.getProperty("password"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
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
}
