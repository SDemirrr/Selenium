package Selenium.Selenium.day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;


public class C02_WebTables extends TestBaseBeforeAfter {
    /*
    ● Bir class oluşturun : C02_WebTables
    ● login( ) metodun oluşturun ve oturum açın.
    ● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
    ○ Username : manager
    ○ Password : Manager1!
    ● table( ) metodu oluşturun
    ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun.
    ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
    ● printRows( ) metodu oluşturun //tr
    ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
    ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
    ○ 4.satirdaki(row) elementleri konsolda yazdırın.

     */

    @Test
    public void test1(){
        //● Bir class oluşturun : C02_WebTables
        //● login( ) metodun oluşturun ve oturum açın.
        login();

        //● table( ) metodu oluşturun
        table();

        //● printRows( ) metodu oluşturun //tr
        printRows();

    }

    private void printRows() {
        //○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirList= driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Tablodaki Satir Sayisi : "+satirList.size());

        //○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        satirList.stream().forEach(t-> System.out.println("satirlar : "+t.getText()));

        //○ 4.satirdaki(row) elementleri konsolda yazdırın.
        WebElement dorduncuSatir=driver.findElement(By.xpath("//tbody//tr[4]"));
        System.out.println("Tablodaki 4. Satir : "+dorduncuSatir.getText());

    }

    private void table() {
        /*
        ***Tabloda <table> tagi altinda tablonun basligini gosteren <thead> tagi bulunur.
        Eger baslikta satir(row) varsa <thead> tagi altinda <tr>(satir-row) tagi vardir ve
        baslktaki sutunlara yani hucrelere(cell) de <th> tagi ile ulasilir.
        Basligin altindaki tablodaki verilere  <tbody> tagi ile altindaki satirlara(row)
        <tr> tagi ile sutunlara yani hucrelere(cell) <td> tagi ile ulasilir.

         */
        //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun.
        List<WebElement> sutunSayisi=driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("Sutun sayisi : "+sutunSayisi.size());

        //○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement basliklar= driver.findElement(By.xpath("//thead//tr"));
        System.out.println("Tablodaki Basliklar  : "+basliklar.getText());
        WebElement body=driver.findElement(By.xpath("//tbody//"));
        System.out.println("Tum Body"+body.getText());
    }

    private void login() {
        //● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");

        //○ Username : manager
        //○ Password : Manager1!
        Actions actions=new Actions(driver);
        WebElement userName= driver.findElement(By.xpath("//*[@*='userName']"));
        actions.click(userName).sendKeys("menager")
                .sendKeys(Keys.TAB)
                .sendKeys("Manager1")
                .sendKeys(Keys.ENTER).perform();

    }
}
