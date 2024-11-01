package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.Pages.CartPage;
import starter.Pages.InventoryPage;
import starter.Pages.LoginPage;
import static org.junit.Assert.*;

public class InventoryStepDef {
    CartPage cartPage;
    InventoryPage inventoryPage;



    @Given("I have already add one product on cart")
    public void iHaveAlreadyAddOneProductOnCart(){
        inventoryPage.selectOneItem();
    }

    @And("I am on the inventory page")
    public void iAmOnTheInventoryPage(){
        inventoryPage.goToPage();
    }
    @When("I sort the product by {string}")
    public void iSortTheProductBy(String sortBy){
        inventoryPage.sortProductBy(sortBy);
    }
    @Then("Sort menu show {string}")
    public void sortMenuShow(String sortBy){
        assertEquals(sortBy, inventoryPage.getSortProduct(sortBy));
    }
    @When("I click add to cart button on the first product on the list")
    public void IAddFirstItemOnDescList(){
        inventoryPage.selectFirstItemDesc();
    }
    @And("I click on cart button")
    public void iClickOnCartButton(){
        inventoryPage.clickCartButton();
    }
    @Then("I am directed to cart page")
    public void iAmDirectedToCartPage(){
        cartPage.goToPage();

    }
    @And("The selected product appears in cart list")
    public void theSelectedProductAppearsInCartList() {
        assertEquals("Sauce Labs Onesie",cartPage.getLastProductadded());

    }
    @When("I click on remove button on the first product item added in the cart list")
    public void iClickOnRemoveButtonOnTheLastProductInList(){
        cartPage.removeItem();
    }


    @And("I click on continue shopping button")
    public void iClickOnContinueShoppingButton(){
        cartPage.clickContinueShopping();
    }
    @Then("I am redirected back to the inventory page")
    public void redirectedBackToInventoryPage(){
        assertEquals("https://www.saucedemo.com/v1/inventory.html", inventoryPage.getUrl());
        assertEquals("Products", inventoryPage.getHeaderTitle());
        assertTrue(inventoryPage.isShowIconHeader());
    }


    @When("I navigate to logout")
    public void iNavigateToLogout() {
        inventoryPage.clickItemsButton();
    }

    @Then("I am directed to the login page")
    public void iAmDirectedToTheLoginPage() {
        inventoryPage.loginPageTitle();
    }

    @And("I click logout button")
    public void iClickLogoutButton() {
        inventoryPage.clickLogoutButton();
    }

    @Then("I see user locked out error message displayed")
    public void iSeeUserLockedOutErrorMessageDisplayed() {
        inventoryPage.checkErrorMessage();
    }
}
