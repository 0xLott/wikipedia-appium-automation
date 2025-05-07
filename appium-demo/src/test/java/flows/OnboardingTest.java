package flows;

import org.testng.annotations.*;
import pages.OnboardingPage;

public class OnboardingTest extends BaseTest {
    OnboardingPage page;

    @Test
    public void skip_to_home_page() {
        page = new OnboardingPage(driver);
        page.skip();
    }

    @Test
    public void navigate_to_home_page() {
        page = new OnboardingPage(driver);
        page.nextPageUntilHome();
    }

    @Test
    public void add_languages() {
        page = new OnboardingPage(driver);
        page.addLanguage(5);
        page.addLanguage(3);
    }
}
