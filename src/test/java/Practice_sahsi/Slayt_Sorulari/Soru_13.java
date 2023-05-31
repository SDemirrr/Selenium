package Practice_sahsi.Slayt_Sorulari;

import com.github.dockerjava.api.model.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import static net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.with;

public class Soru_13 extends TestBaseBeforeAfter {
    /*
    1) https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine gidin
    2)Berlin’i 3 farkli relative locator ile locate edin
    3)Relative locator’larin dogru calistigini test edin

     */

    @Test
    public void test1() {
        //1) https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine gidin
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        //2)Berlin’i 3 farkli relative locator ile locate edin

        //3)Relative locator’larin dogru calistigini test edin
    }

}
