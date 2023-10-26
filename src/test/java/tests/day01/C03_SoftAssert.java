package tests.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C03_SoftAssert {

    // "https://amazon.com" sayfasına gidiniz
    /// Title'in "Amazon" icerdigini test edin
    /// Arama kutusunun erisilebilir oldugunu test edin
    // Arama kutusuna Nutella yazıp aratın
    /// Sonuc yazısının gorunur oldugunu test edin
    /// Sonuc yazısının "Nutella" icerdigini test edin

    // test islemlerini softAssert ile yapınız ve hatalar icin mesaj versin



    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }




    @Test
    public void test01() {

        /*
        Junit'te Assert KULLANDIGIMIZDA Assert FAİLD OLDUGU ANDA TEST CALISMAYI DURDURUYOR. VE GERİ KALANINI CALISTIRMIYORDU.

        TestNG'de HEM Assert, HEM softAssert YAPILARI VAR.

        TEST SONUNA KADAR CALISSIN, TEST'İN SONUNDA TUM HATALARI LİSTELESİN İSTİYORSAK softAssert KULLANIRIZ.

         */





        // "https://amazon.com" sayfasına gidiniz
        driver.get("https://amazon.com");







        /// Title'in "Amazon" icerdigini test edin
        SoftAssert softAssert = new SoftAssert();
        // softAsser İNSTANCE OLDUGU İCİN İLK ÖNCE OBJE OLUSTURULUR.

        String amazonTitle = driver.getTitle();

        softAssert.assertTrue(amazonTitle.contains("Amazon"),"TİTLE AMAZON İCERMİYOR");







        /// Arama kutusunun erisilebilir oldugunu test edin
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        softAssert.assertTrue(aramaKutusu.isEnabled(),"ARAMA KUTUSUNA ERİSİLEMİYOR");







        // Arama kutusuna Nutella yazıp aratın
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);






        /// Sonuc yazısının gorunur oldugunu test edin
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        softAssert.assertTrue(sonucYazisi.isDisplayed(),"SONUC YAZISI GORUNMUYOR");







        /// Sonuc yazısının "Nutella" icerdigini test edin
        softAssert.assertTrue(sonucYazisi.getText().contains("Nutella"),"SONUC YAZISI Nutella İCERMİYOR");






         softAssert.assertAll();
        // assertAll() YAZIP TUM HATALARI LİSTELEMESİNİ İSTEMELİYİZ. AKSİ HALDE HATA VERMEZ.



        /*
        Junit'te Assert KULLANDIGIMIZDA Assert FAİLD OLDUGU ANDA TEST CALISMAYI DURDURUYOR. VE GERİ KALANINI CALISTIRMIYORDU.

        TestNG'de HEM Assert, HEM softAssert YAPILARI VAR.

        TEST SONUNA KADAR CALISSIN, TEST'İN SONUNDA TUM HATALARI LİSTELESİN İSTİYORSAK softAssert KULLANIRIZ.

         */


        // softAssert'un HATA BULSA BİLE CALISMAYA DEVAM ETME OZELLİGİ softAssert.assertAll()'a KADARDIR.
        // EGER softAssert.assertAll()'da HATA BULUNURSA CALISMA DURUR.
        // VE CLASS'IN KALAN KISMI CALISMAZ


        System.out.println("burak");

    }
}
