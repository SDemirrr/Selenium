package Practice_sahsi.Slayt_Sorulari;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeAfter;

public class Soru_06 extends TestBaseBeforeAfter {
    /*
    1. Yeni bir class olusturun (TekrarTesti)
    2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını
    doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
    3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa
    doğru URL'yi yazdırın.
    4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
    5. Youtube sayfasina geri donun
    6. Sayfayi yenileyin
    7. Amazon sayfasina donun
    8. Sayfayi tamsayfa yapin
    9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın,
    Yoksa doğru başlığı(Actual Title) yazdırın.
    10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru
    URL'yi yazdırın
    11.Sayfayi kapatin

     */

    @Test
    public void test(){

       //1. Yeni bir class olusturun (TekrarTesti)
       //2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını
        driver.get("https://www.youtube.com");
        //doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        Assert.assertFalse(driver.getTitle().contains("youtube"));

       //3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa
       //doğru URL'yi yazdırın.
        if (!driver.getCurrentUrl().contains("youtube")){
            System.out.println(driver.getCurrentUrl());
        }

        //4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.get("https://www.amazon.com");

       //5. Youtube sayfasina geri donun
        driver.navigate().back();

       //6. Sayfayi yenileyin
        driver.navigate().refresh();

       //7. Amazon sayfasina donun
        driver.navigate().forward();

       //8. Sayfayi tamsayfa yapin
        driver.manage().window().fullscreen();

       //9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın,
       //        Yoksa doğru başlığı(Actual Title) yazdırın.
        if (driver.getTitle().contains("Amazon")){
            System.out.println("Sayfa Amazon icermektedir");
        }else {
            System.out.println("Sayfa Amazon icermemektedir Baslik : "+driver.getTitle());
        }

       //10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru
       //URL'yi yazdırın
        if (driver.getCurrentUrl().equals("https://www.amazon.com/ ")){
            System.out.println("Sayfa Url'i text ile aynidir");
        }else {
            System.out.println("Sayfa Url'i text ile ayni degildir : "+driver.getCurrentUrl());
        }
       //11.Sayfayi kapatin
        }
}
