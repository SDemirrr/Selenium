package Practice_ders.Practice02;

import org.junit.Test;

import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeClassAfterClass;

import java.util.List;

public class C02_JUnit extends TestBaseBeforeClassAfterClass {

    /*
    @Before anotasyonu her testten once bir defa calisir
    @After anotasyonu her testten sonra bir defa calisir
    @BeforeClass anotasyonu her tclassda ilk once ve yalniz bir defa calisir
    @AfterClass anotasyonu her classda en sonda ve yalniz bir defa calisir
    @Ignore anotasyonu calismasini istemedigimiz @Test anotosyonundan sonra
    eklenir ve o @Test calismaz atlanir.
     */

    @Test
    public void test1(){
        System.out.println("Test1");
    }

    @Test
    public void test2(){
        System.out.println("Test1");
    }

    @Test
    public void test3(){
        System.out.println("Test1");

    }

}
