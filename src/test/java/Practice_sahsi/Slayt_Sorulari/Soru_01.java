package Practice_sahsi.Slayt_Sorulari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Soru_01 extends TestBaseBeforeAfter {

    /*
    1. Yeni bir package olusturalim : day01
    2. Yeni bir class olusturalim : C03_GetMethods
    3. Amazon sayfasina gidelim. https://www.amazon.com/
    4. Sayfa basligini(title) yazdirin
    5. Sayfa basliginin “Amazon” icerdigini test edin
    6. Sayfa adresini(url) yazdirin
    7. Sayfa url’inin “amazon” icerdigini test edin.
    8. Sayfa handle degerini yazdirin
    9. Sayfa HTML kodlarinda “Gateway” kelimesi gectigini test edin
    10. Sayfayi kapatin.

     */

    @Test
    public void test() {
        //3. Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com");

        //4. Sayfa basligini(title) yazdirin
        System.out.println("Sayfa Basligi : "+driver.getTitle());

        //5. Sayfa basliginin “Amazon” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

        //6. Sayfa adresini(url) yazdirin
        System.out.println("Sayfa Url'i : "+driver.getCurrentUrl());

        //7. Sayfa url’inin “amazon” icerdigini test edin.
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon") );

        //8. Sayfa handle degerini yazdirin
        System.out.println("Sayfa Handle Degeri : "+driver.getWindowHandle());

        //9. Sayfa HTML kodlarinda “Gateway” kelimesi gectigini test edin
        WebElement htmlKod= driver.findElement(By.xpath("//*[@*='en-us']"));
        Assert.assertFalse(htmlKod.getText().contains("Gateway"));

    }
}
