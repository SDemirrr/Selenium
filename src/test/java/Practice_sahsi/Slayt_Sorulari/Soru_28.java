package Practice_sahsi.Slayt_Sorulari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Soru_28 extends TestBaseBeforeAfter {
    /*
    ● Bir class olusturun: IframeTest
    ● https://the-internet.herokuapp.com/iframe adresine gidin.
    ● Bir metod olusturun: iframeTest
    ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
    ○Text Box’a “Merhaba Dunya!” yazin.
    ○TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
    dogrulayin ve konsolda yazdirin
     */

    @Test
    public void test(){
        //● Bir class olusturun: IframeTest
        //● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //● Bir metod olusturun: iframeTest
        //○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        Assert.assertTrue(driver
                .findElement(By.xpath("//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"))
                .isEnabled());

        //○Text Box’a “Merhaba Dunya!” yazin.

        WebElement frame= driver.findElement(By.xpath("//*[@*='mce_0_ifr']"));
        driver.switchTo().frame(frame);
        WebElement textBox= driver.findElement(By.xpath("//p"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya!");

        //○TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //dogrulayin ve konsolda yazdirin
        driver.switchTo().defaultContent();

        WebElement elemnSlnium= driver.findElement(By.xpath("(//*[@*='_blank'])[2]"));
        Assert.assertTrue(elemnSlnium.isDisplayed());
        System.out.println(elemnSlnium.getText());
    }
}
