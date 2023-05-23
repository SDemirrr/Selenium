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

public class C01_Iframe {
    /*
    ● Bir class olusturun: IframeTest
    ● https://the-internet.herokuapp.com/iframe adresine gidin.
    ● Bir metod olusturun: iframeTest
    ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
    ○Text Box’a “Merhaba Dunya!” yazin.
    ○TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
    dogrulayin ve konsolda yazdirin.

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
        //● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement text=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(text.isDisplayed());
        System.out.println(text.getText());

        //○Text Box’a “Merhaba Dunya!” yazin.
       /*
       ***index ile***
       List<WebElement> iframelist=
                new ArrayList<>(driver.findElements(By.xpath("//*[@*='mce_0_ifr']")));
        driver.switchTo().frame(iframelist.get(0));
        driver.findElement
                (By.xpath("//*[@*='tinymce']")).sendKeys("Merhaba Dunya!");

        */

        WebElement iframe=driver.findElement(By.xpath("//*[@*='mce_0_ifr']"));
        //Fram'e gecis yaptmadan once burayi xpath ile locate ederiz sonra locate ettigimiz
        driver.switchTo().frame(iframe);//fram'e gecis icin bu method'u kullaniriz

        WebElement textBox=driver.findElement
                (By.xpath("//p"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya!");


        //○TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //dogrulayin ve konsolda yazdirin.
        driver.switchTo().defaultContent();//iframe'den cikip ana sayfaya gecmek icin
        //bu method kullanilir

        WebElement linkText= driver.findElement(By.xpath("(//*[@*='_blank'])[2]"));
        Assert.assertTrue(linkText.isDisplayed());
        System.out.println(linkText.getText());


    }
}
