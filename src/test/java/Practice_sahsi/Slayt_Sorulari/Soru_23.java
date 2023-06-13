package Practice_sahsi.Slayt_Sorulari;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class Soru_23 extends TestBaseBeforeAfter {
    /*
    ● Bir class oluşturun: DropDown
    ● https://the-internet.herokuapp.com/dropdown adresine gidin.
    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    4.Tüm dropdown değerleri(value) yazdırın
    5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
    False yazdırın
     */

    @Test
    public void test(){
        //● Bir class oluşturun: DropDown
        //● https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement ddm= driver.findElement(By.xpath("(//*[@*='dropdown'])"));
        Select options=new Select(ddm);
        options.selectByIndex(1);

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        options.selectByValue("2");

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        options.selectByVisibleText("Option 1");

        //4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> ddlist=options.getOptions();
        ddlist.stream().forEach(t-> System.out.println(t.getText()));

        //5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        //False yazdırın
        int actualDDListBoyutu=ddlist.size();
        int expectedDDListBoyut=4;
        if (actualDDListBoyutu==expectedDDListBoyut){
            System.out.println(true);
        }else {
            System.out.println(false);
        }

    }
}
