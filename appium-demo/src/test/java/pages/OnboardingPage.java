package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OnboardingPage {
    private static final Logger log = LoggerFactory.getLogger(OnboardingPage.class);
    private AppiumDriver driver;

    // Locators
    private final By skipBtn = By.xpath("//android.widget.Button[@resource-id=\"org.wikipedia:id/fragment_onboarding_skip_button\"]");
    private final By continueBtn = By.xpath("//android.widget.Button[@resource-id=\"org.wikipedia:id/fragment_onboarding_forward_button\"]");
    private final By getStartedBtn = By.xpath("//android.widget.Button[@resource-id=\"org.wikipedia:id/fragment_onboarding_done_button\"]");

    private final By addEditLanguagesBtn = By.xpath("//android.widget.Button[@resource-id=\"org.wikipedia:id/addLanguageButton\"]");
    private final By addEditLanguagesTitle = By.xpath("//android.widget.TextView[@text=\"Wikipedia languages\"]");
    private final By addLanguageBtn = By.xpath("//android.widget.TextView[@resource-id=\"org.wikipedia:id/wiki_language_title\" and @text=\"Add language\"]");

    private final By homepageSearchLabel = By.xpath("//android.widget.ImageView[@resource-id=\"org.wikipedia:id/main_toolbar_wordmark\"]");

    // Constructor
    public OnboardingPage(AppiumDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void skip() {
        driver.findElement(skipBtn).click();
        sleep(1000);
        driver.findElement(homepageSearchLabel).isDisplayed();
    }

    private void nextPage() {
        driver.findElement(continueBtn).click();
    }

    /**
     * Uses `findElements` to safely check for the presence of the home page element
     * without throwing an exception if it's not found.
     */
    public void nextPageUntilHome() {
        while (driver.findElements(getStartedBtn).isEmpty()) {
            nextPage();
        }

        driver.findElement(getStartedBtn).click();
        sleep(2000);
        driver.findElement(homepageSearchLabel).isDisplayed();
    }

    public void addLanguage(int index) {
        By language;

        if (driver.findElements(addEditLanguagesTitle).isEmpty()) {
            driver.findElement(addEditLanguagesBtn).click();
        }

        sleep(3000);
        driver.findElement(addLanguageBtn).click();

        sleep(3000);
        language = By.xpath(String.format("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"org.wikipedia:id/languages_list_recycler\"]/android.widget.LinearLayout[%d]", index));

        driver.findElement(language).click();
    }

    private void sleep(int millisseconds) {
        try {
            Thread.sleep(millisseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}