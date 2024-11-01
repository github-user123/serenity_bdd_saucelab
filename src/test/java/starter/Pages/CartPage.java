package starter.Pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@DefaultUrl("https://www.saucedemo.com/cart.html")
public class CartPage extends PageObject {
    WebDriver driver = getDriver();
    private String pageUrl = "https://www.saucedemo.com/v1/cart.html";

    private By removeButton = By.xpath("//button[@id='remove-sauce-labs-backpack']");
    private By removeBtn = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/button");
    private By continueShoppingButton = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[2]/a[1]");
    private By oneproduct = By.id("inventory_item_name");
    private final By productname = By.xpath("//*[@id=\"item_4_title_link\"]/div");
    private  final By checkoutButton = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[2]/a[2]");
    private  final By lastItemInCartList = By.xpath("//*[@id=\"item_3_title_link\"]/div");
    private final By lastitemNameadded = By.xpath("//*[@id=\"item_2_title_link\"]/div");
    private final By firstproductnameadd = By.className("inventory_item_name");



    public void clickRemoveButton(){
        driver.findElement(removeButton).click();
    }
    public void clickContinueShopping(){
        driver.findElement(continueShoppingButton).click();
    }
    public String getUrl(){
        return driver.getCurrentUrl();
    }
    public CartPage goToPage(){
        driver.get(pageUrl);
        return this;
    }
    public void getItem(){
        driver.findElement(oneproduct).isDisplayed();
    }
    public void removeItem(){
//        driver.findElement(lastitemNameadded).click();
        driver.findElement(removeBtn).click();
    }
    public CartPage allProductRemoved(){
        List<WebElement> removeButtons = driver.findElements(removeButton);
        for (WebElement rb :removeButtons){
            rb.click();
        }
        return  this;
    }
    public String getProductname(String item) {
        return driver.findElement(By.id(item)).getText();
    }
    public String getFirstProductNameAdded(){
        return driver.findElement(firstproductnameadd).getAttribute("innerHTML");
    }
    public String getLastProductadded(){
        return driver.findElement(lastitemNameadded).getAttribute("innerHTML");
    }
    public void clickCheckoutButton(){
        driver.findElement(checkoutButton).click();
    }



}
