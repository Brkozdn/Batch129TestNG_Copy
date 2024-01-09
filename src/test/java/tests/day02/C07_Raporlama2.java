package tests.day02;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static utilities.ReusableMethods.extentTest;

public class C07_Raporlama2 extends TestBaseRapor {


    // 'https://www.amazon.com' adresine gidin
    // arama kutusuna "Java" yazip aratın
    // sonuc yazisinin "Java" icerdigini test edin
    // kontrollu olarak yeni bir sayfa acın
    // yeni acılan sayfada "Kitap" aratın
    // sonuc yazisinin Kitap icerdigini test edin
    // sayfayı kapatınız

    // test raporu alınız

    /*
    pom.xml'e BU DEPENDENCY YAPISTIR.

            <!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->
        <dependency>
            <groupId>com.aventstack</groupId>
            <artifactId>extentreports</artifactId>
            <version>4.0.9</version>
        </dependency>

    */


    @Test
    public void test01() {


        extentTest = extentReports.createTest("Amazon Test","Test Raporu");
        // extentTest'e TESTNAME VE DESCRİPTİON DEGERLERİNİ ATAYALIM


        // 'https://www.amazon.com' adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("AMAZON SAYFASINA GİDİLDİ");
        // BİLGİ VERİLMESİNİ İSTEDİGİMİZ HER SATIRDA extentTest.info() SEKLİNDE ACIKLAMA EKLİYORUZ






        // arama kutusuna "Java" yazip aratın
        AmazonPage amazonPage = new AmazonPage();

        amazonPage.aramaKutusu.sendKeys("Java" + Keys.ENTER);
        extentTest.info("ARAMA KUTUSUNA JAVA YAZIP ARATILDI");




        // sonuc yazisinin "Java" icerdigini test edin
        Assert.assertTrue(amazonPage.sonucYazisi.getText().contains("Java"));
        extentTest.pass("SONUC YAZISININ JAVA İCERDİGİ TEST EDİLDİ");
        // ASSERTİON YAPARKEN GECTİ DEMEK İCİN extentTest.pass() KULLANIYORUZ




        // kontrollu olarak yeni bir sayfa acın
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        extentTest.info("KONTROLLU YENİ SAYFA ACILDI");




        // yeni acılan sayfada "Kitap" aratın
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        amazonPage.aramaKutusu.sendKeys("Kitap" + Keys.ENTER);
        extentTest.info("YENİ ACILAN SAYFADA KİTAP ARATILDI");





        // sonuc yazisinin Kitap icerdigini test edin
        Assert.assertTrue(amazonPage.sonucYazisi.getText().contains("Kitap"));
        extentTest.pass("SONUC YAZISININ KİTAP İCERDİGİ TEST EDİLDİ");
        // ASSERTİON YAPARKEN GECTİ DEMEK İCİN extentTest.pass() KULLANIYORUZ




        // sayfayı kapatınız
        Driver.closeDriver();

    }
}
