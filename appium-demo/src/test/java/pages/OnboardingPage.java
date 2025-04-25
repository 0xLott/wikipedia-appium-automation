package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class OnboardingPage {
    private AppiumDriver driver;

    // Locators
    private By skipBtn = By.xpath("//android.widget.Button[@resource-id=\"org.wikipedia:id/fragment_onboarding_skip_button\"]");
    private By continueBtn = By.xpath("//android.widget.Button[@resource-id=\"org.wikipedia:id/fragment_onboarding_forward_button\"]");
    private By addLanguagesBtn = By.xpath("//android.widget.Button[@resource-id=\"org.wikipedia:id/addLanguageButton\"]");

    // Constructor
    public OnboardingPage(AppiumDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void skip() {
        driver.findElement(skipBtn).click();
    }

    public void nextPage() {
        driver.findElement(continueBtn).click();
    }

    public void addLanguages() {
        driver.findElement(addLanguagesBtn).click();
    }
}