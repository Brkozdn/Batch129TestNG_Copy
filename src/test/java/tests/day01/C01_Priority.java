package tests.day01;

import utilities.TestBase;
import org.testng.annotations.Test;

public class C01_Priority extends TestBase {

    // amazon isimli bir test methodu olusturunuz. Ve amazona gidiniz
    // bestbuy isimli bir test methodu olusturunuz. Ve bestbuy'a gidiniz
    // techproeducation isimli bir test methodu olusturunuz. Ve techproeducation'a gidiniz

    // once techproeducation, sonra amazon, sonra bestbuy test methodu calısacak sekilde sıralama yapınız


    /*
    TestNG, TEST METHOD'LARINI İSİM SIRASINA GORE CALISTIRIR
    EGER İSİM SIRALAMASININ DISINDA BİR SIRALAMA İLE CALISMASINI İSTERSENİZ
    O ZAMAN TEST METHOD'LARINA ONCELİK(priority) TANIMLAYABİLİRİZ

    priority KUCUKTEN BUYUGE GORE CALISIR
    EGER BİR TEST METHOD'UNA priority DEGERİ ATANMAMISSA
    DEFAULT OLARAK priority=0 KABUL EDİLİR
     */


    @Test(priority = -2)
    public void amazon() {
        driver.get("https://www.amazon.com");
    }

    @Test
    public void bestbuy() {
        driver.get("https://www.bestbuy.com");
    }


    @Test(priority = -5)
    public void techproeducation() {
        driver.get("https://www.techproeducation.com");
    }

}
