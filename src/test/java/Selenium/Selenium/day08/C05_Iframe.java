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

        //youtube videosunu calistiriniz
        WebElement youtubeFrame=driver.
                findElement(By.xpath("//*[@*='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(youtubeFrame);
        driver.findElement(By.xpath("(//*[@*='Oynat'])[1]")).click();
    }
}