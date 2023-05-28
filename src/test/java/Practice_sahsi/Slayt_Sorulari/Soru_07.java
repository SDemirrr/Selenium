package Practice_sahsi.Slayt_Sorulari;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class Soru_07 extends TestBaseBeforeAfter {
    /*
    1. Bir class oluşturun: LoginTest
    2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
    a. http://a.testaddressbook.com adresine gidiniz.
    b. Sign in butonuna basin
    c. email textbox,password textbox, and signin button elementlerini locate ediniz..
    d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
    i. Username : testtechproed@gmail.com
    ii. Password : Test1234!
    e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
    f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
    3. Sayfada kac tane link oldugunu bulun
     */

    @Test
    public void test(){
        //a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");
        WebElement iframe=driver.findElement(By.xpath("//*[@*='//www.herokucdn.com/error-pages/no-such-app.html']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[@*='btn']")).click();

        //b. Sign in butonuna basin
       driver.findElement(By.xpath("(//*[@*='btn btn-primary btn-lg'])[1]")).click();

        //c. email textbox,password textbox, and signin button elementlerini locate ediniz.
        driver.findElement(By.xpath("//*[@*='btn btn-sm btn-alt']")).click();
        WebElement email= driver.findElement(By.xpath("(//*[@*='email'])[2]"));
        WebElement password= driver.findElement(By.xpath("//*[@*='off']"));
        WebElement signinButton= driver.findElement(By.xpath("//*[@*='Log In']"));

        //d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        //i. Username : testtechproed@gmail.com
        email.sendKeys("testtechproed@gmail.com");

        //ii. Password : Test1234!
        password.sendKeys("Test1234!");
        signinButton.click();

        //e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
        //f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        //3. Sayfada kac tane link oldugunu bulun
    }
}
