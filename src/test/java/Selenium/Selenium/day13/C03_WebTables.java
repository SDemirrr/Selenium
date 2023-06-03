package Selenium.Selenium.day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class C03_WebTables extends TestBaseBeforeAfter  {

    //Bir onceki classdaki adrese gidelim
    //Login(); methodunu kullanarak sayfaya giris yapalim
    //input olarak verilen satir sayisi ve sutun sayisina sahip cell(hucre) deki text'leri yazdiralim
    //Price basligindaki tum numaralari yazdiriniz

    @Test
    public void test1(){
        //Bir onceki classdaki adrese gidelim
        //Login(); methodunu kullanarak sayfaya giris yapalim
        login();
        int satir=3;
        int sutun=4;
        //input olarak verilen satir sayisi ve sutun sayisina sahip cell(hucre) deki text'leri yazdiralim
        WebElement cell=
                driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println("Satir ve Sutundaki text  : "+cell.getText());

        //Price basligindaki tum numaralari yazdiriniz
        List<WebElement> price= driver.findElements(By.xpath("//tbody//tr//td[6]"));
        for (WebElement w:price) {
            System.out.println(w.getText());
        }
        //price.stream().forEach(t-> System.out.println(t.getText()));




    }

    private void login() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        Actions action=new Actions(driver);
        WebElement userName= driver.findElement(By.xpath("//*[@id='UserName']"));
        action.click(userName).sendKeys("manager")
                .sendKeys("Manager1").sendKeys(Keys.ENTER).perform();

    }
}
