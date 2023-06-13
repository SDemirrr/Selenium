package Selenium.Selenium.day16;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C02_JSExecutors extends TestBaseBeforeAfter {

    @Test
    public void test(){
        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");

        //Asagidaki carrers butonunu gorunceye kadar JS ile scroll yapalim
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        WebElement careersButton= driver.findElement(By.xpath("(//*[@*='nav_a'])[1]"));
        jse.executeScript("arguments[0].scrollIntoView(true)",careersButton);

        //Carrers butonuna JS ile click yapalim
        jse.executeScript("arguments[0].click();",careersButton);
    }
}
