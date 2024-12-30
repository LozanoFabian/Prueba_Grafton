package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.Base;

public class Pom_CrearCuenta extends Base {

    //Localizadores
    private By screenText=By.xpath("//div[contains(text(), 'CREA TU CUENTA')]");
    private By btnInciarSesion=By.xpath("//span[contains(text(), 'Inicia sesión')]");

    public Pom_CrearCuenta(WebDriver driver) {
        super(driver);
    }
    private void assertScreen(){
        String text=getText(screenText);
        System.out.println(text);
        Assert.assertTrue("No es la pantalla de Crear cuenta",text.contains("CREA TU CUENTA"));
    }

    private void clickIniciarSesion(){
        click(btnInciarSesion);
    }

    public void iniciarSesion(){
        assertScreen();
        clickIniciarSesion();
    }




}
