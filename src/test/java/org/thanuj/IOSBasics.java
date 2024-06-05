package org.thanuj;

import org.pageObjects.ios.AlertViews;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.TestUtils.IOSBaseTest;

public class IOSBasics extends IOSBaseTest{

	
	@Test
	public void IOSBasicsTest()
	{
		
		
		AlertViews alertviews = homePage.selectAlertViews();
		alertviews.fillTextLabel("Hello");
		String ActualMessage = alertviews.getConfirmMessage();
		Assert.assertEquals(ActualMessage,"A message should be short, complete sentence.");
		
	}
}
