package Selenium.Selenium.day15;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
     /*
    7. Dosya yolunu bir String degiskene atayalim
    8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
    9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
    10. WorkbookFactory.create(fileInputStream)
     */

    @Test
    public void test1() throws IOException {
        //7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);

        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook= WorkbookFactory.create(fis);
        //10. WorkbookFactory.create(fileInputStream)

        //11. Excel tablosundaki tum tabloyu konsola yazdirin
        int satirSayisi=workbook.getSheet("Sayfa1").getLastRowNum();
        String tablo="";

        for (int i = 0; i <=satirSayisi; i++) {
            tablo=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString()+","
            +workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()+","
                    +workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+","
                    +workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString()+",";
            System.out.println(tablo);
        }




    }
}
