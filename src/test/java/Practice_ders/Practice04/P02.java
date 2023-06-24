package Practice_ders.Practice04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class P02 extends TestBaseBeforeAfter {
    /*
    verify that we have pom.xml file in our project=> please try in 4 min s
  */

    @Test
    public void test1() {
     //verify that we have pom.xml file in our project=> please try in 4 min s
        String dosyaYolu ="pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
