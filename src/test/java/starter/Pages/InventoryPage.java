package starter.Pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import starter.Help;

@DefaultUrl("https://www.saucedemo.com/v1/inventory.html")
public class InventoryPage extends PageObject {
    @Managed
    WebDriver driver = getDriver();
    Help help = new Help();
    private final String pageUrl="https://www.saucedemo.com/v1/inventory.html";
    private final By productSortContainer = By.xpath("//*[@id=\"inventory_filter_container\"]/select");
    private final By activeSortOption4 = By.xpath("//*[@id=\"inventory_filter_container\"]/select/option[4]");
    private final By activeSortOption3 = By.xpath("//*[@id=\"inventory_filter_container\"]/select/option[3]");
    private final By activeSortOption2 = By.xpath("//*[@id=\"inventory_filter_container\"]/select/option[2]");
    private final By activeSortOption1 = By.xpath("//*[@id=\"inventory_filter_container\"]/select/option[1]");
    private final By inventoryList = By.className("inventory_item_name");
    private final By cartButton = By.xpath("//*[@id=\"shopping_cart_container\"]");
    private final By firstItem = By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");
    private final By firstItemName = By.className("inventory_item_name");
    private final By lastItem = By.xpath("//*[@id=\"inventory_container\"]/div/div[6]/div[2]/div");

    private final By firstItemInDesc = By.xpath("//*[@id=\"item_3_title_link\"]/div");

    private final By headertitle = By.xpath("//*[@id=\"inventory_filter_container\"]/div");
    private final By iconHeader = By.xpath("//*[@id=\"inventory_filter_container\"]/div");
    private final By removeButton = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div/button");
    private final By addToCartButton = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div/button");
    private final By oneItem = By.xpath("//*[@id=\"inventory_container\"]/div/div[5]/div[3]/button");
    private final By logout = By.id("logout_sidebar_link");
    private final By loginPage = By.xpath("//*[@id=\"login_button_container\"]");
    private final By allItemsButton = By.xpath("//*[@id=\"menu_button_container\"]/div/div[3]/div/button");
    private final By errorMessage = By.xpath("//*[@id=\"login_button_container\"]/div/form/h3");

    public void clickCartButton(){
        driver.findElement(cartButton).click();
    }
    public String getUrl(){
        return driver.getCurrentUrl();
    }
    public void SelectByVisibleText(By element, String text){
        Select dropdown = new Select(driver.findElement(element));
        dropdown.selectByVisibleText(text);
    }

    public void checkErrorMessage(){
        driver.findElement(errorMessage).isDisplayed();
    }

    public void clickItemsButton(){
        driver.findElement(allItemsButton).click();
    }

    public void clickLogoutButton(){
        driver.findElement(logout).click();
    }

    public void loginPageTitle(){
        driver.findElement(loginPage).isDisplayed();
    }

    public InventoryPage sortProductBy(String sortMethod){
        help.SelectByVisibleText(productSortContainer,sortMethod);
        return this;
    }
    public String getSortProduct(String sortBy){
        String option;
        switch (sortBy) {
            case "Name (Z to A)":
                option = driver.findElement(activeSortOption2).getAttribute("innerHTML");
                break;
            case "Price low to high":
                option = driver.findElement(activeSortOption3).getAttribute("innerHTML");
                break;
            case "Price high to low":
                option = driver.findElement(activeSortOption4).getAttribute("innerHTML");
                break;
            default:
                option = driver.findElement(activeSortOption1).getAttribute("innerHTML");
                break;
        }
        return option;
    }
    public InventoryPage goToPage(){
        driver.get(pageUrl);
        return this;
    }
    public String isShow(){
        return driver.findElement(headertitle).getText();
    }
    public String getHeaderTitle(){
        return driver.findElement(headertitle).getText();
    }
    public boolean isShowIconHeader(){
        return driver.findElement(iconHeader).isDisplayed();
    }
    public void selectItem(String item){
        driver.findElement(By.id(item)).click();
    }
    public void selectFirstItemDesc(){
        driver.findElement(firstItemInDesc).click();
    }
    public String getFirstitem(){
        return driver.findElement(firstItemName).getAttribute("innerHTML");
    }

    public boolean isRemoveButtonShow(){
        String removeBtn = driver.findElement(removeButton).getText();
        if(removeBtn.equals("REMOVE")) {
          return driver.findElement(removeButton).isDisplayed();
           // System.out.println("Remove button displayed");
        }
        else {
           // System.out.println("Remove button not displayed");
            return false;
        }
    }
    public void setAddToCartButton(){
        driver.findElement(addToCartButton).click();
    }
    public void selectOneItem(){
        driver.findElement(oneItem).click();
    }








}
