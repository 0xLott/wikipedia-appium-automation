package flows;

import org.testng.annotations.Test;
import pages.AndroidHomePage;

/**
 * These tests do not launch the app directly. Instead, they start from the device's home screen.
 * To run them, remove the following capabilities from ./BaseTest.java:
 *   .setApp(APP_PATH)
 *   .setAppWaitActivity("*")
 * This approach is useful for testing cold start behavior or verifying launcher interactions.
 */
public class ManualStartTest extends BaseTest {
    @Test
    public void start_app() {
        AndroidHomePage page = new AndroidHomePage(driver);

        page.openWikipediaApp();
    }
}