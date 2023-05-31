package Practice_sahsi.Slayt_Sorulari;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Soru_14 extends TestBaseBeforeAfter {
    /*
    1 https://www.amazon.com/ sayfasina gidelim
    2 arama kutusunu locate edelim
    3 “Samsung headphones” ile arama yapalim
    4 Bulunan sonuc sayisini yazdiralim
    5 Ilk urunu tiklayalim
    6 Sayfadaki tum basliklari yazdiralim

     */

    @Test
    public void test(){
        //1 https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

        //2 arama kutusunu locate edelim
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));

        //3 “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones"+ Keys.ENTER);

        //4 Bulunan sonuc sayisini yazdiralim
        WebElement sonuc= driver.findElement(By.xpath("(//*[@*='sg-col-inner'])[1]"));
        String sonucArr[]=sonuc.getText().split(" ");
        System.out.println("Bulunan sonuc sayisi : "+sonucArr[2]);

        //5 Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//*[@*='a-section aok-relative s-image-fixed-height'])[1]")).click();

        //6 Sayfadaki tum basliklari yazdiralim
        System.out.println(driver.getTitle());


    }
}
