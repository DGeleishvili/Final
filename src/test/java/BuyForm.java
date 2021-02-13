import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BuyForm extends PageObject{

    private final String FirstName = "Davit";
    private final String LastName = "Geleishvili";
    private final String PostalCode = "11220";

    @FindBy(xpath = "(//*[@class='btn_primary btn_inventory'])[2]")
    private WebElement AddToCart;

    @FindBy(xpath = "//*[@id='shopping_cart_sasacontainer']/a/span")
    private WebElement shoppingCartItemNum;

    @FindBy(xpath = "//*[@class='btn_action checkout_button']")
    private WebElement checkOutBtn;

    @FindBy(xpath = "//*[@id='first-name']")
    private WebElement firstName;

    @FindBy(xpath = "//*[@id='last-name']")
    private WebElement lastName;

    @FindBy(xpath = "//*[@id='postal-code']")
    private WebElement postalCode;

    @FindBy(xpath = "//*[@class='btn_primary cart_button']")
    private WebElement continueFillForm;

    @FindBy(xpath = "//*[@class='btn_action cart_button']")
    private WebElement finishBtn;

    public BuyForm(WebDriver driver) {
        super(driver);
    }

    public void addToCart(){
        this.AddToCart.click();
    }

    public void verifyVisible(){
        this.shoppingCartItemNum.isDisplayed();
    }
    public void moveToCart(){
        this.shoppingCartItemNum.click();
    }

    public void checkOut(){
        this.checkOutBtn.click();
    }
    public void enterName(){
        this.firstName.sendKeys(FirstName);
    }

    public void enterLastName(){
        this.lastName.sendKeys(LastName);
    }
    public void enterZip(){
        this.postalCode.sendKeys(PostalCode);
    }
    public void continueFillForm(){
        this.continueFillForm.click();
    }
    public void finishBtn(){
        this.finishBtn.click();
    }

}
