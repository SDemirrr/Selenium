package Practice_sahsi.Slayt_Sorulari;

import org.checkerframework.checker.signature.qual.DotSeparatedIdentifiersOrPrimitiveType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Soru_18 extends TestBaseBeforeAfter {
    /*
    1. “https://www.saucedemo.com” Adresine gidin
    2. Username kutusuna “standard_user” yazdirin
    3. Password kutusuna “secret_sauce” yazdirin
    4. Login tusuna basin
    5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
    6. Add to Cart butonuna basin
    7. Alisveris sepetine tiklayin
    8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
    9. Sayfayi kapatin

     */
    @Test
    public void test(){
        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

        //2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.xpath("//*[@*='user-name']"))
                .sendKeys("standard_user");

        //3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.xpath("//*[@*='password']"))
                .sendKeys("secret_sauce");

        //4. Login tusuna basin
        driver.findElement(By.xpath("//*[@*='login-button']")).click();

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrun=driver.findElement(By.xpath("(//*[@*='inventory_item_img'])[1]"));
        ilkUrun.click();

        //6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        //7. Alisveris sepetine tiklayin
        driver.findElement(By.className("shopping_cart_link")).click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Remove']")).isDisplayed());

        //9. Sayfayi kapatin
    }
}
