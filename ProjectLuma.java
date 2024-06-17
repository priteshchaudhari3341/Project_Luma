package ExcelR_Project;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ProjectLuma {
	WebDriver driver;
	
	@BeforeMethod()
	public void SetUp() throws InterruptedException {
		
		System.setProperty("WebDriver.chrome.driver", 
				"F:\\Testing classes\\Download files from C drive\\Browser Drivers\\chromedriver-win64\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(3000);
	}
	
	@Test(priority=1)
	public void Validate_Registering_an_Account_by_providing_only_the_Mandatory_fields() throws InterruptedException {	
		driver.findElement(By.linkText("Create an Account")).click();
		driver.findElement(By.id("firstname")).sendKeys("sandy");
		driver.findElement(By.id("lastname")).sendKeys("sharma");
		driver.findElement(By.id("email_address")).sendKeys("sandy123@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Sandii12345");
		driver.findElement(By.id("password-confirmation")).sendKeys("Sandii12345");
		driver.findElement(By.xpath("//button[@class='action submit primary']")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=2)
	public void verifyLogo() throws InterruptedException {
		
		boolean flag = driver.findElement(By.xpath("//a[@class='logo']")).isDisplayed();
		Assert.assertTrue(flag);
		Thread.sleep(3000);
	}
	
	@Test(priority=3)
	public void verifyTitle() throws InterruptedException {
		
		String actualTitle=driver.getTitle();
		String expectedTitle="Home Page";
		Assert.assertEquals(actualTitle, expectedTitle);
		Thread.sleep(3000);
	}
	
	@Test(priority=4)
	public void Valid_logging_credentials() throws InterruptedException {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("sandy123@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Sandii12345");
		driver.findElement(By.id("send2")).click();	
		Thread.sleep(3000);
	}
	
	@Test(priority=5)
	public void Invalid_logging_credentials() throws InterruptedException {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("xyz123@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("xyz12345");
		driver.findElement(By.id("send2")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=6)
	public void Valid_email_Invalid_password() throws InterruptedException {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("sandy123@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("xyz12345");
		driver.findElement(By.id("send2")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=7)
	public void Invalid_email_Valid_password() throws InterruptedException {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("sandy123@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("xyz12345");
		driver.findElement(By.id("send2")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=8)
	public void Blank_logging_credentials() throws InterruptedException {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("pass")).sendKeys("");
		driver.findElement(By.id("send2")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=9)
	public void Validate_Forgotten_Password_link_is_available_in_Login_page_and_is_working() throws InterruptedException {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("pass")).sendKeys("");
		driver.findElement(By.xpath("//a[@class='action remind']")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=10)
	public void Validate_Logging_into_the_Application_and_browsing_back_using_Browser_back_button() throws InterruptedException {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("sandy123@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Sandii12345");
		driver.findElement(By.id("send2")).click();
		driver.navigate().back();
		Thread.sleep(3000);
	}
	
	@Test(priority=11)
	public void Validate_Loggingout_from_the_Application_and_browsing_back_using_Browser_back_button() throws InterruptedException {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("sandy123@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Sandii12345");
		driver.findElement(By.id("send2")).click();
		driver.findElement(By.xpath("(//span[@class='customer-name'])[1]")).click();
		driver.findElement(By.xpath("//div[@aria-hidden='false']//a[normalize-space()='Sign Out']")).click();
		driver.navigate().back();
		Thread.sleep(3000);
	}
	
	@Test(priority=12)
	public void Validate_Logging_into_the_Application_after_changing_the_password() throws InterruptedException {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("sandy123@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Sandii12345");
		driver.findElement(By.xpath("//a[@class='action remind']")).click();
		driver.findElement(By.id("email_address")).sendKeys("sandy123@gmail.com");
		driver.findElement(By.xpath("//span[normalize-space()='Reset My Password']")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=13)
	public void Validate_Grid_views_when_multiple_Products_are_displayed_in_the_search_results() throws InterruptedException {
		driver.findElement(By.id("search")).sendKeys("bag");
		driver.findElement(By.xpath("//span[@class='qs-option-name']")).click();
		driver.findElement(By.xpath("(//strong[@class='modes-mode active mode-grid'])[1]")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=14)
	public void Validate_List_views_when_multiple_Products_are_displayed_in_the_search_results() throws InterruptedException {
		driver.findElement(By.id("search")).sendKeys("bag");
		driver.findElement(By.xpath("//span[@class='qs-option-name']")).click();
		driver.findElement(By.id("mode-list")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=15)
	public void Validate_searching_with_existing_Product_Name() throws InterruptedException {
		driver.findElement(By.id("search")).sendKeys("Pants");	
		Thread.sleep(3000);
	}
	
	@Test(priority=16)
	public void Validate_searching_with_non_existing_Product_Name() throws InterruptedException {
		driver.findElement(By.id("search")).sendKeys("iMac");
		Thread.sleep(3000);
	}
	
	@Test(priority=17)
	public void Validate_the_Thumbnails_of_the_Product_displayed_in_the_Product_Display_Page() throws InterruptedException {
		driver.findElement(By.xpath("(//img[@class='product-image-photo'])[4]")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=18)
	public void Validate_navigating_to_Home_Page_from_Shopping_Cart_page() {
		driver.findElement(By.xpath("(//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e'])[1]")).click();
		driver.findElement(By.linkText("Jackets")).click();
		driver.findElement(By.linkText("Home")).click();
	}
	
	@Test(priority=19)
	public void Validate_the_Products_list_is_sort_By_Product_Name() throws InterruptedException {
		driver.findElement(By.xpath("(//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e'])[1]")).click();
		driver.findElement(By.linkText("Jackets")).click();
		Select sel = new Select(driver.findElement(By.id("sorter")));
		sel.selectByValue("name");
		Thread.sleep(3000);
	}
	
	@Test(priority=20)
	public void Validate_the_Products_list_is_sort_By_Position() throws InterruptedException {
		driver.findElement(By.xpath("(//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e'])[1]")).click();
		driver.findElement(By.linkText("Jackets")).click();
		Select sel = new Select(driver.findElement(By.id("sorter")));
		sel.selectByValue("position");
		Thread.sleep(3000);
	}
	
	@Test(priority=21)
	public void Validate_the_Products_list_is_sort_By_Price() throws InterruptedException {
		driver.findElement(By.xpath("(//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e'])[1]")).click();
		driver.findElement(By.linkText("Jackets")).click();
		Select sel = new Select(driver.findElement(By.id("sorter")));
		sel.selectByValue("price");
		Thread.sleep(3000);
	}
	
	@Test(priority=22)
	public void Validate_the_Products_Select_XS_size_of_Product_Display_Page() throws InterruptedException {
		driver.findElement(By.xpath("(//img[@class='product-image-photo'])[4]")).click();
		driver.findElement(By.id("option-label-size-143-item-166")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=23)
	public void Validate_the_Products_Select_S_size_of_Product_Display_Page() throws InterruptedException {
		driver.findElement(By.xpath("(//img[@class='product-image-photo'])[4]")).click();
		driver.findElement(By.id("option-label-size-143-item-167")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=24)
	public void Validate_the_Products_Select_M_size_of_Product_Display_Page() throws InterruptedException {
		driver.findElement(By.xpath("(//img[@class='product-image-photo'])[4]")).click();
		driver.findElement(By.id("option-label-size-143-item-168")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=25)
	public void Validate_the_Products_Select_L_size_of_Product_Display_Page() throws InterruptedException {
		WebElement downword = driver.findElement(By.xpath("(//img[@class='product-image-photo'])[4]"));
		Actions act = new Actions(driver);
		act.moveToElement(downword).perform();
		driver.findElement(By.xpath("//div[@option-label='L']")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=26)
	public void Validate_the_Products_Select_XL_size_of_Product_Display_Page() throws InterruptedException {
		WebElement downword = driver.findElement(By.xpath("(//img[@class='product-image-photo'])[4]"));
		Actions act = new Actions(driver);
		act.moveToElement(downword).perform();
		driver.findElement(By.xpath("//div[@option-label='XL']")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=27)
	public void Validate_the_Products_Select_Black_Colour_of_Product_Display_Page() throws InterruptedException {
		driver.findElement(By.xpath("(//img[@class='product-image-photo'])[4]")).click();
		driver.findElement(By.xpath("//div[@option-label='Black']")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=28)
	public void Validate_the_Products_Select_Gray_Colour_of_Product_Display_Page() throws InterruptedException {
		driver.findElement(By.xpath("(//img[@class='product-image-photo'])[4]")).click();
		driver.findElement(By.xpath("//div[@option-label='Gray']")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=29)
	public void Validate_the_Products_Select_Green_Colour_of_Product_Display_Page() throws InterruptedException {
		driver.findElement(By.xpath("(//img[@class='product-image-photo'])[4]")).click();
		driver.findElement(By.xpath("//div[@option-label='Green']")).click();
		Thread.sleep(3000);
	}
	
	
	
	@Test(priority=30)
	public void Validate_the_Price_of_the_Product_with_and_without_tax_is_displayed_in_the_Product_Display_Page() throws InterruptedException {
		driver.findElement(By.xpath("(//img[@class='product-image-photo'])[4]")).click();
		driver.findElement(By.xpath("(//span[@class='price'])[4]")).isDisplayed();
		Thread.sleep(3000);
	}
	
	@Test(priority=31)
	public void Validate_adding_the_product_to_Cart_from_Product_Display_Page() throws InterruptedException{
		driver.findElement(By.id("option-label-size-143-item-166")).click();
		driver.findElement(By.id("option-label-color-93-item-50")).click();
		driver.findElement(By.xpath("(//button[@class='action tocart primary'])[1]")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=32)
	public void Validate_adding_the_product_to_Cart_and_Edit_Quantity_of_Product() throws InterruptedException{
		driver.findElement(By.xpath("(//span[@class='product-image-wrapper'])[2]")).click();
		WebElement downword = driver.findElement(By.xpath("(//img[@class='product-image-photo'])[4]"));
		Actions act = new Actions(driver);
		act.moveToElement(downword).perform();
		driver.findElement(By.id("option-label-size-143-item-166")).click();
		driver.findElement(By.id("option-label-color-93-item-57")).click();
		driver.findElement(By.id("qty")).clear();
		driver.findElement(By.id("qty")).sendKeys("5");
		driver.findElement(By.id("product-addtocart-button")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=33)
	public void Validate_adding_the_product_to_Cart_from_Wish_List_Page() throws InterruptedException{
		driver.findElement(By.id("option-label-size-143-item-166")).click();
		driver.findElement(By.id("option-label-color-93-item-50")).click();
		driver.findElement(By.xpath("(//a[@class='action towishlist'])[1]")).click();
		Thread.sleep(3000);
	}
	
	
	@Test(priority=34)
	public void Validate_adding_the_product_for_comparision_from_Product_Display_Page() throws InterruptedException{
		driver.findElement(By.id("option-label-size-143-item-166")).click();
		driver.findElement(By.id("option-label-color-93-item-50")).click();
		driver.findElement(By.xpath("(//a[@title='Add to Compare'])[1]")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=35)
	public void Validate_navigating_to_Shopping_Cart_page_the_Shopping_Cart_header_option() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='action showcart']")).click();
		Thread.sleep(3000);	
	}
	
	@Test(priority=36)
	public void Validate_navigating_to_My_Account_page() throws InterruptedException {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("sandy123@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Sandii12345");
		driver.findElement(By.id("send2")).click();
		driver.findElement(By.xpath("(//span[@class='customer-name'])[1]")).click();
		driver.findElement(By.xpath("//div[@aria-hidden='false']//a[normalize-space()='My Account']")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=37)
	public void Validate_navigating_to_Edit_Address_page_from_My_Account_page() throws InterruptedException {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("sandy123@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Sandii12345");
		driver.findElement(By.id("send2")).click();
		driver.findElement(By.xpath("(//span[@class='customer-name'])[1]")).click();
		driver.findElement(By.xpath("//div[@aria-hidden='false']//a[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[@data-ui-id='default-billing-edit-link']//span[contains(text(),'Edit Address')]")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=38)
	public void Validate_Edit_Address_from_My_Account_page() throws InterruptedException {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("sandy123@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Sandii12345");
		driver.findElement(By.id("send2")).click();
		driver.findElement(By.xpath("(//span[@class='customer-name'])[1]")).click();
		driver.findElement(By.xpath("//div[@aria-hidden='false']//a[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[@data-ui-id='default-billing-edit-link']//span[contains(text(),'Edit Address')]")).click();
		driver.findElement(By.id("telephone")).sendKeys("9876543210");
		driver.findElement(By.id("street_1")).sendKeys("Suart Gujarat");
		driver.findElement(By.id("city")).sendKeys("surat");
		
		Select sel = new Select(driver.findElement(By.id("country")));
		sel.selectByValue("IN");
		
		Select select = new Select(driver.findElement(By.id("region_id")));
		select.selectByValue("544");
		driver.findElement(By.id("zip")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@title='Save Address']")).click();
		Thread.sleep(3000);
	}	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}

}
