package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import starter.Pages.InventoryPage;

public class AddToCartStepDef {

    InventoryPage inventoryPage;
    @When("I select item {string}")
    public void iSelectItem(String item){
        inventoryPage.selectItem(item);
    }

    @And("I click on ADD TO CART button")
    public void iClickAddToCart(){
        inventoryPage.setAddToCartButton();
    }

    @Then("Add to Cart button change to be Remove Button")
    public void AddToCartButtonChangeToBeRemoveButton(){
        inventoryPage.isRemoveButtonShow();
    }

}
