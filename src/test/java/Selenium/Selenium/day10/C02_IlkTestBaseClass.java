package Selenium.Selenium.day10;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utilities.TestBaseBeforeClassAfterClass;

public class C02_IlkTestBaseClass extends TestBaseBeforeClassAfterClass {

   @Test
    public void test1(){
       driver.get("https://amazon.com");
   }
}
