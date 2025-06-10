package com.TestCases;

import org.testng.annotations.Test;
import com.NDTVBase.NDTVBrowser;
import com.NDTVPages.HomePage;

public class NDTVTest {
	@Test
	public void testCases() throws Exception {
		NDTVBrowser.openBrowser();
		HomePage.mainMenuSelector("Videos ", "tab");
		
	}
}
