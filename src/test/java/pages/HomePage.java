package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void carregaPaginaIncial() {
		driver.get("https://site.getnet.com.br/");
		driver.manage().window().maximize();
	}

	public void Clica(By by) throws InterruptedException {
		Thread.sleep(1500);
		driver.findElement(by).click();
	}

	public void Escreve(By by, String texto) throws InterruptedException {
		Thread.sleep(1500);
		driver.findElement(by).sendKeys(texto);
	}

	public WebElement RetornaElemento(By by) throws Exception {
		
		WebElement element = driver.findElement(by);

		if (element.isDisplayed())
		{
			return element;
		} 
		else 
		{
			throw new Exception("Elemento não encontrado");
		}
	}
}
