package pages;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;

public class AndroidHomePage {
    private AppiumDriver driver;

    // Locators
    private final By wikipediaApp = By.xpath("\t\n" +
            "//android.widget.TextView[@content-desc=\"Wikipedia\"]\n");

    private final By tray = By.xpath("//android.widget.GridView[@resource-id=\"com.google.android.apps.nexuslauncher:id/apps_list_view\"]");

    // Constructor
    public AndroidHomePage(AppiumDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void openTray() {

    }

    public void openWikipediaApp() {
        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 50,
                "top", 55,
                "width", 0,
                "height", 35,
                "direction", "up",
                "percent", 1.0,
                "speed", 3000
        ));

        if (driver.findElement(tray).isDisplayed()) {
            driver.findElement(wikipediaApp).click();
        } else {
            throw new NotFoundException("Could not open Android Tray");
        }
    }
}