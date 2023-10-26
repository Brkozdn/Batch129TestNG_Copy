package tests.day02;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.YoutubePage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_DataProvider {


    // youtube sayfasına gidelim
    // Kitap, Sanat, Muzik ve Gezi icin arama yapalım
    // Tum ekran fotografını cekelim
    // sayfayı kapatalım



    @DataProvider
    public static Object[][] AranacakKelimeler() {

        // DataProvider BİZE İKİ KATLI BİR ARRAY DONDURECEK
        // DataProvider'ın DONDURECEGİ VERİLERİ OLSTURALIM

        return new Object[][]{{"Kitap"},{"Sanat"},{"Muzik"},{"Gezi"}};
    }




    @Test(dataProvider = "AranacakKelimeler")
    // VERİ SAGLAYISICI DEMEK

    // ARAYACAGIMIZ KELİMELERİ BİR LİSTE GİBİ TUTUP
    // BANA YOLLAYACAK BİR VERİ SAGLAYICISI OLUSTURDUK

    // ARANACAK KELİMELER BİZE PARAMETRE OLARAK GELECEK

    public void test01(String Kelime) throws IOException, InterruptedException {

        // youtube sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("youtubeUrl"));



        // Kitap, Sanat, Muzik ve Gezi icin arama yapalım

        YoutubePage youtubePage = new YoutubePage();

        youtubePage.aramaMotoru.sendKeys(Kelime);
        youtubePage.aramaMotoru.submit();

        Thread.sleep(2000);



        // Tum ekran fotografını cekelim
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(dtf);


        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();

        File kayit = new File("target/youtubeEkranGoruntusu/kayit"+tarih+".Jpeg");
        File gecici = ts.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(gecici,kayit);


        // sayfayı kapatalım
        Driver.closeDriver();


    }
}
