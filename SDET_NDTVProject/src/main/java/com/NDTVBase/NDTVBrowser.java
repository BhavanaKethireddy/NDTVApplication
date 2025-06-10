package com.NDTVBase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.NDTVUtilities.NDTVUtilities;
public class NDTVBrowser {
	public static WebDriver driver;
	public static Actions action;
	public static WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	public static void openBrowser() throws IOException {
		String choice=NDTVUtilities.utility("browser");
		if (choice.equalsIgnoreCase("Chrome"))
        driver = new ChromeDriver();
		else if (choice.equalsIgnoreCase("Edge"))
        driver = new EdgeDriver();	
		driver.manage().window().maximize();
		driver.get(NDTVUtilities.utility("url"));
    }

}
