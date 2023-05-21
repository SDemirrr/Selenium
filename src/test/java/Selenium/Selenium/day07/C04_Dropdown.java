package Selenium.Selenium.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

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
        //driver.close();

    }
    @Test
    public void test1(){

    }
}
