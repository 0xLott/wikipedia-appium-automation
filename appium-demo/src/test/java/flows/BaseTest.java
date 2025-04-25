package flows;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobilePlatform;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class BaseTest {
    protected static AppiumDriver driver;

    @BeforeClass
    public static void setUp() {
        UiAutomator2Options capabilities = new UiAutomator2Options()
                .setPlatformName(MobilePlatform.ANDROID)
                .setPlatformVersion("16.0")
                .setDeviceName("emulator-5554")
                .setAutomationName("UIAutomator2");

        try {
            URL url = new URI("http://127.0.0.1:4725").toURL();
            driver = new AppiumDriver(url, capabilities);

            System.out.println("Appium started successfully!");
            Thread.sleep(2000);
        } catch (MalformedURLException | InterruptedException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
