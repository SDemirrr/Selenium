package Practice_sahsi.Slayt_Sorulari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Soru_26 extends TestBaseBeforeAfter {
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

    @Test
    public void test1() {
        //● Bir class olusturun: Alerts
        //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //● Bir metod olusturun: acceptAlert
        //○1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //“You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//*[@*='jsAlert()']")).click();
        driver.switchTo().alert().accept();
        String expectedText="You successfully clicked an alert";
        String actualText=driver.findElement(By.xpath("//*[@*='result']")).getText();
        Assert.assertEquals(expectedText,actualText);

        //● Bir metod olusturun: dismissAlert
        //○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //“successfuly” icermedigini test edin.
        driver.findElement(By.xpath("//*[@*='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        String expectedResultMesaji="successfuly";
        String actualResultMesaji=driver.findElement(By.xpath("//*[@*='result']")).getText();
        Assert.assertFalse(actualResultMesaji.contains(expectedResultMesaji));

        //● Bir metod olusturun: sendKeysAlert
        //○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("//*[@*='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("semih");
        driver.switchTo().alert().accept();
        String expectedResultMesajiIsim="semih";
        String actualResultMesajiIsim=driver.findElement(By.xpath("//*[@*='result']")).getText();
        Assert.assertTrue(actualResultMesajiIsim.contains(expectedResultMesajiIsim));
    }
}
