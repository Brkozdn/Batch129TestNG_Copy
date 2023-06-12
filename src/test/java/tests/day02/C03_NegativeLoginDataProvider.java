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
    // login butonuna tıklayınız
    // "There was a problem with your login." yazisinin gorunur oldugunu test edin
    // sayfayı kapatınız


    // NOT: birden fazla email ve password'u dataProvider kullanarak sırayla deneyin


    @DataProvider
    public static Object[][] kullaniciListesi() {

        Object[][] kullaniciBilgileri={{"ali@gmail.com","123456"},
                {"veli@gmail.com","654321"},
                {"hasan@gmail.com","963258"}};
        /*
         Object[][] kullaniciBilgileri={{ConfigReader.getProperty("emailYanlis1"),ConfigReader.getProperty("passwordYanlis1")},
                 {ConfigReader.getProperty("emailYanlis2"),ConfigReader.getProperty("passwordYanlis2")},
                 {ConfigReader.getProperty("emailYanlis3"),ConfigReader.getProperty("passwordYanlis3")}};
        */
        return kullaniciBilgileri;
    }





    
    @Test(dataProvider = "kullaniciListesi")
    // email ve password'leri bir liste gibi tutup
    // bana yollayacak bir veri saglayıcısı olusturacagız

    public void test01(String email, String password) {



        // https://id.heroku.com/login sayfasına gidin
        Driver.getDriver().get("https://id.heroku.com/login");





        // dataProvider kullanarak email ve passwordleri giriniz
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
