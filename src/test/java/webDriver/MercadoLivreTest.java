package webDriver;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MercadoLivreTest {

    private static WebDriver driver;


    @BeforeAll
    public static void openBrowser() {
        System.setProperty("webdriver.gecko.driver", "/Users/bridgetocross/Documents/Test/seleniumWebDriver_01/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void searchProductMercadoLivre(){
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.navigate().to("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Mercado Livre", Keys.ENTER);

        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div[10]/div[1]/div[2]/div/div[2]/div[2]/div/div/div/div[1]/div/div/div/div/div[1]/a/h3")).click();

        // search Camisetas at Mercado Livre
        driver.findElement(By.xpath("/html/body/header/div/form/input")).sendKeys("Camisetas", Keys.ENTER);

        // select the first product of the page
        driver.findElement(By.xpath("/html/body/main/div[2]/div/section/ol/li[1]/div/a")).click();

    }

    @AfterAll
    public static void quitBrowser(){

        driver.quit();
    }

}
