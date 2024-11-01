package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ui.Button;
import starter.Pages.InventoryPage;
import starter.Pages.LoginPage;
import static org.junit.Assert.*;

import javax.swing.*;

public class LoginStepDef {
    LoginPage loginPage;
    InventoryPage inventoryPage;
    Action action;

    

    @Given("I am on the login page")
    public void iAmOnTheLoginPage(){
        loginPage.open();
    }

    @When("I entered a valid {string} {string}")
    public void iInputUsername(String username, String password){
        loginPage.inputUsername(username,password);
    }

    @And("I input password with {string}")
    public void iInputPassword(String password){
        loginPage.inputPassword(password);
    }

    @And("I click login button")
    public void iClickLoginButton(){
        loginPage.clickLoginButton();
    }

    @Then("I am directed to inventory page")
    public void iAmDirectedToInventoryPage(){
        assertEquals("https://www.saucedemo.com/v1/inventory.html", inventoryPage.getUrl());
        assertEquals("Products", inventoryPage.getHeaderTitle());
        assertTrue(inventoryPage.isShowIconHeader());
    }
    @Given("I am already logged in")
    public void alreadyLoggedIn(){
        loginPage.open();
        loginPage.inputUsername("standard_user","secret_sauce");
        loginPage.clickLoginButton();
    }

    @Given("{actor} is on the login page")
    public void onTheLoginPage(Actor actor) {
        actor.attemptsTo(
                Open.url("https://www.saucedemo.com/")
        );

    }

    @When("{actor} logs in with valid credentials")
    public void LogsInWithValidCredentials(Actor actor) {
        actor.attemptsTo(
                Enter.theValue("standard_user").into("#user-name"),
                Enter.theValue("secret_user").into("#password"),
                loginPage.clickLoginButton()

        );
    }

    @Then("he should be presented with the product catalog")
    public void heShouldBePresentedWithTheProductCatalog() {
    }

    @And("I verify swag lab logo is displayed")
    public void iVerifySwagLabLogoIsDisplayed() {
        loginPage.imagePresent();
    }
}
