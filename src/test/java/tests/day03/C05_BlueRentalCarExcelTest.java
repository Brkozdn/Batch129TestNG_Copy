package tests.day03;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueRentalPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_BlueRentalCarExcelTest {

    //BlueRentalCar sayfasına gidelim
    //Login buttonuna tıklayalım
    //Excel dosyasındaki herhangi bir username ve password ile login olalım
    //Girilen username ve password ile login olduğumuzu doğrulayalım
    //sayfayı kapatınız


    @Test
    public void test01() throws IOException, InterruptedException {

     //BlueRentalCar sayfasına gidelim
       Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));


     //Login buttonuna tıklayalım
        BlueRentalPage blueRentalPage = new BlueRentalPage();

        blueRentalPage.login.click();



     //Excel dosyasındaki herhangi bir username ve password ile login olalım

        FileInputStream fis = new FileInputStream("src/resources/mysmoketestdata.xlsx");

        Workbook workbook = WorkbookFactory.create(fis);

        String username = workbook.getSheet("customer_info").getRow(1).getCell(0).toString();
        String password = workbook.getSheet("customer_info").getRow(1).getCell(1).toString();

        blueRentalPage.email.sendKeys(username,Keys.TAB,password,Keys.ENTER);



     //Girilen username ve password ile login olduğumuzu doğrulayalım
        Thread.sleep(3000);
        blueRentalPage.profilButonu.click();
        Thread.sleep(3000);
        blueRentalPage.profil.click();
        Thread.sleep(3000);
        String emailWebElementi = blueRentalPage.profilEmail.getText();
        Thread.sleep(3000);

        Assert.assertTrue(emailWebElementi.contains(username));


     //sayfayı kapatınız
        Driver.closeDriver();


    }
}
