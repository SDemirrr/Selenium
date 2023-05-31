package Practice_sahsi.Slayt_Sorulari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Soru_21 extends TestBaseBeforeAfter {
    /*
    1) Bir class oluşturun: YoutubeAssertions
    2) https://www.youtube.com adresine gidin
    3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    ○ titleTest
    ○ imageTest
    => Sayfa başlığının “YouTube” oldugunu test edin
    => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

     */

    @Test
    public void test1(){
        //1) Bir class oluşturun: YoutubeAssertions
        //2) https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");



    }

    @Test
    public void test2(){
        //=> Sayfa başlığının “YouTube” oldugunu test edin
        driver.get("https://www.youtube.com");
        Assert.assertEquals(driver.getTitle(), "YouTube");

        //=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement resim= driver.findElement(By.xpath("(//*[@*='external-icon'])[1]"));
        Assert.assertTrue(resim.isDisplayed());

    }

    @Test
    public void test3(){
        driver.get("https://www.youtube.com");

        //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@*='search'])[3]")).isEnabled());

        //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        Assert.assertFalse(driver.getTitle().equals("youtube"));

    }
}
