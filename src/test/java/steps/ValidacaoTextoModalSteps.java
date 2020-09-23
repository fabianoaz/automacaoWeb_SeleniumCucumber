package steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

public class ValidacaoTextoModalSteps extends Driver {

	private HomePage homePage;
	private WebDriver myDriver = GetDriver();
	private WebElement myframe = null;

	@Given("acesse a pagina site.getnet.com.br")
	public void acesse_a_pagina_site_getnet_com_br() {
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		homePage = new HomePage(myDriver);
		homePage.carregaPaginaIncial();
	}

	@And("clico na lupa para iniciar pesquisa")
	public void clico_na_lupa_para_iniciar_pesquisa() {
		try {
			homePage.Clica(By.xpath("//div[@id='search-trigger']//span"));
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

	@And("no campo de pesquisa informo SuperGet")
	public void no_campo_de_pesquisa_informo_super_get() {
		try {
			homePage.Clica(By.id("global-search-input"));
			homePage.Escreve(By.id("global-search-input"), "SuperGet");
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

	@And("clico em Pesquisar")
	public void clico_em_pesquisar() {
		try {
			homePage.Clica(By.xpath("//button[contains(text(),'Procurar')]"));
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

	@When("clico na linha com valor - Como acesso a minha conta SuperGet?")
	public void clico_na_linha_com_valor_como_acesso_a_minha_conta_super_get() {
		try {
			homePage.Clica(By.xpath("//h3[contains(text(),'Como acesso a minha conta SuperGet?')]"));
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

	@Then("valido se modal foi aberto")
	public void valido_se_modal_foi_aberto() {
		try {
			myframe = homePage.RetornaElemento(By.className("is-modal-open"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@And("verifico se nele ha o texto - Como acesso a minha conta SuperGet?")
	public void verifico_se_nele_ha_o_texto_como_acesso_a_minha_conta_super_get() {
		assertTrue("Valida texto do Modal", myframe.getText().contains("Como acesso a minha conta SuperGet?"));
	}

	@Then("encerro a aplicacao")
	public void encerro_a_aplicacao() {
		myDriver.quit();
	}

}
