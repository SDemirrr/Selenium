package Selenium.Selenium.day15;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_GetScreenShoot extends TestBaseBeforeAfter {

    @Test
    public void test1() throws IOException {
        //amazon sayfasina gidelim tum sayfanin resmini alalim
        driver.get("https:www.bestbuy.com");

        /*
        Bir websayfanin resmini alabilmek icin TakeScreenShoot class'indan obje olusturup
        Gecci File class'indan degiskene TakesScreenShoot'dan olusturdugum objeden getScreenshotAs();
        method'unu kullanarak gecici bir file olustururum
         */

        TakesScreenshot ts= (TakesScreenshot) driver;
        File tumSayfaResmi=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile
                (tumSayfaResmi,new File("target/ekranGoruntusu/AllPage"+tarih+".jpeg"));
    }
}
