package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BlueRentalPage {

    public BlueRentalPage() {

       PageFactory.initElements(Driver.getDriver(),this);

    }




    @FindBy(xpath = "(//li//a)[1]")
    public WebElement login;

    @FindBy(xpath = "//input[@id='formBasicEmail']")
    public WebElement email;

    //Girilen email ve password ile login olduğumuzu doğrulayalım
    @FindBy(xpath = "//button[@id='dropdown-basic-button']")
    public WebElement profilButonu;

    @FindBy(xpath = "//a[text()='Profile']")
    public WebElement profil;

    @FindBy(xpath = "//em")
    public WebElement profilEmail;











    // C06_BlueRentalCar

    @FindBy(xpath = "(//button)[3]")
    public WebElement continueReservation;


    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement logout;

    @FindBy(xpath = "//button[text()='OK']")
    public WebElement ok;

}
