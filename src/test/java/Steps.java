import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Steps {
    public static WebDriver driver;

    public static void findSendKeysClick(String xpath, String text){
        WebElement element = driver.findElement(By.xpath(xpath));
        element.sendKeys(text);
        element.submit();
    }
}
