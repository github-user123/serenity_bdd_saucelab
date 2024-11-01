package starter.Pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@DefaultUrl("https://www.saucedemo.com/v1/index.html")
public class LoginPage extends PageObject {
    @Managed
    WebDriver driver = getDriver();

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButtonField = By.id("login-button");
    private final By logo = By.xpath("/html/body/div[2]/div[1]/img");


    public void inputUsername(String username, String password){
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void inputPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public Performable clickLoginButton(){
        driver.findElement(loginButtonField).click();
        return null;
    }
    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public boolean imagePresent(){
        boolean img = driver.findElement(logo).isDisplayed();
        assert img;
        return true;
    }

}
