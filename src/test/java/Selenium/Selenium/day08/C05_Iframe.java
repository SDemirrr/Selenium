package Selenium.Selenium.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C05_Iframe {
    /*

     */
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));

    }
    @After
    public void tearDown(){
        // driver.close();
    }

    @Test
    public void test1(){
        //https://html.com/tags/iframe/ bu adrese gidiniz
        driver.get("https://html.com/tags/iframe/");

       /*
        1. yol index ile :
        =>Bir websitesinde bir vido(youtube vs) varsa ve <iframe> tag'i icerisindeyse
        bu videoyu direkt locate edip calistirmak dinamik olmaz cunku link degisebilir ve
        locate'imiz calismaz bunun icin butun frame'leri bir list'e atip INDEX ile frame'i
        secip sonrasinda play tusunu licate edip calistirabiliriz.

        ***ORNEK***
        List<WebElement> iframeList=
                new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        driver.switchTo().frame(iframeList.get(0));

        driver.findElement(By.xpath("(//*[@*='Oynat'])[1]")).click();
        */


        //youtube videosunu calistiriniz

        //2. yol Webelement ile :
        //***ORNEK : ***
        WebElement youtubeFrame=driver.
                findElement(By.xpath("//*[@*='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(youtubeFrame);
        driver.findElement(By.xpath("(//*[@*='Oynat'])[1]")).click();
    }
}
