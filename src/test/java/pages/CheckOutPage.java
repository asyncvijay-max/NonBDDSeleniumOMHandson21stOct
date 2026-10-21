package pages;

import base.BasePage;
import domain.BillingAddress;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends BasePage {
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    //LOCATORS
    private  final By firstNameTxt =  By.id("billing_first_name");

    private  final By lastNameTxt =  By.id("billing_last_name");

    private  final By billingStreetTxt =  By.id("billing_address_1");

    private  final By billingCityTxt =  By.id("billing_city");

    private  final By postCodeTxt =  By.id("billing_postcode");

    private  final By emailTxt =  By.id("billing_email");

    private  final By placeOrderBtn =  By.id("place_order");


    //ACTIONS

    public void enterFirstName(String fname)
    {
        driver.findElement(firstNameTxt).clear();
        driver.findElement(firstNameTxt).sendKeys(fname);
    }

    public void enterLastName(String lname)
    {
        driver.findElement(lastNameTxt).clear();
        driver.findElement(lastNameTxt).sendKeys(lname);
    }
    public void enterbillingStreet(String billingStreet)
    {
        driver.findElement(billingStreetTxt).clear();
        driver.findElement(billingStreetTxt).sendKeys(billingStreet);
    }

    public void enterbillingCity(String city)
    {
        driver.findElement(billingCityTxt).clear();
        driver.findElement(billingCityTxt).sendKeys(city);
    }
    public void enterPostalCode(String zipcode)
    {
        driver.findElement(postCodeTxt).clear();
        driver.findElement(postCodeTxt).sendKeys(zipcode);
    }
    public void enterEmail(String email)
    {
        driver.findElement(emailTxt).clear();
        driver.findElement(emailTxt).sendKeys(email);
    }

    // Pass String as args, ok for dry runs, Always use POJOs long term.
//    public void enterUserDetails(String fname,String lname,String bStreet,String city,String zipcode,String email)
//    {
//        enterFirstName(fname);
//        enterLastName(lname);
//        enterbillingStreet(bStreet);
//        enterbillingCity(city);
//        enterPostalCode(zipcode);
//        enterEmail(email);
//    }

    // Pass POJO as argument
    public void enterUserDetails(BillingAddress billingAddress)
    {
        enterFirstName(billingAddress.getFirstName());
        enterLastName(billingAddress.getLastName());
        enterbillingStreet(billingAddress.getBillingStreet());
        enterbillingCity(billingAddress.getbCity());
        enterPostalCode(billingAddress.getZipCode());
        enterEmail(billingAddress.getEmail());
    }

    public void placeOrder()
    {
        driver.findElement(placeOrderBtn).click();

        //goes to order confirmation page
    }

}
