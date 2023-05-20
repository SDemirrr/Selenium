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
   -4 farkli test method'u olusturalim
     a-Url'in amazon icerdigini test edelim
     b-Title'in facebook icermedigini test edelim
     c-sol ust kosede amazon logosunun gorundugunu test edelim
     d-Url'in www.facebook.com oldugunu test edelim
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
        //a-Url'in facebook oldugunu test edelim
        String expectedUrl="facebook";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertFalse(expectedUrl.contains(actualUrl));
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
    @Test
    public void test4(){
       // d-Url'in www.facebook.com oldugunu test edelim
       String expectedUrl= "www.facebook.com";
       String actualUrl=driver.getCurrentUrl();
       Assert.assertNotEquals(expectedUrl, actualUrl);
    }


}
