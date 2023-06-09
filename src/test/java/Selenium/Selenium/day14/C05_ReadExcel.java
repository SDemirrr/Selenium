package Selenium.Selenium.day14;

import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellAddress;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

public class C05_ReadExcel {
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
        //11.Sayfa2'ye gidip satir sayisinn 6, kullanilan satir sayisinin ise 3 oldugunu test edin

        int satirSayisi=workbook.getSheet("Sayfa2").getLastRowNum();
        System.out.println("Kullanilan satir sayisi : "+satirSayisi);
        int expectedLastRow=6;
        Assert.assertEquals(expectedLastRow,satirSayisi+1);

        int kullanilanCellSayisi=workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();
        System.out.println("Kullanilan hucre sayisi : "+kullanilanCellSayisi);
        int expectedCell=3;
        Assert.assertEquals(expectedCell,kullanilanCellSayisi);






    }
}
