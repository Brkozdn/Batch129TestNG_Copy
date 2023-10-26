package tests.day01;

import org.openqa.selenium.Keys;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C04_PageClassKullanimi {

    // facebook anasayfaya gidin
    // kullanıcı email kutusuna rastgele bir isim yazın
    // kullanıcı sifre kutusuna rastgele bir password yazın
    // giris yap butonuna tıklayın
    // lutfen bu hesabı baska sekilde tanımla yazı elementinin, gorunur oldugunu test edin
    // sayfayı kaptın

    @Test(groups = "grup1")
    public void test01() {

        // facebook anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));


        // kullanıcı email kutusuna rastgele bir isim yazın
        FacebookPage facebookPage = new FacebookPage();

        facebookPage.emailKutusu.sendKeys("Ahmet");


        // kullanıcı sifre kutusuna rastgele bir password yazın
        facebookPage.sifreKutusu.sendKeys("123456");



        // giris yap butonuna tıklayın
        facebookPage.giriYapButonu.click();
        //  facebookPage.emailKutusu.sendKeys("Ahmet", Keys.TAB,"123456",Keys.ENTER);


        // lutfen bu hesabı baska sekilde tanımla yazı elementinin, gorunur oldugunu test edin
        Assert.assertTrue(facebookPage.baskaSekildeTanimlaYaziElementi.isDisplayed());

        // sayfayı kaptın
        Driver.closeDriver();
    }
}
