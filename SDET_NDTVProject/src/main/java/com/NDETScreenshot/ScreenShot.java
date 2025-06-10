package com.NDETScreenshot;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.NDTVBase.NDTVBrowser;

public class ScreenShot extends NDTVBrowser{
	public static String screenShot(String path, String name) throws Exception{
		//String path = "//div[@class=\"co25vid-wrp\"]";
		WebElement covidNews= driver.findElement(By.xpath(path));
//		WebElement  AstonAuto = driver.findElement(By.xpath("/a[contains(text(), 'Aston Martin')]"));
		try
		{
			//TakesScreenshot screenshot=((TakesScreenshot)driver); 
			//File source=screenshot.getScreenshotAs(OutputType.FILE);  // takes cmplt page screenshot
			File source = covidNews.getScreenshotAs(OutputType.FILE);   // takes particular elemenet screenshot
//			File source = AstonAuto.getScreenshotAs(OutputType.FILE);
			path=System.getProperty("user.dir")+ "\\target\\ScreenShot\\"+name+".png";
			File destination=new File(path);
			source.renameTo(destination);
		}
		catch(Exception e)
		{
			System.out.println("During Screenshot");
		}
		return path;
	}

}
