package testAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebBroserTesting {
	WebDriver driver;    
    @Test
    public void Login() {
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("Email")).sendKeys("milind123@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("password1$");
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
        String expectedText="milind12@gmail.com";
        String actualText=driver.findElement(By.linkText("milind12@gmail.com")).getText();
        Assert.assertEquals(actualText,expectedText);
    }
    
    @Test
    public void Logout() {
        driver.findElement(By.linkText("Log out")).click();
    }
    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\VIJAYAPALA\\Selenium Jar_Web Driver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver(); 
        driver.manage().window().maximize();
        driver.get("http://demowebshop.tricentis.com");
    }
    @AfterClass
    public void afterClass() {
        driver.close();
    }
  }

