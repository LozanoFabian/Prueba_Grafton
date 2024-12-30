package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Base;

public class Pom_EditarPerfil extends Base {
    //Localizadores
    private By assertText= By.xpath("//h2[contains(text(),'Editar Perfil')]");
    private By btnBorrar=By.xpath("//h2[contains(text(),'Borrar cuenta')]");
    private By btnCambiarPass=By.xpath("//h2[contains(text(),'Cambiar contraseña')]");
    private By btnAspa=By.xpath("//mat-icon[@data-mat-icon-name='close']");
    public Pom_EditarPerfil(WebDriver driver) {
        super(driver);
    }
    private void assertScreen(){
        try {
            // Encuentra el elemento usando el XPath proporcionado
            WebElement element = findElement(assertText);
            System.out.println("Editar perfil se ha encontrado");
        } catch (NoSuchElementException e) {
            // Si no se encuentra el elemento, imprime un mensaje
            System.out.println("No se encuentra editar perfil ");
            Assert.fail();
        }
    }

    private void borrar(){
        click(btnBorrar);
    }
    private void cambiarPass(){
        click(btnCambiarPass);
    }
    private void aspa(){
        click(btnAspa);
    }
    public void clickBorrar(){
        assertScreen();
        borrar();
    }
    public void clickCambiarPass(){
        assertScreen();
        cambiarPass();
    }
    public void clickAspa(){
        assertScreen();
        aspa();
    }


}
