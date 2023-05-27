package Selenium.Selenium.day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C04_Actions extends TestBaseBeforeAfter {
    /*
    1-Yeni bir class olusturalim: MouseActions1
    2-https://the-internet.herokuapp.com/context_menu sitesine gidelim
    3-Cizili alan uzerinde sag click yapalim
    4-Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
    5-Tamam diyerek alert’i kapatalim
    6-Elemental Selenium linkine tiklayalim
    7-Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
  */

    @Test
    public void test1(){
        //1-Yeni bir class olusturalim: MouseActions1
        //2-https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3-Cizili alan uzerinde sag click yapalim
        WebElement ciziliAlan= driver.
                findElement(By.xpath("//*[@*='hot-spot']"));
        Actions actions=new Actions(driver);
        actions.contextClick(ciziliAlan).perform();

        //4-Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String actualAlerttext=driver.switchTo().alert().getText();
        String expectedAlertText="You selected a context menu";
        Assert.assertEquals(actualAlerttext,expectedAlertText);

        //5-Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6-Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[@*='_blank']")).click();

        //7-Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        List<String> windowList=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(),
                "Elemental Selenium");


    }
}
