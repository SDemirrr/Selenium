package Selenium.Selenium.day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

public class C01_Cookies extends TestBaseBeforeAfter {
    /*
    1-Amazon anasayfaya gidin
    2-tum cookie’leri listeleyin
    3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
    4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
    5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
    olusturun ve sayfaya ekleyin
    6-eklediginiz cookie’nin sayfaya eklendigini test edin
    7-ismi skin olan cookie’yi silin ve silindigini test edin
    8-tum cookie’leri silin ve silindigini test edin

     */

    @Test
    public void test(){
        //1-Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //2-tum cookie’leri listeleyin
       Set<Cookie> tumCookie=driver.manage().getCookies();
        System.out.println(tumCookie);
        int sayac=1;

        for (Cookie w:tumCookie) {
            System.out.println(sayac+".ci cookie : "+w);
            System.out.println(sayac+".ci name : "+w.getName());
            System.out.println(sayac+".ci value : "+w.getValue());
            sayac++;
        }

        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(tumCookie.size()>5);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie w:tumCookie) {
            if (w.getName().equals("i18n-prefs")){
                Assert.assertEquals("USD",w.getValue());
            }
        }

        //5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
        //olusturun ve sayfaya ekleyin
        tumCookie=driver.manage().getCookies();
        Cookie yeniCookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(yeniCookie);

        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
       Assert.assertTrue(tumCookie.contains(yeniCookie));

        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        tumCookie=driver.manage().getCookies();
         sayac=1;
         for (Cookie w:tumCookie) {
            System.out.println(sayac+".ci cookie : "+w);
            System.out.println(sayac+".ci name : "+w.getName());
            System.out.println(sayac+".ci value : "+w.getValue());
            sayac++;
        }
         Cookie isim=driver.manage().getCookieNamed("skin");
         Assert.assertFalse(tumCookie.contains(isim));

        //8-tum cookie’leri silin ve silindigini test edin
        tumCookie=driver.manage().getCookies();
        driver.manage().deleteAllCookies();
        Assert.assertTrue(tumCookie.isEmpty());
    }
}
