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

public class C06_BlueRentalCarExcel {

    //BlueRentalCar Sayfasına gidelim
    //Login buttonuna tıklayalım
    //Excel dosyasındaki tüm kullanıcı bilgileri ile login olalım login olduğumuzu doğrulayalım
    //sayfayı kapatalım


    @Test
    public void test01() throws IOException, InterruptedException {

        //BlueRentalCar Sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));


        //Login buttonuna tıklayalım


        //Excel dosyasındaki tüm username ve password ile sırasıyla login olalım, login olduğumuzu doğrulayalım

        FileInputStream fis = new FileInputStream("src/resources/mysmoketestdata.xlsx");

        Workbook workbook = WorkbookFactory.create(fis);

        int sonSatirIndex = workbook.getSheet("customer_info").getLastRowNum();

        for (int i = 1; i <=sonSatirIndex ; i++) {

            BlueRentalPage blueRentalPage = new BlueRentalPage();

            blueRentalPage.login.click();

            String usarname = workbook.getSheet("customer_info").getRow(i).getCell(0).toString();
            String password = workbook.getSheet("customer_info").getRow(i).getCell(1).toString();

            blueRentalPage.email.sendKeys(usarname, Keys.TAB, password, Keys.ENTER);
            Thread.sleep(2000);

            Assert.assertTrue(blueRentalPage.continueReservation.isDisplayed());
            Thread.sleep(2000);

            blueRentalPage.profilButonu.click();
            Thread.sleep(2000);
            blueRentalPage.logout.click();
            Thread.sleep(2000);
            blueRentalPage.ok.click();
            Thread.sleep(2000);



        }



        //sayfayı kapatalım
        Driver.closeDriver();

    }
}
