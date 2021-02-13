import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends PageObject{

    private final String Username = "standard_user";
    private final String Password = "secret_sauce";

    @FindBy(xpath = "//*[@id='user-name']")
    private WebElement username;

    @FindBy(xpath = "//*[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//*[@id='login-button']")
    private WebElement loginbutton;

    @FindBy(xpath = "//*[@class='inventory_list']")
    private WebElement successLogin;


    public LoginForm(WebDriver driver) {

        super(driver);
    }

    public void enterUsername(){

        this.username.sendKeys(Username);
    }

    public void enterPassword(){

        this.password.sendKeys(Password);
    }

    public void pressLoginButton(){

        this.loginbutton.click();
    }

    public void verifyLoginSuccess(){

        this.successLogin.isDisplayed();
    }

}
