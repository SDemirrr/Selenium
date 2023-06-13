package Practice_sahsi.Slayt_Sorulari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Soru_27 extends TestBaseBeforeAfter {
    /*
    1 Bir class olusturun : BasicAuthentication
    2 https://the-internet.herokuapp.com/basic_auth sayfasina gidin
    3 asagidaki yontem ve test datalarini kullanarak authentication’i yapin
    Html komutu : https://username:password@URL
    Username : admin
    password : admin
    4 Basarili sekilde sayfaya girildigini dogrulayin

     */

    @Test
    public void test1() {
        //1 Bir class olusturun : BasicAuthentication
        //2 https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        //3 asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //Html komutu : https://username:password@URL
        //Username : admin
        //password : admin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        //4 Basarili sekilde sayfaya girildigini dogrulayin
        WebElement sayfaGiris= driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(sayfaGiris.isDisplayed());
    }
}
