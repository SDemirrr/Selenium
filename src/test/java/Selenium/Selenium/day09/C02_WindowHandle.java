package Selenium.Selenium.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_WindowHandle {
    /*
    1-Amzon sayfasina gidelim
    2-Url'in amazon icerdigini test edelim
    3-Yeni bir pencere acip bestby ana sayfsina gidelim(https://www.bestbuy.com)
    4-title'in best buy ecerdigini test edelim
    5-Ilk sayfaya gonup sayfada Java aratalim
    6-Arama sonuclarinin Java icerdigini test edelim
    7-yeniden bestbuy sayfasina gidelim
    8-logonun gorunurlugunu test edelim
    9-sayfalari kapatalim

     */

    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void test1() {
        //1-Amzon sayfasina gidelim
        driver.get("https://www.amazon.com");
        String syfa1HandleDegeri=driver.getWindowHandle();
        /*
        Eger bize verilen task'te sayfalar arasi  gecis varsa her driver.get(); methodundan
        sonra driver'in window handle degerini string bir degiskene atariz
        Sonrasinda farkli bir sayfaya ya da sekmeye gitiikten sonra tekrar ilk sayfaya
        donmemiz istenirse String degiskene atadigimiz window handle degerleriyle
        sayfalar arasi gecis yapabiliriz.
         */

        //2-Url'in amazon icerdigini test edelim
        String expectedUrl="amazon";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        //3-Yeni bir pencere acip bestbuy ana sayfsina gidelim(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String syfa2WindowHandleDegeri=driver.getWindowHandle();

        //4-title'in BestBuy icerdigini test edelim
        String expectedTitle="Best Buy";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //5-Ilk sayfaya gonup sayfada Java aratalim
        driver.switchTo().window(syfa1HandleDegeri);
        driver.findElement(By.xpath("(//*[@*='twotabsearchtextbox'])[2]")).
                sendKeys("java"+ Keys.ENTER);

        //6-Arama sonuclarinin java icerdigini test edelim
        String actualKelime= driver.
                findElement(By.xpath("//*[@*='a-section a-spacing-small a-spacing-top-small']")).
                getText();
        String expectedKelime="java";
        Assert.assertTrue(actualKelime.contains(expectedKelime));

        //7-yeniden bestbuy sayfasina gidelim
        driver.switchTo().window(syfa2WindowHandleDegeri);

        //8-logonun gorunurlugunu test edelim
        WebElement logo=driver.findElement(By.xpath("(//*[@*='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());


    }
}
