package Selenium.Selenium.day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C02_FileExistsUpload extends TestBaseBeforeAfter {
    /*
    1. Tests packagenin altina bir class oluşturun : C05_UploadFile
    2. https://the-internet.herokuapp.com/upload adresine gidelim
    3. chooseFile butonuna basalim
    4. Yuklemek istediginiz dosyayi secelim.
    5. Upload butonuna basalim.
    6. “File Uploaded!” textinin goruntulendigini test edelim.

     */

    @Test
    public void test1() {
        //1. Tests packagenin altina bir class oluşturun : C05_UploadFile
        //2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //3. chooseFile butonuna basalim
        WebElement dosyaSec=driver.findElement(By.xpath("(//*[@*='file'])[1]"));
        /*
        doyaSec butonuna direkt click yapamayabiliriz cunku windowsa mudaheleye izin
        vermeyebilir.Bu yuzden dosyaSec butonun direkt locate edip
        sendKeys(); method'u ile String degiskene atadigimiz dosya yolumuzu gonedririz.
         */


        //4. Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu="C:\\Users\\semih\\Downloads\\testing.txt";
        dosyaSec.sendKeys(dosyaYolu);

        //5. Upload butonuna basalim.
        driver.findElement(By.xpath("//*[@*='button']")).click();

        //6. “File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
    }
}
