package testeHome;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class index {
	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Heito\\Downloads\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void realizarPesquisa() {
		driver.get("http://localhost:333/");
		driver.findElement(By.id("loginlogin")).click();
		// driver.findElement(By.id("Busca1_txtFiltro")).sendKeys(Keys.ENTER);
		// driver.findElement(By.id("Busca1_btnBusca")).click();
	}

	public void fecharNavegador(WebDriver driver) {
		driver.quit();
	}

	@After
	public void fechar() throws Exception {
		driver.quit();
	}

	public void navegarParaNovaAba() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.findElement(By.id("lnkCaseBtn")).click();
		driver.switchTo().window(tabs.get(2));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
