package com.candymapper.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public Properties prop;

	// ThreadLocal for WebDriver to handle parallel test execution
	private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
	
	// New method to load properties
    public void loadProperties() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\Ravikumar\\eclipse-workspace\\CandyMapperAutomationFramework\\src\\test\\java\\com\\candymapper\\config\\production.properties");
        prop.load(fis);
    }

	@BeforeMethod
	public void setUp(ITestContext context) throws IOException {
		
		loadProperties(); // Load properties here
        String browser = prop.getProperty("baseUrl");
        System.out.println(browser);

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		// Add any desired options here
		WebDriver getDriver = new ChromeDriver(options);
		threadLocalDriver.set(getDriver);
		getDriver.manage().window().maximize();
		getDriver.get(browser);

	}
	
	public static WebDriver getDriver() {
		return threadLocalDriver.get();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@AfterMethod
	public String getScreenshotPath(ITestResult testResult) throws IOException {
		String destinationFile = null;
		if (ITestResult.FAILURE == testResult.getStatus()) {
			TakesScreenshot ts = (TakesScreenshot) getDriver();
			File source = ts.getScreenshotAs(OutputType.FILE);
			destinationFile = System.getProperty("user.dir") + "\\screenshots\\" + testResult.getName() + ".png";
			FileUtils.copyFile(source, new File(destinationFile));
			System.out.println("Screenshot saved at: " + destinationFile);
		}
		getDriver().manage().deleteAllCookies();
		System.out.println("Deleted All Cookies!");
		return destinationFile;
	}

	public ArrayList<String> executeSQLQuery_List(String sqlQuery) {
		ArrayList<String> resultValue = new ArrayList<>();
		String dbURL = prop.getProperty("db.url");
		String user = prop.getProperty("db.user");
		String pass = prop.getProperty("db.password");

		try (Connection conn = DriverManager.getConnection(dbURL, user, pass);
				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery(sqlQuery)) {

			if (conn != null) {
				System.out.println("Connected to the database");
			} else {
				System.out.println("Failed to connect to database");
			}

			while (resultSet.next()) {
				int columnCount = resultSet.getMetaData().getColumnCount();
				StringBuilder stringBuilder = new StringBuilder();
				for (int iCounter = 1; iCounter <= columnCount; iCounter++) {
					stringBuilder.append(resultSet.getString(iCounter).trim()).append(" ");
				}
				resultValue.add(stringBuilder.toString().trim());
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception: " + e.getMessage());
		}

		return resultValue;
	}

}

