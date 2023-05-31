package Practice_sahsi.Slayt_Sorulari;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeAfter;

public class Soru_15 extends TestBaseBeforeAfter {
    /*
    1. http://zero.webappsecurity.com sayfasina gidin
    2. Signin buttonuna tiklayin
    3. Login alanine “username” yazdirin
    4. Password alanine “password” yazdirin
    5. Sign in buttonuna tiklayin
    6. Pay Bills sayfasina gidin
    7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
    8. tarih kismina “2020-09-10” yazdirin
    9. Pay buttonuna tiklayin
    10. “The payment was successfully submitted.” mesajinin ciktigini control edin

     */

    @Test
    public void test1(){
        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        //3. Login alanine “username” yazdirin
        driver.findElement(By.xpath("(//*[@*='user_login'])[2]"))
                .sendKeys("username");

        //4. Password alanine “password” yazdirin
        driver.findElement(By.xpath("(//*[@*='user_password'])[2]"))
                .sendKeys("password");

        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@*='submit']")).click();

        //6. Pay Bills sayfasina gidin
        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        //8. tarih kismina “2020-09-10” yazdirin
        //9. Pay buttonuna tiklayin
        //10. “The payment was successfully submitted.” mesajinin ciktigini control edin

    }
}
