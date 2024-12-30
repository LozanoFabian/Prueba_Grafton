package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Base;

public class Pom_Menu extends Base {
    //Localizadores
    private By btnPerfil= By.xpath("//button[descendant::span[@class='icons-sprite big profile']]");
    private By btnConfiguracion=By.xpath("//button[descendant::span[@class='icons-sprite big settings']]");
    public Pom_Menu(WebDriver driver) {
        super(driver);
    }

    private void assertScreen(){
        try {
            // Encuentra el elemento usando el XPath proporcionado
            WebElement element = findElement(btnPerfil);
            System.out.println("El menú se ha encontrado");
        } catch (NoSuchElementException e) {
            // Si no se encuentra el elemento, imprime un mensaje
            System.out.println("No se encuentra el menú");
            Assert.fail();
        }
    }

    private void perfil(){
        click(btnPerfil);
    }
    private void configuracion(){
        click(btnConfiguracion);
    }

    public void clickPerfil(){
        assertScreen();
        perfil();
    }

    public void clickConfiguracion(){
        assertScreen();
        configuracion();
    }
}
