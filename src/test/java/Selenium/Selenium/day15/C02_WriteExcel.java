package Selenium.Selenium.day15;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {
     /*
      1)Yeni bir Class olusturalim WriteExcel
     2) Yeni bir test method olusturalim writeExcelTest()
     3) Adimlari takip ederek 1.satira kadar gidelim
     4) 5.hucreye yeni bir cell olusturalim
     5) Olusturdugumuz hucreye “Nufus” yazdiralim
     6) 2.satir nufus kolonuna 1500000 yazdiralim
     7) 10.satir nufus kolonuna 250000 yazdiralim
     8) 15.satir nufus kolonuna 54000 yazdiralim
     9)Dosyayi kaydedelim
     10)Dosyayi kapatalim

     */

    @Test
    public void writeExcelTest() throws IOException {
       //1)Yeni bir Class olusturalim WriteExcel
        //2) Yeni bir test method olusturalim writeExcelTest()
        //3) Adimlari takip ederek 1.satira kadar gidelim
        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        //4) 5.hucreye yeni bir cell olusturalim
        //5) Olusturdugumuz hucreye “Nufus” yazdiralim
       workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");

       //6) 2.satir nufus kolonuna 1500000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue(1500000);

        //7) 10.satir nufus kolonuna 250000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(9).createCell(4).setCellValue(250000);

        //8) 15.satir nufus kolonuna 54000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(14).createCell(4).setCellValue(5400);

        //9)Dosyayi kaydedelim
        FileOutputStream fos=new FileOutputStream(dosyaYolu);
        //Excel dosyamiza veri girisi yaptiktan sonra dosyayi akisa aldigimiz gbi
        //sonlandirmamiz gerekir.
        //Sonrasinda da workbook objemize kayit etmemiz gerekir
        workbook.write(fos);//write methodu ile sonlandirdigimiz islemi workbooka yazdirdik

        //10)Dosyayi kapatalim
        fis.close();
        fos.close();
        workbook.close();


    }
}
