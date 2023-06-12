package tests.day03;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C07_ReadExcel {

   // Ulkeler dosyasındaki tum dataları map'a alınız ve yazdırınız


    @Test
    public void test01() throws IOException {

   // ULKELER DOSYASINDAKİ TUM VERİLERİ KOYABİLECEGİMİZ EN UYGUN JAVA OBJESİ MAP'DİR

        Map<String,String> ulkelerMap = new HashMap<>();

        String dosyaYolu = "src/resources/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);
        //ULKELER DOSYASINI BİZİM SİSTEMİMİZE GETİRDİK




        Workbook workbook = WorkbookFactory.create(fis);
        // DOSYAYI WORKBOOK'A ATADIK




        int sonSatirIndex = workbook.getSheet("Sayfa1").getLastRowNum();
        // getLastRowNum SON SATIR NUMARASINI İNDEX OLARAK VERİR




        for (int i = 0; i <=sonSatirIndex ; i++) {
            // KEY i. SATIRDAKİ 0 INDEXİNDEKİ DATA OLACAK
            String key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();


            // VALUE İSE i. SATIRDAKİ 1,2,3. INDEXDEKİ DATALARIN BİRLESİMİ OLACAK
            String value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() + " - "
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() + " - "
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            ulkelerMap.put(key,value);

            // System.out.println(key + " /" + value);
        }


        System.out.println(ulkelerMap);


    }
}
