package Practice_sahsi.Slayt_Sorulari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Soru_10 extends TestBaseBeforeAfter {
    /*
    Asagidaki testi text’leri kullanarak locate edin
    1 https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
    2 Add Element butonuna basin
    3 Delete butonu’nun gorunur oldugunu test edin
    4 Delete tusuna basin
    5 “Add/Remove Elements” yazisinin gorunur oldugunu test edin

     */

    @Test
    public void test1(){
        //Asagidaki testi text’leri kullanarak locate edin
        //1 https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //2 Add Element butonuna basin
        WebElement addElementButon=driver.findElement(By.xpath("//*[text()='Add Element']"));
        addElementButon.click();

        //3 Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButon=driver.findElement(By.xpath("//*[text()='Delete']"));
        Assert.assertTrue(deleteButon.isDisplayed());

        //4 Delete tusuna basin
        deleteButon.click();

        //5 “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"))
                .isDisplayed());
    }
}
