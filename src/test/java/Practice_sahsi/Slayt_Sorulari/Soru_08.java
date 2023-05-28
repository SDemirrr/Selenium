package Practice_sahsi.Slayt_Sorulari;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Soru_08 extends TestBaseBeforeAfter {
    /*
    1. Bir class oluşturun : AmazonSearchTest
    2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
    a.web sayfasına gidin. https://www.amazon.com/
    b. Search(ara) “city bike”
    c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
    d. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.

     */

    @Test
    public void test(){
        //a.web sayfasına gidin. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //b. Search(ara) “city bike”
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("city bike"+ Keys.ENTER);

        //c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        WebElement sonuc= driver.
                findElement(By.xpath("(//*[@*='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String[] sonucSayisi =sonuc.getText().split(" ");
       System.out.println("Goruntulenen sonuc sayisi : "+sonucSayisi[2]);

       //d. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
        driver.findElement(By.xpath("(//*[@*='s-image'])[1]"))
                .click();
    }
}
