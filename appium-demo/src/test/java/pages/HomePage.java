package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import static utils.Utils.sleep;

public class HomePage {

    private AppiumDriver driver;

    // Locators
    private final By emptySearchBar = By.id("org.wikipedia:id/search_container");
    private final By searchBar = By.id("org.wikipedia:id/search_src_text");
    private final By voiceSearchIcon = By.xpath("//android.widget.ImageView[@content-desc=\"Voice input search\"]");

    // Constructor
    public HomePage(AppiumDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void search(String query) {
        driver.findElement(emptySearchBar).click();
        sleep(1000);
        driver.findElement(searchBar).sendKeys(query);
    }
}
