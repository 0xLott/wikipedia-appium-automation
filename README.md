# Wikipedia Mobile App Automation

Automated test suite for the Wikipedia mobile app using Appium + TestNG.

This repository contains end-to-end tests for the Wikipedia mobile app on Android platform.

---

## Prerequisites

- Node.js 24 installed
- Maven 3.9.9 (or newer) installed
- Java JDK 17 (or newer) installed
- Android SDK installed
- ANDROID_HOME environment variable set
- [Wikipedia .apk](https://f-droid.org/en/packages/org.wikipedia/)

> [!IMPORTANT]  
> These tests are best suited for Wikipedia app version r/2.7.50529-r-2025-04-21 (50529). They may not apply to newer or
> older versions.

## Installation

1. Install Appium with appium-installer

```bash
npm install -g appium-installer
```

2. Install Appium Driver (`UiAutomator2` for Android, `XCUITestOptions` for iOS)

```bash
appium driver install uiautomator2
```

3. Install Appium Inspector Plugin

```bash
appium plugin install --source=npm appium-inspector
```

4. Install dependencies with Maven

```
mvn install
```

## Directory structure

This is what this project's directory structure should look like:

```
.
├── src/
│   ├── app/
│   │   └── org.wikipedia.apk
│   └── test/
│       └── java/
│           ├── flows/
│           └── pages/
├── testng.xml
└── pom.xml
```

## Running Appium

1. Add Wikipedia .apk file to `src/app/org.wikipedia.apk`
2. Start Appium Server with Inspector. I've found that using other port than the default (4723) is the most foolproof
   way.

```bash
# Custom port (e.g., 4725)
appium -p 4725 --use-plugins=inspector --allow-cors
```

3. Access Appium Inspector via http://localhost:4725/inspector
4. Configure a session. Below is a session template:

```json
{
  "platformName": "Android",
  "appium:automationName": "UIAutomator2",
  "appium:platformVersion": "16.0",
  "appium:deviceName": "emulator-5554"
}
```

5. Start session

## Verification

Check installed drivers and plugins:

```bash
appium driver list
appium plugin list
```

## Troubleshooting

If port is already in use, run the following **MacOS/Linux** commands:

```bash
lsof -i :4723  # Check what's using the port
kill -9 <PID>  # Kill the process using the port
```
