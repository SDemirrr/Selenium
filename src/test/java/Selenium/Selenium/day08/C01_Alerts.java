package Selenium.Selenium.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {
    /*
    1-https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
    2-Click for js Alert butonuna tiklayalim
    3-Tikladiktan sonra cikan uyari mesajina (Alert'e) tamam diyelim
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
    public void test1() throws InterruptedException {
        //1-https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //2-Click for js Alert butonuna tiklayalim
        driver.findElement(By.xpath("//*[@*='jsAlert()']")).click();

        //3-Tikladiktan sonra cikan uyari mesajina (Alert'e) tamam diyelim
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
    }
}
