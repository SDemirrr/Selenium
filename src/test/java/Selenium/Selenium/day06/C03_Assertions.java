package Selenium.Selenium.day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertions {
    /*
    1) Bir class oluşturun: YoutubeAssertions
    2) https://www.bestbuy.com adresine gidin
    3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
        ○ Sayfa Url'inin https://www.bestbuy.com/ 'a esit oldugunu test edin
        ○ titleTest=> Sayfa başlığının “Rest” icermedigini test edin
        ○ logoTest=>Bestbuy logosunun goruntulendigini test edin
        ○ FrancoisLinkTest => Fransizca linkin goruntulendigini test edin

     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        driver.manage().window().maximize();
        driver.get("https://www.bestbuy.com");

    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test1(){
        //○ Sayfa Url'inin https://www.bestbuy.com/ 'a esit oldugunu test edin
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

    }
    @Test
    public void test2(){
        //○ titleTest=> Sayfa başlığının “Rest” icermedigini test edin
        String expectedTitle="Rest";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains(expectedTitle));

    }
    @Test
    public void test3(){
        //○ logoTest=>Bestbuy logosunun goruntulendigini test edin
        WebElement bestBuyButton=driver.findElement(By.xpath("(//*[@*='logo'])[1]"));
        Assert.assertTrue(bestBuyButton.isDisplayed());

    }
    @Test
    public void test4(){
       //○ FrancoisLinkTest => Fransizca linkin goruntulendigini test edin
        WebElement link= driver.findElement(By.xpath("(//*[@*='fr'])[1]"));
        Assert.assertTrue(link.isDisplayed());

    }

}
