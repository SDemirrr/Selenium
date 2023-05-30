package Selenium.Selenium.day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileExists extends TestBaseBeforeAfter {
    /*
    1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
    2. iki tane method olusturun : isExist(); ve downloadTest();
    3. downloadTest(); methodunun icinde asagidaki testi yapalim
        -https://the-internet.herokuapp.com/download adresine gidelim
        -text.txt dosyasını indirelim
    4.Ardindan isExist(); methodunda dosyanin basariyla indirilip indirilmedigini
    test edelim

     */

    @Test
    public void downloadTest() {
        //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
        //2. iki tane method olusturun : isExist(); ve downloadTest();
        //3. downloadTest(); methodunun icinde asagidaki testi yapalim
        //    -https://the-internet.herokuapp.com/download adresine gidelim
        driver.get("https://the-internet.herokuapp.com/download");

        //    -text.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='testing.txt']")).click();

    }

    @Test
    public void isExist(){
        //4.Ardindan isExist(); methodunda dosyanin basariyla indirilip indirilmedigini
        //test edelim
        String dosyaYolu="C:\\Users\\semih\\Downloads\\testing.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        //indirildigini konsolda test edin
        System.out.println("Dosya Yolu : "+Files.exists(Paths.get(dosyaYolu)));

    }
}
