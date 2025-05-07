package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage {

    private AppiumDriver driver;

    // Locators
    private final By results = By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"org.wikipedia:id/search_results_list\"]/android.view.ViewGroup");
    private final By resultsTitles = By.id("org.wikipedia:id/page_list_item_title");
    private final By resultsSubtitles = By.id("org.wikipedia:id/page_list_item_description");

    // Constructor
    public SearchResultsPage(AppiumDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void findResult(String query, String subtitle) {
        List<WebElement> titles =  driver.findElements(resultsTitles);
        List<WebElement> subtitles = driver.findElements(resultsSubtitles);

        WebElement appiumSubtitle = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"org.wikipedia:id/page_list_item_description\" and @text=\"" + subtitle + "\"]"));

        for (WebElement title : titles) {
            if (title.getText().equals(query) && subtitles.contains(appiumSubtitle)) {
                title.click();
                sleep(3000);
                break;
            }
        }
    }

    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
