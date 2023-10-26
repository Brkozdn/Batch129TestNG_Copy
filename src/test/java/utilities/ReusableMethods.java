package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ReusableMethods {


    public static ExtentReports extentReport;//-->raporlamayı başlatır
    public static ExtentHtmlReporter extentHtmlReporter;//-->Html formatında rapor oluşturur
    public static ExtentTest extentTest;//-->Test adımlarına bilgi eklenir










    public static void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }











    public static void ddmVisibleText(WebElement ddm, String secenek){
        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }



    public static void ddmIndex(WebElement ddm,int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }



    public static void ddmValue(WebElement ddm,String value){
        Select select = new Select(ddm);
        select.selectByValue(value);
    }











    public static void alertAccept(){
        Driver.getDriver().switchTo().alert().accept();
    }


    public static void alertDismiss(){
        Driver.getDriver().switchTo().alert().dismiss();
    }


    public static void alertsendKeys(String text){
        Driver.getDriver().switchTo().alert().sendKeys(text);
    }



    public static void alertgetText(){
        System.out.println(Driver.getDriver().switchTo().alert().getText());
    }





    //UploadFile Robot Class
    public static void robot(String dosyaYolu) {
        try {
            bekle(3);
            StringSelection stringSelection = new StringSelection(dosyaYolu);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            bekle(3);
            robot.keyPress(KeyEvent.VK_V);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_V);
            bekle(3);
            robot.keyPress(KeyEvent.VK_ENTER);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_ENTER);
            bekle(3);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }



    public static void tumSayfaEkranGoruntusu(){

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(dtf);

        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File kayit = new File("target/ekranGoruntusu/tumSayfa"+tarih+".Jpeg");
        File geciciDosya = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciDosya,kayit);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }




    public static void webElementEkranGoruntusu(WebElement element){

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(dtf);


        File kayit = new File("src/test/java/utilities/ekranGoruntusu/ilkUrun"+tarih+".png");

        File geciciDosya = element.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciDosya,kayit);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    //Extent Report
    public static void rapor(String browser,String reportName){
        extentReport = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "target/extentReport/report"+tarih+".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReport.attachReporter(extentHtmlReporter);
        //Raporda gözükmesini istediğimiz bilgiler
        extentReport.setSystemInfo("Tester","Burak");
        extentReport.setSystemInfo(browser,"Chrome");
        extentHtmlReporter.config().setDocumentTitle("ExtentReport");
        extentHtmlReporter.config().setReportName(reportName);
    }









}
