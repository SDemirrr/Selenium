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

public class C02_Alerts {

    /*
    ● Bir class olusturun: Alerts
    ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    ● Bir metod olusturun: acceptAlert
    ○1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    “You successfully clicked an alert” oldugunu test edin.
    ● Bir metod olusturun: dismissAlert
    ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    “successfuly” icermedigini test edin.
    ● Bir metod olusturun: sendKeysAlert
    ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

     */


    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void acceptAlert(){
        //○ 1.butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //“You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();

        String expectedUyari=driver.findElement(By.xpath("//*[@*='result']")).getText();
        String actualUyari="You successfully clicked an alert";

        Assert.assertEquals(expectedUyari,actualUyari);

    }

    @Test
    public void dismissAlert(){
        //○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //“successfuly” icermedigini test edin.
        driver.findElement(By.xpath("//*[@*='jsConfirm()']")).click();
        //Alert uzerindeki mesaji yazdirin
        System.out.println("Alert mesaji : "+driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();

        String expectedResultMesaji=driver.findElement(By.xpath("//*[text()='You clicked: Cancel']")).getText();
        String actualResultMesaji="successfuly";

        Assert.assertFalse(expectedResultMesaji.contains(actualResultMesaji));


    }

    @Test
    public void sendKeysAlert() throws InterruptedException {
        //○ 3.butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayin
        driver.findElement(By.xpath("//*[@*='jsPrompt()']")).click();
        //Alerts uzerindeki mesaji yazdirin
        System.out.println("3. Butonun alert mesaji : "+driver.switchTo().alert().getText());
       Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("semih demir");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        String isim="semih demir";
         String actualresultMesajIsim=driver.
                findElement(By.xpath("//*[text()='You entered: semih demir']")).getText();
         Assert.assertTrue(actualresultMesajIsim.contains(isim));



    }
}
