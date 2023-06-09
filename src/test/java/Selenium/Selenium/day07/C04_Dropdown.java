package Selenium.Selenium.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C04_Dropdown {
    /*
    ● Bir class oluşturun: DropDown
    ● https://the-internet.herokuapp.com/dropdown adresine gidin.
    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    4.Tüm dropdown değerleri(value) yazdırın
    5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
    False yazdırın.

     */
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
    }
    @After
    public void teardown(){
        driver.close();

    }
    @Test
    public void test1(){
        // ● https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement ddm=driver.findElement(By.xpath("//*[@*='dropdown']"));
        Select select=new Select(ddm);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("============================");

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("============================");

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        //veya => ddm.sendKeys("Option1");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("============================");

        //4.Tüm dropdown değerleri(value) yazdırın
       List<WebElement> dropdownDegerleri =select.getOptions();
       dropdownDegerleri.forEach(t-> System.out.println(t.getText()));
        System.out.println("============================");
        //lambda =>
        dropdownDegerleri.forEach(t-> System.out.println(t.getText()));
        System.out.println("============================");
        for (WebElement w:dropdownDegerleri) {
            System.out.println(w.getText());}
        System.out.println("============================");
        System.out.println(select.getAllSelectedOptions().get(0).getText());
        System.out.println("============================");

        //5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse  //False yazdırın.
        System.out.println("Dropdown Boyutu : "+dropdownDegerleri.size());
        int expectedDdBoyut=4;
        int actualDdBoy=dropdownDegerleri.size();
        if (actualDdBoy==expectedDdBoyut){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
       Assert.assertNotEquals(expectedDdBoyut,actualDdBoy);



    }
}
