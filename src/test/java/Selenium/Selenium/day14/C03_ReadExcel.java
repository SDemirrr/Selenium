package Selenium.Selenium.day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {
      /*
        1-)Belirtilen satirNo ve sutunNo degerlerini parameter olarak alip
        o cell'deki datayi konsola yazdiralim
        1-)Sonucun konsolda yazanla ayni oldugunu dogrulatyalim
         */

    @Test
    public void testReadExcel() throws IOException {
        //1-)Belirtilen satirNo ve sutunNo degerlerini parameter olarak alip
        //o cell'deki datayi konsola yazdiralim
        //1-)Sonucun konsolda yazanla ayni oldugunu dogrulatyalim

        int satir=12;
        int sutun=2;

        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        String actualData=workbook
                .getSheet("Sayfa1")
                .getRow(satir-1)
                .getCell(sutun-1)
                .toString();
        //index 0'dan basladigi icin bizden istenen satira ulasabilmek icin -1 aliriz

        System.out.println(actualData);

        String expectedData="Baku";
        Assert.assertEquals(expectedData,actualData);

    }
}
