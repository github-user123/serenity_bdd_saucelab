package starter.Pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@DefaultUrl("https://www.saucedemo.com/v1/checkout-complete.html")
public class CheckoutCompletePage extends PageObject {
    WebDriver driver = getDriver();
    private final By ponyExpressImage = By.className("pony_express");

    public boolean isShowponyExpressImage(){
        return driver.findElement(ponyExpressImage).isDisplayed();
    }
}
