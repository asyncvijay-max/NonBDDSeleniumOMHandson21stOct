package tests;

import base.BaseTest;
import domain.BillingAddress;
import org.testng.annotations.Test;
import pages.*;

public class CheckOutManagement extends BaseTest {


    @Test
    public void guestNoLoginDuringCheckOutE2E()
    {

   //Test Case - Guest checkout using Direct Bank Transfer,no Login during checkout flow

    HomePage homePage = new HomePage(driver);
    homePage.loadPage("/");
    homePage.navigateToStorePage();

    StorePage storePage = new StorePage(driver);
    storePage.searchTheProductInTheSearchBox("blue");
    storePage.clickOnTheSearchBtn();
    //Need to assert the search result text later

    storePage.addProductToTheCart("Blue Shoes");
    storePage.clickOnViewCartLink();

    CartPage cartPage = new CartPage(driver);
    //Need to assert the product Name,product Qty in the Cart later
    cartPage.clickOnProceedToCheckOutBtn();

     CheckOutPage checkOutPage = new CheckOutPage(driver);
//    String fname = "Kiran";
//    String lastname ="John";
//    String billstreet = "123 Oven street";
//    String bcity = "New York";
//    String zipcode ="10001";
//    String email = "joe.kiran@testing.com";


    //checkOutPage.enterUserDetails(fname,lastname,billstreet,bcity,zipcode,email);

        BillingAddress billingAddress = new BillingAddress();
        billingAddress.setFirstName("Charlie");
        billingAddress.setLastName("Chaps");
        billingAddress.setBillingStreet("1234 Collin St");
        billingAddress.setbCity("New York");
        billingAddress.setZipCode("10001");
        billingAddress.setEmail("chapscharlie@testing.com");

        checkOutPage.enterUserDetails(billingAddress);

        checkOutPage.placeOrder();

       OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        //Need to assert the order confirmation text ,later








    }
}
