package Practice_sahsi.Slayt_Sorulari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Soru_09 {
    /*
    1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
    2- Add Element butonuna basin
    3 Delete butonu’nun gorunur oldugunu test edin
    4 Delete tusuna basin
    5 “Add/Remove Elements” yazisinin gorunur oldugunu test edin

     */

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test(){
        //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //2- Add Element butonuna basin
       WebElement addEelementBotton=driver.findElement(By.xpath("//*[@*='addElement()']"));
       addEelementBotton.click();

        //3 Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButton=driver.findElement(By.xpath("//*[@*='added-manually']"));
        Assert.assertTrue(deleteButton.isDisplayed());

        //4 Delete tusuna basin
        deleteButton.click();

        //5 “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemeovedElement=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(addRemeovedElement.isDisplayed());
    }
}
