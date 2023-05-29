package Selenium.Selenium.day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C01_Actions extends TestBaseBeforeAfter {
    /*
    1 Bir Class olusturalim KeyboardActions1
    2 https://www.amazon.com sayfasina gidelim
    3 Arama kutusuna actions method’larine
    kullanarak samsung A71 yazdirin ve Enter’a
    basarak arama yaptirin
    4 aramanin gerceklestigini test edin

     */

    @Test
    public void test1() {
        //1 Bir Class olusturalim KeyboardActions1
        //2 https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");

        //3 Arama kutusuna actions method’larine
        //kullanarak samsung A71 yazdirin ve Enter’a
        //basarak arama yaptirin
        Actions actions=new Actions(driver);
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        actions.click(searchBox).
                sendKeys("s")
                .sendKeys("a")
                .sendKeys("m")
                .sendKeys("s")
                .sendKeys("u")
                .sendKeys("n")
                .sendKeys("g")
                .sendKeys(" ").keyDown(Keys.SHIFT)//shift tusu otomasyon ile bu sekilde kullanilir.
                //Shift tusuna basmak icin keyDown(); shift'ten cikmak icin keyUp(); method'u kullanilir
                .sendKeys("a").keyUp(Keys.SHIFT)
                .sendKeys("7")
                .sendKeys("1").sendKeys(Keys.ENTER).perform();

        //4 aramanin gerceklestigini test edin
        Assert
                .assertTrue(driver
                        .findElement(By.xpath("(//*[@*='a-section a-spacing-small a-spacing-top-small'])[1]")).isDisplayed());

    }
}
