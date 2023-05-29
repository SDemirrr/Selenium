package Selenium.Selenium.day11;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import javax.swing.*;

public class C03_Faker extends TestBaseBeforeAfter {
    /*
    1. "https://facebook.com" Adresine gidin
    2. “create new account” butonuna basin
    3. “firstName” giris kutusuna bir isim yazin
    4. “surname” giris kutusuna bir soyisim yazin
    5. “email” giris kutusuna bir email yazin
    6. “email” onay kutusuna emaili tekrar yazin
    7. Bir sifre girin
    8. Tarih icin gun secin
    9. Tarih icin ay secin
    10. Tarih icin yil secin
    11. Cinsiyeti secin
    12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
    13. Sayfayi kapatin


     */
    /*
    Faker classini kullanma amacimiz form doldurmamaiz gereken
    web sitelerde defalarca kendi uretecegimiz veriler yerine bizim icin random veriler uretir ve
    isimizi kolaylastirir.

    Faker classini kullanmak icin mvnrepository.com adresinden java-faker aratir
    ve en cok kullanilan pom.xml dosyasini ekleriz ve faker class''indan bir obje olusturup;
    email icin faker.internet() methodunu kullanarak emailAdress(); method'unu seceriz
    passvord icin de internet() methodunu kullaniriz
    isim ve soyisimler icin faker.name() methodu ile firstname() ve lastName() methodunu kullaniriz
     */

    @Test
    public void test1() {
        //1. "https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");

        //    2. “create new account” butonuna basin
        driver.findElement(By.xpath("//*[@*='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //    3. “firstName” giris kutusuna bir isim yazin
        Faker faker=new Faker();
        Actions actions=new Actions(driver);
        WebElement isim=driver.findElement(By.xpath("(//*[@*='inputtext _58mg _5dba _2ph-'])[1]"));
        String email=faker.internet().emailAddress();//AYNI MAIL GIRMESI ICIN ATAMA YAPTIK
        actions.click(isim).sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB).sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB).sendKeys(email)
                .sendKeys(Keys.TAB).sendKeys(email)
                .sendKeys(Keys.TAB).sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB).sendKeys("16")
                .sendKeys(Keys.TAB).sendKeys("Nis")
                .sendKeys(Keys.TAB).sendKeys("1996")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.RIGHT)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
        //    4. “surname” giris kutusuna bir soyisim yazin
        //    5. “email” giris kutusuna bir email yazin
        //    6. “email” onay kutusuna emaili tekrar yazin
        //    7. Bir sifre girin
        //    8. Tarih icin gun secin
        //    9. Tarih icin ay secin
        //    10. Tarih icin yil secin
        //    11. Cinsiyeti secin
        //    12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        //    13. Sayfayi kapatin

    }
}
