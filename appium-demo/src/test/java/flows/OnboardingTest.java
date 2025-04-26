package flows;

import org.testng.annotations.*;
import pages.OnboardingPage;

public class OnboardingTest extends BaseTest{
    OnboardingPage page;

    @Test
    public void skipToHomePage() {
        page = new OnboardingPage(driver);
        page.skip();
    }

    @Test
    public void navigateToHomePage() {
        page = new OnboardingPage(driver);
        page.nextPageUntilHome();
    }
}
