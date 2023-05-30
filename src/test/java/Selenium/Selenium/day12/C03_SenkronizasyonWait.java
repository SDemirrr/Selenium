package Selenium.Selenium.day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C03_SenkronizasyonWait extends TestBaseBeforeAfter {
    /*
    1. Bir class olusturun : WaitTest
    2. Iki tane metod olusturun : implicitWait() , explicitWait()
    Iki metod icin de asagidaki adimlari test edin.
    3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    4. Remove butonuna basin.
    5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    6. Add buttonuna basin
    7. It’s back mesajinin gorundugunu test edin

     */

    @Test
    public void implicitlyWaitTest1(){
       /*
       implicitlyWait(); kullanidigimiz sayfadaki butun Webelementler icin
       max belirttigimiz sure icinde butun webElementler icin bekler
        */
        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[@*='swapCheckbox()']")).click();

        // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@*='message']")).isDisplayed());

        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        // 7. It’s back mesajinin gorundugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@*='message']")).isDisplayed());

    }

    @Test
    public void explicitlyWaitTest2(){

         /*
       explicitlyWait itsGunWE gorunu olmasini beklerken  o webelementinin locatini
       kullanarak Assert yapmak sorun olur ve exception firlatir.Henuz gorulmayan bir webelemntin
       locate edilmesi de otomasyon icin mumkun olmax bu durumda bekleme islemi icin
       explicitlyWait'i locate ile birlikte kullaniriz.
       */

        //    3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //    4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[@*='swapCheckbox()']")).click();
        //    5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        WebElement itsGoneWE=wait
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//*[@*='message']")));
        Assert.assertTrue(itsGoneWE.isDisplayed());

        //    6. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        //    7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackWE=wait.
                until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//*[@*='message']")));
        Assert.assertTrue(itsBackWE.isDisplayed());
    }


}
