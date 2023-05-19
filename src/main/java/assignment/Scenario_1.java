package assignment;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Scenario_1 {

	public static void main(String[] args) {
		String inputValue="Welcome to LambdaTest";
		Playwright playwright=Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page =browser.newPage();
		page.navigate("https://www.lambdatest.com/selenium-playground");
		page.locator("a:has-text('Simple Form Demo')").click();
		String actualURL=page.url();
		System.out.println(actualURL);
		if (actualURL.contains("simple-form-demo")) {
			System.out.println("Test passed");
			page.locator("input:below(:text('Enter Message'))").first().fill(inputValue);
			page.locator("button[id='showInput']").click();
			String validateValue=page.locator("p[id='message']").textContent();
			if (inputValue.equals(validateValue)) {
				System.out.println("Vaidated the input");
			}else {
				System.out.println("mismatched Value");
			}
		
		}else {
			System.out.println("Test failed");
		}
		

	}

}
