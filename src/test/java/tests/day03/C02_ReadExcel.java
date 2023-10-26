package tests.day03;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;


import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcel {

    // Ulkeler dosyasındaki "Başkent (İngilizce)" sutunun yazdırınız


    @Test
    public void test01() throws IOException {

        String dosyaYolu = "src/resources/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);
        //ULKELER DOSYASINI BİZİM SİSTEMİMİZE GETİRDİK



        Workbook workbook = WorkbookFactory.create(fis);
        // DOSYAYI WORKBOOK'A ATADIK



        int sonSatirIdx = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(sonSatirIdx);
        // getLastRowNum SON SATIR NUMARASINI İNDEX OLARAK VERİR

/*
        for (int i = 0; i <=sonSatirIdx ; i++) {


          String satirdakiData = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();

          System.out.println(satirdakiData);

        }

 */


        for (int i = 0; i <=sonSatirIdx ; i++) {


            String satirdakiData = C01_ReadExcel.banaDataGetir(i, 1);

            System.out.println(satirdakiData);

        }


        }
}
