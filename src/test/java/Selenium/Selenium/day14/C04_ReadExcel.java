package Selenium.Selenium.day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcel {
    /*
    7. Dosya yolunu bir String degiskene atayalim
    8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
    9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
    10. WorkbookFactory.create(fileInputStream)
     */



    @Test
    public void readExcelTest1() throws IOException {
        //7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);

        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook= WorkbookFactory.create(fis);

        //Turkce baskentler kismini yazdiralim
        int sonSatir=workbook.getSheet("Sayfa1").getLastRowNum();
        //getLastRowNum(); methodu bize excel sayfasindaki tum satir numarasini verir

        System.out.println("Satir sayisi : "+sonSatir);

        String turkceBaskent="";

        for (int i = 0; i <=sonSatir; i++) {
            turkceBaskent=workbook.getSheet("Sayfa1")
                    .getRow(i).getCell(3).toString();
            System.out.println(turkceBaskent);
        }




    }
}
