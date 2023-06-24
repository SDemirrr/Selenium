package Practice_ders.Practice04;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01 extends TestBaseBeforeAfter {
    /*
    go to the URL https://www.queryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-plugin-jQuery-Emojis/
    ikinci emojiye tiklayin(hayvan emojisini secin)
    tum hayvan emojilerine tiklayin
    formu doldurun(dilediginizi yazabilirsiniz)
    apply butonuna tiklayin
     */

    @Test
    public void test(){
        //go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-plugin-jQuery-Emojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        //ikinci emojiye tiklayin(hayvan emojisini secin)
        WebElement iframe= driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

        //tum hayvan emojilerine tiklayin
        List<WebElement>emojiList=driver.findElements(By.xpath("//*[@*='mdl-tabs__panel is-active']/div/img"));
        for (WebElement w:emojiList) {
            w.click();
        }
        emojiList.stream().forEach(t->t.click());



        //formu doldurun(dilediginizi yazabilirsiniz)
        driver.switchTo().defaultContent();
       List<WebElement>formList=driver.findElements(By.xpath("//*[@*='mdl-textfield__input']"));

       //bu listi kullanrak her bir Webelemnti kolayca formList'de bulunan webelemtlerimize gonderebiliriz
       List<String> text=new ArrayList<>(Arrays.asList("bu","listi",
               "kullanarak","her","bir","webelementi",
               "kolayca","formList","liste","gonderirirz","asd","fas","kaz"));

       for (int i = 0; i <formList.size(); i++) {
           formList.get(i).sendKeys(text.get(i));
       }

        //apply butonuna tiklayin
        driver.findElement(By.xpath("//*[@*='send']")).click();

    }
}
