package Selenium.Selenium.day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CheckBoxTest {

    /*
    1-Bir class olusturun : CheckBoxTest
    1-Gerekli yaoiyi olusturun ve asagidaki gorevi tamamlayi
       a-Verilen web sayfasina gidin
       https://the-internet.herokuapp.com/checboxes
       b-Checkbox1 ve ChecBoxTest2 elementlerini locate edin.
       c-Checkbox1 secili degilse onay kutusunu tiklayin
       d-Checkbox2 secili degilse onay kutusunu tiklayin
       */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));

    }
    @Test
    public void method1() throws InterruptedException {
        // a-Verilen web sayfasina gidin
        //  https://the-internet.herokuapp.com/checboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        // b-Checkbox1 ve ChecBoxTest2 elementlerini locate edin.
        WebElement checkbox1=driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement checkbox2=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        // c-Checkbox1 secili degilse onay kutusunu tiklayin
        Thread.sleep(2000);
        if (!checkbox1.isSelected()){
            checkbox1.click();
        }
        // d-Checkbox2 secili degilse onay kutusunu tiklayin
        Thread.sleep(2000);
        if (!checkbox2.isSelected()){
            checkbox2.click();
        }

    }

    @After
    public void tearDown(){
        driver.close();
    }
}
