package Ketan.Playwright;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

class JunitRunner {
	static Playwright playwright = Playwright.create(); 
	
	static Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	
	static Page page = browser.newPage();
	
	@BeforeAll
	public static void setUpBeforeClass() {
		page.navigate("http://www.google.com");
		System.out.println(page.url());
		System.out.println(page.title());
		System.out.println(page.content());
	}
	
	@AfterAll
	public static void setUpAfterClass() {
		page.close();
		playwright.close();
	}
	
	@Test
	void test() {
		page.goBack();
		page.goForward();
		page.reload();
	}

}
