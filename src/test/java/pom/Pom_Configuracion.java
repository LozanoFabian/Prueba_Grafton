package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Base;

public class Pom_Configuracion extends Base {
    //Localizadores
    private By btnCerrarSesion=By.xpath("//button[descendant::span[contains(text(),'CERRAR SESIÓN')]]");
    public Pom_Configuracion(WebDriver driver) {
        super(driver);
    }

    private void assertScreen(){
        try {
            // Encuentra el elemento usando el XPath proporcionado
            WebElement element = findElement(btnCerrarSesion);
            System.out.println("La pantalla de Configuración se ha encontrado");
        } catch (NoSuchElementException e) {
            // Si no se encuentra el elemento, imprime un mensaje
            System.out.println("No se encuentra la pantalla Configuración");
            Assert.fail();
        }
    }
    private void btnCerrarSesion(){
        click(btnCerrarSesion);
    }

    public void cerrarSesion(){
        assertScreen();
        btnCerrarSesion();
    }
}
