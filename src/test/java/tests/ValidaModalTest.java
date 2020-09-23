package tests;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.Driver;
import pages.HomePage;

public class ValidaModalTest extends Driver {

	private HomePage homePage;
	private WebDriver myDriver = GetDriver();
	private WebElement myframe = null;

	@Before
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		homePage = new HomePage(myDriver);
		homePage.carregaPaginaIncial();
	}

	@After
	public void TearDown() {
		myDriver.quit();
	}

	@Test
	public void pesquisaSuperGet() throws InterruptedException {
		homePage.Clica(By.xpath("//div[@id='search-trigger']//span"));
		homePage.Clica(By.id("global-search-input"));
		homePage.Escreve(By.id("global-search-input"), "SuperGet");
		homePage.Clica(By.xpath("//button[contains(text(),'Procurar')]"));
		homePage.Clica(By.xpath("//h3[contains(text(),'Como acesso a minha conta SuperGet?')]"));

		try {
			myframe = homePage.RetornaElemento(By.className("is-modal-open"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		assertTrue("Valida texto do Modal", myframe.getText().contains("Como acesso a minha conta SuperGet?"));
	}

}
