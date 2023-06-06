package Practice_ders.Practice03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C01_LoginTest extends TestBaseBeforeAfter {
    //1)https://www.koalaresorthotels.com/ sayfasina gidiniz
    //3)Login ekranina girdiginizi 4 farkli webelementi kullanarak dogrulayiniz
    //3)Login ekranina girdiginizi 4 farkli webelementi kullanarak dogrulayiniz

    @Test
    public void test1(){
        //1)https://www.koalaresorthotels.com/ sayfasina gidiniz
        driver.get("https://www.koalaresorthotels.com/");
        driver.findElement(By.xpath("//*[@*='details-button']")).click();
        driver.findElement(By.xpath("//*[@*='proceed-link']")).click();

        //2)Login butonuna tikla
        driver.findElement(By.xpath("//*[text()='Log in']")).click();
        //(//*[@*='UserName'])[1]
        //(//*[@*='Password'])[1]

        //3)Login ekranina girdiginizi 4 farkli webelementi kullanarak dogrulayiniz
        //1.
        WebElement logo= driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(logo.isDisplayed());

        //2.
        WebElement loginText= driver.findElement(By.xpath("//h2"));
        Assert.assertTrue(loginText.isDisplayed());

        //3
        Assert.assertTrue(driver.getTitle().contains("Log in"));

        //4.
        String expectedUrl="https://www.koalaresorthotels.com/Account/Logon";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals("login ekranina giris yapilamadi",expectedUrl,actualUrl);



    }
}
