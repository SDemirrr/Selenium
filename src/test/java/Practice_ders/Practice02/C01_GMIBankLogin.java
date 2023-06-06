package Practice_ders.Practice02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C01_GMIBankLogin extends TestBaseBeforeAfter {
    /*
    1-https://www.gmibank.com adresine gidin
    2-Sign-in butonuna tikla
     */

    @Test
    public void test(){
        // 1-https://www.gmibank.com adresine gidin
        driver.get("https://www.gmibank.com");

        //2-Sign-in butonuna tikla
        driver.findElement(By.xpath("//*[@*='account-menu']")).click();
        WebElement signInButton=driver.findElement(By.xpath("(//*[text()='Sign in'])[1]"));
        signInButton.click();

        //3- username:Batch81  password:Batch81+
        WebElement userName=driver.findElement(By.xpath("(//*[@*='username'])[2]"));
        WebElement password= driver.findElement(By.xpath("(//*[@*='password'])[2]"));
        userName.sendKeys("Batch81");
        password.sendKeys("Batch81+"+ Keys.ENTER);

    }
}
