package Practice_sahsi.Slayt_Sorulari;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Soru_20 extends TestBaseBeforeAfter {
    /*
    1. Bir class oluşturun : RadioButtonTest
    2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    - https://www.facebook.com adresine gidin
    - Cookies’i kabul edin
    - “Create an Account” button’una basin
    - “radio buttons” elementlerini locate edin
    - Secili degilse cinsiyet butonundan size uygun olani secin

     */

    @Test
    public void test1() {
        //1. Bir class oluşturun : RadioButtonTest
        //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
        //- https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

        //- Cookies’i kabul edin
        //- “Create an Account” button’una basin
        driver.findElement(By.xpath("//*[@*='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"))
                .click();

        //- “radio buttons” elementlerini locate edin
        WebElement kadin= driver.findElement(By.xpath("(//*[@*='_58mt'])[1]"));
        WebElement erkek= driver.findElement(By.xpath("//*[text()='Erkek']"));
        WebElement ozel= driver.findElement(By.xpath("(//*[@*='_58mt'])[3]"));

        //- Secili degilse cinsiyet butonundan size uygun olani secin
        erkek.click();
    }
}
