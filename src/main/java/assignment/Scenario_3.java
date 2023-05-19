package assignment;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class Scenario_3 {
	
	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page =browser.newPage();
		page.navigate("https://www.lambdatest.com/selenium-playground");
		page.locator("a:has-text('Input Form Submit')").click();
		String Url =page.url();
		System.out.println(Url);
		page.locator("input[id='name']").fill("Ammarah");
		page.locator("input[id='inputEmail4']").fill("ammarahayubi95@gmail.com");
		page.locator("input[id='inputPassword4']").fill("Ammarah@8887");
		page.locator("input[id='company']").fill("Nimapinfotech");
		page.locator("input[id='websitename']").fill("https://nimapinfotech.com/");
		page.getByRole(AriaRole.COMBOBOX).selectOption("IN");
	    page.getByRole(AriaRole.COMBOBOX).click();
	    page.locator("input[id='inputCity']").fill("Mumbai");
		page.locator("input:below(:has-text('Address'))").first().fill("Unity park");
		page.locator("input:below(:has-text('Address')) >> nth=1").fill("MG Road");
		page.locator("input[id='inputState']").fill("Maharashtra");
		page.locator("input[id='inputZip']").fill("400011");
		
		page.locator("//button[text()='Submit']").click();
		String successMessage= page.locator("//p[text()='Thanks for contacting us, we will get back to you shortly.']").textContent();
		 if(successMessage.contains("Thanks for contacting us, we will get back to you shortly.")) {
			 System.out.println("Form successfully completed");
		 }
		 else {
			 System.out.println("Something went wrong");
		 }
		

	}

	
}
