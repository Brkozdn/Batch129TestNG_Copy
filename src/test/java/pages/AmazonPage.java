package pages;

import utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {

    public AmazonPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }


    //  C01_PageClassKullanimi LOCATELERİ

    @FindBy(xpath = "//select[@id='searchDropdownBox']")
    public WebElement ddm;


    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    public WebElement aramaKutusu;


    @FindBy(xpath = "(//img[@class='s-image'])[2]")
    public WebElement ikinciUrun;





    // C02_DataProvider LOCATELERİ


    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement sonucYazisi;






}

