package Practice_sahsi.Slayt_Sorulari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Soru_12 extends TestBaseBeforeAfter {
    /*
    1-C01_TekrarTesti isimli bir class olusturun
    2- https://www.amazon.com/ adresine gidin
    3- Browseri tam sayfa yapin
    4- Sayfayi “refresh” yapin
    5 Sayfa basliginin “Spend less” ifadesi icerdigini test edin
    6 Gift Cards sekmesine basin
    7 Birthday butonuna basin
    8 Best Seller bolumunden ilk urunu tiklayin
    9- Gift card details’den 25 $’i secin
    10-Urun ucretinin 25$ oldugunu test edin
    10-Sayfayi kapatin
     */

    @Test
    public void test(){
        //1-C01_TekrarTesti isimli bir class olusturun
        //2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //3- Browseri tam sayfa yapin
        driver.manage().window().maximize();

        //4- Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //5 Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Spend less"));

        //6 Gift Cards sekmesine basin
        driver.findElement(By.xpath("//*[@*='nav_cs_3']")).click();

        //7 Birthday butonuna basin
        driver.findElement(By.xpath("(//*[@*='Birthday'])[1]")).click();

        //8 Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@*='Amazon.com eGift Card'])[1]")).click();

        //9- Gift card details’den 25 $’i secin
       WebElement giftCardDetails=driver.findElement(By.xpath("(//*[@*='gc-mini-picker-amount-1'])[1]"));
       giftCardDetails.click();

        //10-Urun ucretinin 25$ oldugunu test edin
        WebElement urunUcreti=driver.findElement(By.xpath("//*[@*='gc-live-preview-amount-container']"));
        Assert.assertTrue(urunUcreti.getText().contains("$25"));

        //10-Sayfayi kapatin
    }
}
