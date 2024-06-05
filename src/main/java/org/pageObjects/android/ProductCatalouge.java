package org.pageObjects.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.thanuj.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalouge extends AndroidActions{

AndroidDriver driver;
	
	public ProductCatalouge(AndroidDriver driver)
	{
		super(driver);
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> addToCart;
	//driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']"))
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cart;
	
	public void addItemToCartByIndex(int index)
	{
		addToCart.get(index).click();
	
	}
	public CartPage goToCartPage() throws InterruptedException
	{
		cart.click();
		Thread.sleep(3000);
		return new CartPage(driver);
		
		
	}
}
