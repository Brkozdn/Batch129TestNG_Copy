package pages;

import utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookPage {

    public FacebookPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailKutusu;

    @FindBy(xpath = "//input[@id='pass']")
    public WebElement sifreKutusu;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement giriYapButonu;

    @FindBy(xpath = "//h2[@class='uiHeaderTitle']")
    public WebElement baskaSekildeTanimlaYaziElementi;
}


