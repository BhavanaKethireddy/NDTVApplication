package com.NDTVPages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;

import com.NDETScreenshot.ScreenShot;
import com.NDTVBase.NDTVBrowser;

public class HomePage extends NDTVBrowser {
	public static String mainMenu(String menu) {
		return "//a[text()='" + menu + "']";
	}
	/*
	public static String auto() {
		return "//p[text()='Auto related news ']";
	}
	*/

	public static String menu;
	public static String autoElemenet;
	public static void mainMenuSelector(String Name, String target) throws Exception {
		menu = mainMenu(Name);
		WebElement web = driver.findElement(By.xpath(menu));
		action = new Actions(driver);
//		action.contextClick(web).perform();
		/*
		 * if(target.equalsIgnoreCase("New window"))
		 * action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform(); else
		 * action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.
		 * ENTER).perform();
		 */
		Robot robo = new Robot();
		action.contextClick(web).build().perform();
		Robot robot = new Robot();
		if (target.equalsIgnoreCase("window")) {
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(500);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} else {
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(500);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
		}
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));             // move to next window/tab
        System.out.println("Title of the second tab: " + driver.getCurrentUrl());
        WebElement auto = driver.findElement(By.xpath("//h2[text()='Auto']"));  // auto
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",auto);    // scroll to auto
        
        WebElement elemenet = driver.findElement(By.xpath("//a[contains(text(), 'Aston Martin')]"));
        js.executeScript("arguments[0].scrollIntoView(true)",elemenet);         // scroll to videos in auto
        ScreenShot.screenShot("//a[contains(text(), 'Aston Martin')]","Martin");
        driver.switchTo().window(windows.get(0));                               // return to parent window
        System.out.println("Title of the second tab: " + driver.getTitle());
        ScreenShot.screenShot("//div[@class='co25vid-wrp']","Covid");                                         // screenshot
        WebElement live = driver.findElement(By.xpath("//li[@class='m-nv_li dd-nav_one dd-nav_hvr']/a"));    // click on live Tv
        action.moveToElement(live).perform();
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.xpath("//img[@class='ndtv_ind']")).click();
        System.out.println(driver.getCurrentUrl());
        /*
        Thread.sleep(20000);
        driver.findElement(By.xpath("//button[@id='moe-dontallow_button']")).click();
//        js.executeScript("window.scrollBy(0,50)");
        Thread.sleep(5000);
        WebElement active = driver.findElement(By.xpath("//span[text()='Most Active']"));            
        System.out.println(driver.getCurrentUrl());
        active.click();
        js.executeScript("arguments[0].scrollIntoView(true)",active); 
        WebElement more = driver.findElement(By.xpath("//div[@class='budget-stocks-in-focus-horizontal-m__btn__FQAfu']"));
        action.contextClick(more);
        robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		/*
		WebElement nifty = driver.findElement(By.xpath("//p[text()='NIFTY']//ancestor::div[@class='indian-indices-m__stats-one__LxrXQ']//following-sibling::div/p"));
		System.out.println("Nifty Value: "+nifty.getText());
		*/
		
		
        
        driver.switchTo().newWindow(WindowType.TAB);             // to open new tab
        driver.get("https://www.moneycontrol.com/");             // Navigate to the new URL
        Thread.sleep(2000);
        ScreenShot.screenShot("//div[@class='MT15']","Global_Market"); 
        driver.switchTo().window(windows.get(0));  
        driver.navigate().back();
        js.executeScript("arguments[0].scrollIntoView(true)",driver.findElement(By.xpath("//div[@class='co25vid-wrp']"))); 
	}

}
