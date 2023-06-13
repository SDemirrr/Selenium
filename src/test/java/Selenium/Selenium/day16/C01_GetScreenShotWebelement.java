package Selenium.Selenium.day16;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class C01_GetScreenShotWebelement extends TestBaseBeforeAfter {
    /*
    1-)Amazon sayfasina gidelim
    2-)nutella aratalim
    2-)arama sonucunun resmini alalim
     */
    @Test
    public void Test() throws IOException {
        //1-)Amazon sayfasina gidelim
        driver.get("https://amazon.com");

        //2-)nutella aratalim
     driver.findElement(By.id("twotabsearchtextbox"))
             .sendKeys("nutella"+ Keys.ENTER);

        //2-)arama sonucunun resmini alalim
        WebElement aramaSonucu= driver
                .findElement(By.xpath("//*[@*='a-section a-spacing-small a-spacing-top-small']"));

        File aramaSonucuSS=aramaSonucu.getScreenshotAs(OutputType.FILE);
        //Sadece Webelementin resmini alacaksak TakeScreenShot class'ini kullanmaya gerek yok
        //Locate ettigimiz webelementi direk gecici bir File'a atip FileUtils ile kopyalayip path'ini belirtiriz
        FileUtils.copyFile(aramaSonucuSS,new File("target/ekranGoruntusuWE/WebESS"+ tarih+".jpeg"));




    }
}
