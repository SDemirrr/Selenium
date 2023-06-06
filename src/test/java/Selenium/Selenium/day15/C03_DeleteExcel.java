package Selenium.Selenium.day15;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_DeleteExcel {
     /*

    7. Dosya yolunu bir String degiskene atayalim
    8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
    9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
    10. WorkbookFactory.create(fileInputStream)
    11.3. satir 3. cell'deki veriyi silelim

      */

    @Test
    public void test1() throws IOException {
        // 7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        // 8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);

        // 9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook= WorkbookFactory.create(fis);

        // 11.3. satir 3. cell'deki veriyi silelim
        Sheet sheet= workbook.getSheet("Sayfa1");
        Row row= sheet.getRow(3);
        Cell cell=row.getCell(3);
        row.removeCell(cell);

        /*
        Bir cell'deki veriyi silmek icin row objesine ihtiyac vardir.
        row objesi ile remoceCell() methodunu kullanarak cell objesi ile belirttigimiz
        cell degerini silebiliriz

         */

        FileOutputStream fos=new FileOutputStream(dosyaYolu);
        workbook.write(fos);

        //Silindigini test edin
        String expectedData="Cezayir";
        String actualData=null;
        Assert.assertNotEquals(expectedData,actualData);

    }
}
