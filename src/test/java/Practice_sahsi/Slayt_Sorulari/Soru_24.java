package Practice_sahsi.Slayt_Sorulari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class Soru_24 extends TestBaseBeforeAfter {
    /*
    ● Bir class oluşturun: C3_DropDownAmazon
    ● https://www.amazon.com/ adresine gidin.
    - Test 1
    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
    oldugunu test edin
    -Test 2
    1. Kategori menusunden Books secenegini secin
    2. Arama kutusuna Java yazin ve aratin
    3. Bulunan sonuc sayisini yazdirin
    4. Sonucun Java kelimesini icerdigini test edin

     */

    @Test
    public void test1(){
        //● Bir class oluşturun: C3_DropDownAmazon
        //● https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");
        //- Test 1
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        //oldugunu test edin
     WebElement ddm=driver.findElement(By.xpath("(//*[@*='searchDropdownDescription'])[2]"));
        Select options=new Select(ddm);
        List<WebElement> ddmList=options.getOptions();
        System.out.println(ddmList.size());
        Assert.assertNotEquals(ddmList.size(),45);


        //-Test 2
        //1. Kategori menusunden Books secenegini secin
        options.selectByVisibleText("Books");

        //2. Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);

        //3. Bulunan sonuc sayisini yazdirin
        WebElement sonuc=driver.findElement(By.xpath("(//*[@*='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String sonucTam[]=sonuc.getText().split(" ");
        System.out.println("Bulunan sonuc sayisi : "+sonucTam[3]);

        //4. Sonucun Java kelimesini icerdigini test edin
        String expectedKelime="Java";
        String actualKelime=sonuc.getText();
        Assert.assertTrue(actualKelime.contains(expectedKelime));

    }

}
