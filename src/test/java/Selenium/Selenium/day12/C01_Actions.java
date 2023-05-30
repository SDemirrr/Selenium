package Selenium.Selenium.day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C01_Actions extends TestBaseBeforeAfter {
    //AutomationExercise.com sitesine gidelim
    //Product bolmune girelim
    //Ilk urune tiklayalim

    @Test
    public void test1(){
        //AutomationExercise.com sitesine gidelim
        driver.get("https://automationexercise.com");

        //Product bolumune girelim
      WebElement products=driver.findElement(By.xpath("//*[@*='material-icons card_travel']"));
        products.click();

        //Ilk urune tiklayalim
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        //Keys.PAGE_DOWN => sayfayi biraz asagi surukler

    }
}
