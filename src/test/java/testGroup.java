import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;

public class testGroup {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", ConfigElements.ChromeDriverLocation);
    }

    @Test(testName = "Steps at Saucedemo")
    public static void submitLoginInfo(){
        try {
            driver.get(ConfigElements.url);
            driver.manage().window().maximize();
            LoginForm loginForm = new LoginForm(driver);
            loginForm.enterUsername();
            loginForm.enterPassword();
            loginForm.pressLoginButton();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            loginForm.verifyLoginSuccess();
        }
        catch (Exception e)
        {
            System.out.println("Something went wrong - See screenshot on D drive");
            TakeScreenshot.takeScreenshot(driver);
        }
        try {
            WebElement dropDown = driver.findElement(By.xpath("//*[@class='product_sort_container']"));
            Select priceOptions = new Select(dropDown);
            priceOptions.selectByIndex(2);
        }
        catch (Exception e)
        {
            System.out.println("Something went wrong - See screenshot on D drive");
            TakeScreenshot.takeScreenshot(driver);
        }
        try {
            String addToCartText = driver.findElement(By.xpath("(//*[@class='btn_primary btn_inventory'])[2]")).getText();
            Assert.assertEquals("ADD TO CART",addToCartText );
        }
        catch (Exception e)
        {
            System.out.println("Something went wrong - See screenshot on D drive");
            TakeScreenshot.takeScreenshot(driver);
        }
        try {
            BuyForm buyForm = new BuyForm(driver);
            buyForm.addToCart();
            buyForm.verifyVisible();
            buyForm.moveToCart();
            buyForm.checkOut();
            buyForm.enterName();
            buyForm.enterLastName();
            buyForm.enterZip();
            buyForm.continueFillForm();
            buyForm.finishBtn();
        }
        catch (Exception e){
            System.out.println("Something went wrong - See screenshot on D drive");
            TakeScreenshot.takeScreenshot(driver);
        }
    }

    @AfterSuite
    public static void closeChrome(){
        //driver.close();
    }
}
