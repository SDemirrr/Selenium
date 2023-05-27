package Selenium.Selenium.day09;

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
import java.util.ArrayList;
import java.util.List;

public class C04_WindowHandle {
    /*
    ● Tests package’inda yeni bir class olusturun: WindowHandle2
    ● https://the-internet.herokuapp.com/windows adresine gidin.
    ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    ● Click Here butonuna basın.
    ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    ● Sayfadaki textin “New Window” olduğunu doğrulayın.
    ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
    doğrulayın
     */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test1(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaHandle=driver.getWindowHandle();

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualText= driver.findElement(By.xpath("//h3")).getText();
        String expectedText="Opening a new window";
        Assert.assertEquals(actualText,expectedText);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle=driver.getTitle();
        String expectedTitle="The Internet";
        Assert.assertEquals(actualTitle,expectedTitle);

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("(//*[@*='_blank'])[1]")).click();
        /*
        Bir web sitesine gittiginizde bir webelementi tikladiginizda yeni bir sekme ya da
        yeni bir pencere acilirsa acilan yeni sekmenin handle degerini bulabilmek icin
        driver.getWindowhandles(); method'unu bir ArrayLst'e atip butun sayfalarin listesine ulasabilirim.ilk actigim sayfanin index'i 0
        ikinci acilan sekmenin indexi 1 dir. ikinci acilan sekmede islem yapabilmek icin :
        driver.switchTo().window(windowList.get(1)); yapariz.
         */
        List<String> windowList=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        String actualYeniPencereTitle=driver.getTitle();
        String expectedYeniPencereTitle="New Window";
        Assert.assertEquals(actualYeniPencereTitle,expectedYeniPencereTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
       String actualText2=driver.findElement(By.xpath("//h3")).getText();
       String expectedText2="New Window";
       Assert.assertEquals(actualText2,expectedText2);
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
        //doğrulayın
        driver.switchTo().window(windowList.get(0));
        Assert.assertEquals(driver.getTitle(),"The Internet");
    }

}
