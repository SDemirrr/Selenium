package Selenium.Selenium.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {

    /*
    1. Bir Class olusturalim YanlisEmailTesti
    2. http://automationpractice.com/index.php sayfasina gidelim
    3. Sign in butonuna basalim
    4. Email kutusuna @isareti olmayan bir mail yazip enter’a
    bastigimizda “Invalid email address” uyarisi ciktigini test edelim

     */
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));

    }
    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test1(){
        //2. https://www.automationexercise.com/test_cases sayfasina gidelim
        driver.get("https://www.automationexercise.com/test_cases");
        //    3. Sign in butonuna basalim
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        //    4. Email kutusuna @isareti olmayan bir mail yazip enter’a
        WebElement emailBox=driver.findElement(By.xpath("//*[@*='signup-email']"));
        emailBox.sendKeys("smhdmrgmail.com"+ Keys.ENTER);
        //    bastigimizda “Invalid email address” uyarisi ciktigini test edelim
    }
}
