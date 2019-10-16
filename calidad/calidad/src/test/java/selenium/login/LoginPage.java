package selenium.login;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	private WebDriver driver;

	private By usernameLocator;
	private By passwordLocator;
	private By loginButtonLocator;
	private By mensajeErrorLocator;
	private By mensajeExitoLocator;

	private WebDriverWait wait;

	/**
	 * Constructor.
	 * 
	 * @param driver
	 */

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		usernameLocator = By.id("txt_user");
		passwordLocator = By.name("txt_pass");
		loginButtonLocator = By.className("boton");
		mensajeErrorLocator = By.className("error-message");
		mensajeExitoLocator = By.name("message");

	}
	

	public void login(String username, String password) {
		WebElement usernameTxt = driver.findElement(usernameLocator);
		usernameTxt.sendKeys(username);
		
		WebElement passwordTxt = driver.findElement(passwordLocator);
		passwordTxt.sendKeys(password);
		
		WebElement loginButton = driver.findElement(loginButtonLocator);
		loginButton.click();
	}

	public String getMensajeError() {
		WebElement mensajeError = driver.findElement(mensajeErrorLocator);
		return mensajeError.getText();
	}
	

	public String getMensajeExito() {
		WebElement mensajeExito = driver.findElement(mensajeExitoLocator);
		return mensajeExito.getText();
	}


}
