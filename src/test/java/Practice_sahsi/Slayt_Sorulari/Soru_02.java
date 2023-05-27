package Practice_sahsi.Slayt_Sorulari;

import org.junit.Test;
import utilities.TestBaseBeforeAfter;

public class Soru_02 extends TestBaseBeforeAfter {
    /*
    1. Yeni bir Class olusturalim.C05_NavigationMethods
    2. Youtube ana sayfasina gidelim . https://www.youtube.com/
    3. Amazon soyfasina gidelim. https://www.amazon.com/
    4. Tekrar YouTube’sayfasina donelim
    5. Yeniden Amazon sayfasina gidelim
    6. Sayfayi Refresh(yenile) yapalim
    7. Sayfayi kapatalim / Tum sayfalari kapatalim

     */

    @Test
    public void test(){
        //1. Yeni bir Class olusturalim.C05_NavigationMethods
        //2. Youtube ana sayfasina gidelim . https://www.youtube.com/
        driver.get("https://www.youtube.com/");

        //3. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //4. Tekrar YouTube’sayfasina donelim
        driver.navigate().back();

        //5. Yeniden Amazon sayfasina gidelim
        driver.navigate().forward();

        //6. Sayfayi Refresh(yenile) yapalim
        driver.navigate().refresh();

        //7. Sayfayi kapatalim / Tum sayfalari kapatalim
        //driver.quit();
    }
}
