package Practice_sahsi.Slayt_Sorulari;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import utilities.TestBaseBeforeAfter;

public class Soru_04 extends TestBaseBeforeAfter {
    /*
    1. Yeni bir Class olusturalim.C07_ManageWindowSet
     2. Amazon soyfasina gidelim. https://www.amazon.com/
     3. Sayfanin konumunu ve boyutlarini yazdirin
     4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
     5. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
     8. Sayfayi kapatin

     */

    @Test
    public void test(){
        //1. Yeni bir Class olusturalim.C07_ManageWindowSet
        //2. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //3. Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Sayfanin konumu : "+driver.manage().window().getPosition());
        System.out.println("Sayfanin Boyutlari  : "+driver.manage().window().getSize());

        //4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        driver.manage().window().setPosition(new Point(200,200));
        driver.manage().window().setSize(new Dimension(300,300));

        //5. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        System.out.println("Sayfanin konumu 2 : "+driver.manage().window().getPosition());
        System.out.println("Sayfanin Boyutlari 2 : "+driver.manage().window().getSize());

        //8. Sayfayi kapatin
    }
}
