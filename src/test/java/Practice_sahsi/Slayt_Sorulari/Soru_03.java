package Practice_sahsi.Slayt_Sorulari;

import org.junit.Test;
import utilities.TestBaseBeforeAfter;

public class Soru_03 extends TestBaseBeforeAfter {
    /*
    1. Yeni bir Class olusturalim.C06_ManageWindow
    2. Amazon soyfasina gidelim. https://www.amazon.com/
    3. Sayfanin konumunu ve boyutlarini yazdirin
    4. Sayfayi simge durumuna getirin
    5. simge durumunda 3 saniye bekleyip sayfayi maximize yapin
    6. Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
    7. Sayfayi fullscreen yapin
    8. Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
    9. Sayfayi kapatin

     */
    @Test
    public void test() throws InterruptedException {
        //1. Yeni bir Class olusturalim.C06_ManageWindow
        //2. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //3. Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Sayfanin konumu : "+driver.manage().window().getPosition());
        System.out.println("Sayfanin boyutlari : "+driver.manage().window().getSize());

        //4. Sayfayi simge durumuna getirin
        driver.manage().window().minimize();

        //5. simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(3000);
        driver.manage().window().maximize();

        //6. Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        System.out.println("Sayfanin konumu maximize sonrasi : "
                +driver.manage().window().getPosition());
        System.out.println("Sayfanin boyutlari maximize sonrasi : "
                +driver.manage().window().getSize());

        //7. Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();

        //8. Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        System.out.println("Sayfanin konumu fullScreen sonrasi : "
                +driver.manage().window().getPosition());
        System.out.println("Sayfanin boyutlari fullScreen sonrasi : "
                +driver.manage().window().getSize());
        //9. Sayfayi kapatin
    }
}
