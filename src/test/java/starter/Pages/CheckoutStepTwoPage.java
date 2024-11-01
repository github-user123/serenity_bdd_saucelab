package starter.Pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@DefaultUrl("https://www.saucedemo.com/v1/checkout-step-two.html")
public class CheckoutStepTwoPage extends PageObject {
    WebDriver driver = getDriver();
    private final By finishButton = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]/a[2]");


    public void clickFinishButton(){
        driver.findElement(finishButton).click();
    }

}
