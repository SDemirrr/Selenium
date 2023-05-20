package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Odev {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'New User Signup!' is visible
    6. Enter name and email address
    7. Click 'Signup' button
    8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    9. Fill details: Title, Name, Email, Password, Date of birth
    10. Select checkbox 'Sign up for our newsletter!'
    11. Select checkbox 'Receive special offers from our partners!'
    12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    13. Click 'Create Account button'
    14. Verify that 'ACCOUNT CREATED!' is visible
    15. Click 'Continue' button
    16. Verify that 'Logged in as username' is visible
    17. Click 'Delete Account' button
    18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

       */
   static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
    }
    @AfterClass
    public static void tearDown(){
       // driver.quit();
    }

    @Test
    public void method1(){
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        // 3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[@lang='en']")).isDisplayed());
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();
        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='New User Signup!']")).isDisplayed());
       //6. Enter name and email address
        driver.findElement(By.xpath("//*[@*='signup-name']")).sendKeys("semih");
        driver.findElement(By.xpath("//*[@*='signup-email']")).sendKeys("smh123@gmail.com");
       //7. Click 'Signup' button
        driver.findElement(By.xpath("//*[@*='signup-button']")).click();
       //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Enter Account Information']")).isDisplayed());
       //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//*[@*='id_gender1']")).click();
        driver.findElement(By.xpath("(//*[@*='form-control'])[3]")).sendKeys("12345");
       //10. Select checkbox 'Sign up for our newsletter!'
       //11. Select checkbox 'Receive special offers from our partners!'
       //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
       //13. Click 'Create Account button'
       //14. Verify that 'ACCOUNT CREATED!' is visible
       //15. Click 'Continue' button
       //16. Verify that 'Logged in as username' is visible
       //17. Click 'Delete Account' button
       //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

    }

}
