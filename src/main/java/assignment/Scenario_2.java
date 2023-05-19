package assignment;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class Scenario_2 {

	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page =browser.newPage();
		page.navigate("https://www.lambdatest.com/selenium-playground");
		page.locator("a:has-text('Drag & Drop Sliders')").click();
		page.locator("#slider3").getByRole(AriaRole.SLIDER).fill("95");
		String validateValue=page.locator("//output[text()='95']").textContent();
		if (validateValue.equals("95")) {
			System.out.println("Test passed");
		}else {
			System.out.println("Test Failed");
		}
	}

}
