package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertions {
    /*
   -Amazon sayfasina gidelim
   -3 farkli test method'u olusturalim
     a-Url'in amazon icerdigini test edelim
     b-Title'in facebook icermedigini test edelim
     c-sol ust kosede amazon logosunun gorundugunu test edelim
     */

    static WebDriver  driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        driver.get("https://amazon.com");
    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }

    @Test
    public void test1(){
        //a-Url'in https://facebook.com oldugunu test edelim
        String expectedUrl="https://facebook.com";
        String actualUrl=driver.getCurrentUrl();
        //Assert.assertEquals("Url'ler esit gegilse",expectedUrl,actualUrl);
        Assert.assertNotEquals(expectedUrl,actualUrl);

    }
    @Test
    public void test2(){
        //b-Title'in facebook icermedigini test edelim
        String actualTitle="facebook";
        String expectedTitle= driver.getTitle();
        Assert.assertFalse(expectedTitle.contains(actualTitle));

    }
    @Test
    public void test3(){
        //c-sol ust kosede amazon logosunun gorundugunu test edelim
        Assert.assertTrue(driver.findElement(By.id("nav-logo-sprites")).isDisplayed());

    }


}
