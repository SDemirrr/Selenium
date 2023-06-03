package Selenium.Selenium.day14;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {

    @Test
    public void testReadExcel() throws IOException {
        //7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);
        //olusturmus oldugumuz dosyayi sistemde isleme alir

        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //10. WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);//workbook objesiyle isleme fis ile akisa
        //aldigimiz dosyamiza bir excel dosyasi create ettik.

        //11. Worksheet objesi olusturun workbook.getSheetAt(index)
        //12. Row objesi olusturun sheet.getRow(index)
        //13. Cell objesi olusturun row.getCell(index)
        String actualData=workbook.getSheet("Sayfa1")
                .getRow(3)
                .getCell(3)
                .toString();
        System.out.println(actualData);

    }
}
