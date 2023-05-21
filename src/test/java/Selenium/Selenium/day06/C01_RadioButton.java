package Selenium.Selenium.day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_RadioButton {
    /*
    1. Bir class oluşturun : RadioButtonTest
    2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    - https://www.facebook.com adresine gidin
    - Cookies’i kabul edin
    - “Create an Account” button’una basin
    - “radio buttons” elementlerini locate edin
    - Secili degilse cinsiyet butonundan size uygun olani secin
     */
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void teardown() {
       // driver.close();
    }
    @Test
    public void method1(){
        //- https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        //    - Cookies’i kabul edin
        //    - “Create an Account” button’una basin
        driver.findElement(By.xpath("//*[@*='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //    - “radio buttons” elementlerini locate edin
        WebElement femaleButton= driver.findElement(By.xpath("(//*[@*='_8esa'])[1]"));
        WebElement maleButton= driver.findElement(By.xpath("(//*[@*='_8esa'])[2]"));
        WebElement ozelButton= driver.findElement(By.xpath("(//*[@*='_8esa'])[3]"));
        //    - Secili degilse cinsiyet butonundan size uygun olani secin
        if (!maleButton.isSelected()){
            maleButton.click();
        }


    }
}
