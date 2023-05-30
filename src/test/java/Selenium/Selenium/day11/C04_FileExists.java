package Selenium.Selenium.day11;

import com.github.javafaker.File;
import org.asynchttpclient.request.body.multipart.FilePart;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FileExists extends TestBaseBeforeAfter {

    @Test
    public void test1() {
        System.out.println(System.getProperty("user.dir"));
        //C:\deneme55
        //Suanki icinde bulundugu yolu gosterir

        System.out.println(System.getProperty("user.home"));
        //C:\deneme55
        //Gecerli kullanicinin ana dizinini verir

       /*
        String farkliBolum=System.getProperty("user.home");

        //C:\Users\semih\OneDrive\Masaüstü\Film=> filmler klasorundeki dosyanin yolu
        String ortakBolum="\\OneDrive\\Masaüstü\\Film";

        String masaustuDosyaYolu=farkliBolum+ortakBolum;
        //Masaustundeki dosya yolunu gosterir.

        System.out.println(masaustuDosyaYolu);
        //C:\Users\semih\OneDrive\Masaüstü\Film

        System.out.println(Files.exists(Path.of(masaustuDosyaYolu)));//true
        Assert.assertTrue(Files.exists(Path.of(masaustuDosyaYolu)));

        */

        String dosyaYolu="C:\\Users\\semih\\OneDrive\\Masaüstü\\txt.TXT";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));//true
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        /*
        Bir web siesinden indirdigimiz ya da window icinde olusturdugumuz dosyanin
        indigini ya da orda oldugunu test edebilmemiz icin o dosyanin uzerine SHIFT tusuna
        basili olarak SAG CLICK yapip DOSYA YOLUNU KOPYALAYIP bir STRING DEGISKENE atariz
        DOSYAYAI DOGRULAMAK ICIN :
        ***Assert.assertTrue(Files.exists(Paths.get(dosyaYolu))); metodunu kullaniriz
         */
    }
}
