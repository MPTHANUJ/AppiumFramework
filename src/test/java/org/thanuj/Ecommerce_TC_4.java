package org.thanuj;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.pageObjects.android.CartPage;
import org.pageObjects.android.ProductCatalouge;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestUtils.AndroidBaseTest;

public class Ecommerce_TC_4 extends AndroidBaseTest{
	
//	@BeforeMethod
//	public void preStartup()
//	{
//		formpage.StartActivity();
//	}

	
	@Test(dataProvider="getData")
	public void FillForm(HashMap<String, String> input) throws InterruptedException
	{
		Thread.sleep(3000);
		
		formpage.setNameField(input.get("name"));
		formpage.setGender(input.get("gender"));
		formpage.setCountrySelection(input.get("country"));
		
		ProductCatalouge productCatalouge =formpage.submitForm();
		
		productCatalouge.addItemToCartByIndex(0);
		productCatalouge.addItemToCartByIndex(0);
		
		CartPage cartPage = productCatalouge.goToCartPage();
		
		double totalSum = cartPage.getProductsSum();
		double displayFromattedSum=cartPage.getTotalAmountDisplayed();
		Assert.assertEquals(totalSum, displayFromattedSum);
		cartPage.acceptTermsConditions();
		cartPage.submitOrder();
		
	}
	
//	@DataProvider
//	public Object getData()
//	{
//		return new Object[][] {{"Ria","female","Argentina"},{"Riaz","male","Argentina"}};
//		
//		
//	}
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>>	data =getJsonData(System.getProperty("user.dir")+"//src//test//java//org//testData//Ecommerece.json");
		
		return new Object[][] { {data.get(0)}  };
		//return new Object[][] { {data.get(0)},{data.get(1)}  };
	}
	
	// Parse Json file -> Json String (Common-io)
	//Json String -> HashMap (jackson)
	//HasMap -> TestCase (TestNG Data Provider)
	
	
}
