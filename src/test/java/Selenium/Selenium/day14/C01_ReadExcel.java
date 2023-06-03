package Selenium.Selenium.day14;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.EvaluationWorkbook;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

public class C01_ReadExcel {
    //7. Dosya yolunu bir String degiskene atayalim
    //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
    //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
    //10. WorkbookFactory.create(fileInputStream)
    //11. Worksheet objesi olusturun workbook.getSheetAt(index)
    //12. Row objesi olusturun sheet.getRow(index)
    //13. Cell objesi olusturun row.getCell(index


    @Test
    public void readExcelTest1() throws IOException {
        //7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);
        //olusturmus oldugumuz dosyayi sistemde isleme alir

        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //10. WorkbookFactory.create(fileInputStream)
        Workbook workbook=WorkbookFactory.create(fis);//workbook objesiyle isleme fis ile akisa
        //aldigimiz dosyamiza bir excel dosyasi create ettik.

        //11. Worksheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet=workbook.getSheet("Sayfa1");//Excel dosyamizda calismak istedigimiz sayfayi
        //bu sekilde seceriz.

        //12. Row objesi olusturun sheet.getRow(index)
        Row row=sheet.getRow(3);//Sayfa 1'deki 3. satiri bu sekilde seceriz

        //13. Cell objesi olusturun row.getCell(index)
        Cell cell=row.getCell(3);//Satir secimi yapildiktan sonra hucre secimi bu sekilde yapilir
        System.out.println(cell);

        //3. index'deki satirin 3. indexindeki datanin Cezayir oldugunu test edin
        String expectedData="Cezayir";
        String actualData=cell.toString();
        Assert.assertEquals(expectedData,actualData);





    }
}
