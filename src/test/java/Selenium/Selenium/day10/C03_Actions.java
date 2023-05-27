package Selenium.Selenium.day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import javax.swing.*;

public class C03_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1(){
        //amazon sayfasina gidelim
        driver.get("https://amazon.com");

        //account menusunden create a list linkine tiklayalim
        WebElement accountList=driver.findElement(By.xpath("//*[@*='nav-link-accountList']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(accountList).perform();
        /*
        Bir web sitesinde mause ile acilan bir webelemente ulasmak istersek
        actions.moveElement() method'unu kullanmamiz gerekir aksi halde
        html kodlari arasinda web elemnti kodu bulur ama ulasamadigi icin
        ElemntNotInteractableException: element not interactable exception'i firlatir
         */
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

    }
}
