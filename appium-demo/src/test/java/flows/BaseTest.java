package flows;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobilePlatform;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;

public class BaseTest {
    protected AppiumDriver driver;
    private final String APP_PATH = Paths.get("src/app/org.wikipedia.apk").toAbsolutePath().toString();

    @BeforeMethod
    public void setUp() {
        UiAutomator2Options capabilities = new UiAutomator2Options()
                .setPlatformName(MobilePlatform.ANDROID)
                .setPlatformVersion("16.0")
                .setDeviceName("emulator-5554")
                .setAutomationName("UIAutomator2")
                .setApp(APP_PATH)
                .setAppWaitActivity("*");

        try {
            URL url = new URI("http://127.0.0.1:4725").toURL();
            driver = new AppiumDriver(url, capabilities);

            System.out.println("Appium started successfully!");
            Thread.sleep(2000);
        } catch (MalformedURLException | InterruptedException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
