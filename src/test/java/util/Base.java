package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Base {

    private WebDriver driver;
    private WebDriverWait driverWait;

    public Base(WebDriver driver) {
        this.driver = driver;
        driverWait=new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    public WebDriver chromeDriverConnection(){
        WebDriverManager.chromedriver().clearDriverCache().setup();

        // Configura ChromeOptions para permitir notificaciones
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking"); // Desactiva el bloqueo de pop-ups
        options.addArguments("--enable-notifications");   // Habilita las notificaciones

        // Configura preferencias para permitir notificaciones automáticamente
        options.addArguments("start-maximized"); // Inicia con el navegador maximizado
        options.setExperimentalOption("prefs", new java.util.HashMap<String, Object>() {{
            put("profile.default_content_setting_values.notifications", 1); // para permitir notificaciones
        }});

        driver=new ChromeDriver(options);
        return driver;
    }

    public WebElement findElement (By locator){
        return driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
         //driver.findElement(locator);
    }
    public List<WebElement> findElements (By locator){
        return driver.findElements(locator);
    }

    /**
     * Introduce texto
     * @param locator
     * @param text
     */
    public void inputText(By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    /**
     * Hace la funcionalidad de Click
     * @param locator
     */
    public void click(By locator){
        driver.findElement(locator).click();
    }

    /**
     * Coge texto del objeto encontrado
     * @param locator
     * @return
     */
    public String getText(By locator){
        //return driver.findElement(locator).getText();
        return driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    /**
     * Abre la pagina web
     * @param url
     */
    public void visit(String url){
        driver.get(url);
    }
    /**
     * Maximiza el navegador
     */
    public void maximizar(){
        driver.manage().window().maximize();
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }


}
