package Selenium.Selenium.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BasicAuthentication {
    /*
    1 Bir class olusturun : BasicAuthentication
    2 https://the-internet.herokuapp.com/basic_auth sayfasina gidin
    3 asagidaki yontem ve test datalarini kullanarak authentication’i yapin
    Html komutu : https://username:password@URL
    Username : admin
    password : admin
    4 Basarili sekilde sayfaya girildigini dogrulayin

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
    public void test(){
        //2 https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        //3 asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //Html komutu : https://username:password@URL
        //Username : admin
        //password : admin
        //4 Basarili sekilde sayfaya girildigini dogrulayin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

       Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
    }

}
