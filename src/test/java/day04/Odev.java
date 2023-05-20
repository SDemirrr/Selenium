package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Odev {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));

        //1-https/:the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //2-Add Elemet butonuna 10 defa basin
        WebElement addElementButton=driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        for (int i = 1; i <11; i++) {
            addElementButton.click();
        }

        //3-10 defa add element buttonuna basildigini test edin
        List<WebElement>deleteButtonList=driver.findElements(By.xpath("//*[text()='Delete']"));
        int expectedDeleteButtonSayisi=10;
        int actualDeleteButtonSayisi=deleteButtonList.size();
        if (expectedDeleteButtonSayisi==actualDeleteButtonSayisi){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }

        //4-delete buttonuna gorunmeyene kadar basin

        for (int i = 1; i <11 ; i++) {
            driver.findElement(By.xpath("//*[text()='Delete']")).click();

        }

        //5-delete buttonunun gorunmedigini test ediniz
       WebElement anaSayfa=driver.findElement(By.className("no-js"));
        String deleteButton="Delete";
        if (!anaSayfa.getText().contains(deleteButton)){
            System.out.println("Test PASSED!");
        }else {
            System.out.println("Test FAILED");
        }

        //6-sayfayi kapatiniz
        driver.close();


    }
}
