package flows;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.OnboardingPage;
import pages.SearchResultsPage;

public class SearchTest extends BaseTest {
    OnboardingPage onboardingPage;
    HomePage homePage;
    SearchResultsPage searchResultsPage;

    @BeforeMethod
    public void skip_onboarding() {
        onboardingPage = new OnboardingPage(driver);
        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);

        onboardingPage.skip();
    }

    @Test
    public void search() {
        String query = "Appium";
        String subtitle = "Automation for Apps";

        homePage.search(query);
        searchResultsPage.findResult(query, subtitle);
    }
}
