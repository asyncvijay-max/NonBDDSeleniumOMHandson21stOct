package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.StorePage;

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
    //Need to assert product Name,product Qty later
    cartPage.clickOnProceedToCheckOutBtn();






    }
}
