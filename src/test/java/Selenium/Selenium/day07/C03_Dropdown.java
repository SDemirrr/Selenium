package Selenium.Selenium.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C03_Dropdown {
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
    WebDriver driver;
    Select select;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        driver.get("https://amazon.com");
    }
    @After
    public void teardown(){
    driver.close();
    }

    @Test
    public void test1(){
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        //oldugunu test edin
        WebElement ddm=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
         select=new Select(ddm);
        /*
        Dropdown menuye ulasmak icin Select class'indan bir obje olustururuz
        ve locate ettigimiz dropdown Webelement'ini Select class'ina tanimlariz
        ve getOptions(); method'unu kullanarak dropdown'u bir List'e atarak dropdown
        menunun butun elementlerinin sayisina ulasabiliriz.
         */
        List<WebElement> ddmList=select.getOptions();
        System.out.println(ddmList.size());
        int expectedSayi=45;
        int actualSayi=ddmList.size();
        Assert.assertNotEquals(expectedSayi,actualSayi);
    }
    @Test
    public void test2(){
        //    1. Kategori menusunden Books secenegini secin
        WebElement ddm=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
       select=new Select(ddm);
       select.selectByVisibleText("Books");//eger Dropdown menudeki otion'a String olarak
        System.out.println(select.getFirstSelectedOption().getText());
        //ulasmak istersek bu method'u kullaniriz
       // select.selectByIndex(5);//Eger dropdawn menusunun indexiyle ulasmak istersek
        // bu method'u kullaniriz
        //select.selectByValue("search-alias=stripbooks-intl-ship");//eger dropdawn menusundeki
        //optiona value ile ulasmak istersek bu method'u kullaniriz


        //    2. Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+Keys.ENTER);
        //    3. Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisi=driver.
                findElement(By.xpath("//*[@*='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucSayisi.getText());
        String sonuc[]=sonucSayisi.getText().split(" ");
        System.out.println("Bulunan sonuc sayisi : "+sonuc[3]);

        //    4. Sonucun Java kelimesini icerdigini test edin
        String expectedKelime="Java";
        String actualKelime=sonucSayisi.getText();
        Assert.assertTrue(actualKelime.contains(expectedKelime));
        /*
        Sectigimiz option'a ulasmak istersek select.getFirstSelectedOption
        method'unu kullaniriz
         */


    }
}
