package tests.day03;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C04_WriteExcel {

    @Test
    public void test01() throws IOException {

        // Ulkeler dosyasındaki 0. satır indexin, 4. hucre indexine yeni bir cell olusturalım
        // olusturdugumuz hucreye "Nufus" yazdıralım


        String dosyaYolu = "src/resources/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);
        //ULKELER DOSYASINI BİZİM SİSTEMİMİZE GETİRDİK


        Workbook workbook = WorkbookFactory.create(fis);
        // DOSYAYI WORKBOOK'A ATADIK



        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");



        // 1.satır indexin, 4. hucre indexine yeni bir cell olusturun
        // olusturdugunuz hucreye "15000" yazdırın

        // workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue(150000);



        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        // DATALARI BİZİM CLASSIMIZDAN ULKELER DOSYASINA GONDERECEGİZ

        workbook.write(fos);
        // WORKBOOK'DAKİ DATALARI FOS'A YAZDIK


        fis.close();
        fos.close();
        workbook.close();
        // GENELDE DOSYALARI KAPATIRIZ. İSTERSENİZ KAPATABİLİRSİNİZ





    }
}
