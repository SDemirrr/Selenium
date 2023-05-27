package Selenium.Selenium.day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C05_Actions extends TestBaseBeforeAfter {
    /*
    1 https://demoqa.com/droppable adresine gidelim
    2 “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    3 “Drop here” yazisi yerine “Dropped!” oldugunu test edin

     */
    @Test
    public void test(){
        //1 https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //2 “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMeButton= driver.findElement(By.xpath("//*[@*='draggable']"));
        WebElement dropHereButton= driver.findElement(By.xpath("(//*[@*='droppable'])[1]"));
        Actions action=new Actions(driver);
        action.dragAndDrop(dragMeButton,dropHereButton).perform();

        //3 “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        Assert.assertEquals(dropHereButton.getText(),"Dropped!");
    }

}
