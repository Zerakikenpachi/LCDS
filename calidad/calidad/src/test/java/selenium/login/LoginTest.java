package selenium.login;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LoginTest{
	
	private String LOGIN_USER = "David";
	private String PASSWORD = "David123";
	private String URL = "http://localhost:8080/SeleniumProyecto/";
	private String MENSAJE_ERROR = "Credenciales invalidas";
	private String MENSAJE_EXITO = "Login Exitoso";
	protected WebDriver driver;
	
	private LoginPage loginPage;
	
	@Test
	public void loginCredencialesInvalidas() {
		loginPage = new LoginPage(driver);
		loginPage.login(LOGIN_USER, PASSWORD);
		
		Assert.assertEquals(MENSAJE_ERROR, loginPage.getMensajeError());
		
	}
	
	@Test
	public void loginExitoso() {
		loginPage = new LoginPage(driver);
		loginPage.login(LOGIN_USER, PASSWORD);
		
		Assert.assertEquals(MENSAJE_EXITO, loginPage.getMensajeError());
		
	}
	
	@Before
	public void arrange() {
		System.setProperty("webdriver.chrome.driver", "chromedriverWIN.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
		driver.get(URL);
	}
	
	@After
    public void tearDown(){
        driver.close();
        driver.quit();
    }
	
	

}
