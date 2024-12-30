package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Base;

public class Pom_PopUP_ConfirmarBaja extends Base {

    //Localizadores
    private By assertText= By.xpath("//div[contains(text(),'¿Quieres darte de baja?')]");
    private By btnAceptar=By.xpath("//span[contains(text(),'ACEPTAR')]");
    public Pom_PopUP_ConfirmarBaja(WebDriver driver) {
        super(driver);
    }
    private void assertScreen(){
        try {
            // Encuentra el elemento usando el XPath proporcionado
            WebElement element = findElement(assertText);
            System.out.println("Pop up confirmar ¿QUIERES DARTE DE BAJA? se ha encontrado");
        } catch (NoSuchElementException e) {
            // Si no se encuentra el elemento, imprime un mensaje
            System.out.println("No se encuentra Pop up confirmar ¿QUIERES DARTE DE BAJA?");
            Assert.fail();
        }
    }

    private void aceptar(){
        click(btnAceptar);
    }

    public void clickAceptar(){
        assertScreen();
        aceptar();
    }
}
