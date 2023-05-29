package Selenium.Selenium.day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C02_Actions extends TestBaseBeforeAfter {
    /*
    Yeni bir class olusturalim: D15_MouseActions4
    1- https://www.facebook.com adresine gidelim
    2- Yeni hesap olustur butonuna basalim
    3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
    4- Kaydol tusuna basalim

     */

    @Test
    public void test1() {
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

        //2- Yeni hesap olustur butonuna basalim
       WebElement element=driver.findElement(By.xpath("//*[@*='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
       element.click();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        //4- Kaydol tusuna basalim

       WebElement isim=driver.findElement(By.xpath("(//*[@*='inputtext _58mg _5dba _2ph-'])[1]"));
       isim.sendKeys("Semih");
       Actions actions=new Actions(driver);
       actions.sendKeys(Keys.TAB).sendKeys("Demir")
               .sendKeys(Keys.TAB).sendKeys("smhdmr@gmail.com")
               .sendKeys(Keys.TAB).sendKeys("demir4545")
               .sendKeys(Keys.TAB).sendKeys("demir4545")
               .sendKeys(Keys.TAB).sendKeys("16")
               .sendKeys(Keys.TAB).sendKeys("Nis")
               .sendKeys(Keys.TAB).sendKeys("1996")
               .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
               .sendKeys(Keys.TAB).sendKeys(Keys.RIGHT)
               .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
               .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
               .sendKeys(Keys.ENTER).perform();



    }
}
