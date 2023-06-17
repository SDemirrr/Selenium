package Practice_sahsi.Slayt_Sorulari;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class Soru_29 extends TestBaseBeforeAfter {
    /*
    1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
     2) sayfadaki iframe sayısını bulunuz.
     3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
     4) ilk iframe'den çıkıp ana sayfaya dönünüz
     5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
     tıklayınız

     */

    @Test
    public void tets1(){
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> frameSayisi=driver.findElements(By.xpath("//iframe"));
        System.out.println("Sayfadaki iframe sayisi : "+frameSayisi.size());

        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement playButton= driver.findElement(By.xpath("(//*[@*='Oynat'])[1]"));
        driver.switchTo().frame(playButton);
        playButton.click();


        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().parentFrame();

        //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
        //tıklayınız
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        WebElement ikinciFrame= driver.findElement(By.xpath("//*[@*='Jmeter720.png']"));
        jse.executeScript("arguments[0].scrollIntoView(true);",ikinciFrame);
        driver.switchTo().frame(ikinciFrame);
        ikinciFrame.click();
    }
}
