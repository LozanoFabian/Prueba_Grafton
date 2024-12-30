package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Base;

public class Pom_Perfil extends Base {
    //Localizadores
    private By avatar= By.xpath("//slotcom-avatar");
    private By engranaje=By.xpath("//button[descendant::mat-icon]");
    public Pom_Perfil(WebDriver driver) {
        super(driver);
    }

    private void assertScreen(){
        try {
            // Encuentra el elemento usando el XPath proporcionado
            WebElement element = findElement(avatar);
            System.out.println("La pantalla de Perfil se ha encontrado");
        } catch (NoSuchElementException e) {
            // Si no se encuentra el elemento, imprime un mensaje
            System.out.println("No se encuentra la pantalla de Perfil");
            Assert.fail();
        }
    }

    private void engranaje(){
        click(engranaje);
    }

    public void pulsarEngranaje(){
        assertScreen();
        engranaje();
    }


}
