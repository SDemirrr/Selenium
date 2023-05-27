package Selenium.Selenium.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_WindowHandle {
    /*
    ● Yeni bir class olusturun: WindowHandle
    ● Amazon anasayfa adresine gidin.
    ● Sayfa’nin window handle degerini String bir degiskene atayin
    ● Sayfa title’nin “Amazon” icerdigini test edin
    ● Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
    ● Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
    ● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
    ● Sayfa title’nin “Walmart” icerdigini test edin
    ● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin

     */

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        //driver.quit();
    }

    @Test
    public void test1(){
        //● Amazon anasayfa adresine gidin.
        driver.get("https://amazon.com");

        //● Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonWindowHandleDegeri= driver.getWindowHandle();

        //● Sayfa title’nin “Amazon” icerdigini test edin
        String expectedTitle="Amazon";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //● Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com");
        String techproWidowHandleDegeri=driver.getWindowHandle();

        //● Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        String expectedTchpro=driver.getTitle();
        String actualTchpro="TECHPROEDUCATION";
        Assert.assertFalse(expectedTchpro.contains(actualTchpro));

        //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.wallmart.com");
        String wallmartWindowHandle=driver.getWindowHandle();

        //● Sayfa title’nin “Walmart” icerdigini test edin
        String actualWallmartTitle=driver.getTitle();
        String expectedWallmartTitle="Wallmart";
        Assert.assertTrue(actualWallmartTitle.contains(expectedWallmartTitle));

        //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonWindowHandleDegeri);
        Assert.assertTrue(driver.getTitle().contains(actualTitle));

    }
}
