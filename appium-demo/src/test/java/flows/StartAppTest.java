package flows;

import org.testng.annotations.Test;
import pages.AndroidHomePage;

public class StartAppTest extends BaseTest {
    @Test
    public void startApp() {
        AndroidHomePage page = new AndroidHomePage(driver);

        page.openWikipediaApp();
    }
}