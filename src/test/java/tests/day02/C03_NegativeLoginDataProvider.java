package tests.day02;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HerokuapPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_NegativeLoginDataProvider {



    // https://id.heroku.com/login sayfasına gidin

    // yanlıs email ve yanlıs password giriniz
    // (NOT: birden fazla yanlıs email ve password'u dataProvider kullanarak sırayla deneyin)

    // login butonuna tıklayınız

    // "There was a problem with your login." yazisinin gorunur oldugunu test edin

    // sayfayı kapatınız





    @DataProvider
    public static Object[][] kullaniciBilgisi() {

        // DataProvider BİZE İKİ KATLI BİR ARRAY DONDURECEK
        // DataProvider'ın DONDURECEGİ VERİLERİ OLSTURALIM

        return new Object[][]{{"ali@gmail.com","123456"},
                {"veli@gmail.com","654321"},
                {"hasan@gmail.com","963258"}};
    }



      /*
         Object[][] kullaniciBilgileri={{ConfigReader.getProperty("emailYanlis1"),ConfigReader.getProperty("passwordYanlis1")},
                 {ConfigReader.getProperty("emailYanlis2"),ConfigReader.getProperty("passwordYanlis2")},
                 {ConfigReader.getProperty("emailYanlis3"),ConfigReader.getProperty("passwordYanlis3")}};
      */






    
    @Test(dataProvider = "kullaniciBilgisi")
    // VERİ SAGLAYISICI DEMEK

    // EMAİL VE PASSWORD'LERİ BİR LİSTE GİBİ TUTUP
    // BANA YOLLAYACAK BİR VERİ SAGLAYICISI OLUSTURDUK.

    // EMAİL VE PASSWORD'LER BİZE PARAMETRE OLARAK GELECEK

    public void test01(String email, String password) {



        // https://id.heroku.com/login sayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("herokuapUrl"));





        // yanlıs email ve yanlıs password giriniz
        // (NOT: birden fazla yanlıs email ve password'u dataProvider kullanarak sırayla deneyin)

        HerokuapPage herokuapPage = new HerokuapPage();

        herokuapPage.emailKutusu.sendKeys(email);

        herokuapPage.passwordKutusu.sendKeys(password);




        // login butonuna tıklayınız
        herokuapPage.logInButonu.click();



        // "There was a problem with your login." texti gorunur oldugunu test edin
        Assert.assertTrue(herokuapPage.theWasaProblemYaziElementi.isDisplayed());




        // sayfayı kapatınız
        Driver.closeDriver();




    }
}
