package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Base;

public class Pom_PopUp_Reactivar extends Base {
    //Localizadores
    private By screenText=By.xpath("//div[contains(text(),'volverla a activar')]");
    private By btnAceptar=By.xpath("//span[contains(text(),'ACEPTAR')]");
    public Pom_PopUp_Reactivar(WebDriver driver) {
        super(driver);
    }
    private void assertScreen(){
        try {
            WebElement element = findElement(screenText);
            System.out.println("Pop up de reactivación se encuentra");
        } catch (NoSuchElementException e) {
            // Si no se encuentra el elemento, imprime un mensaje
            System.out.println("No se encuentra Pop up de reactivación");
            Assert.fail();
        }
    }
    private void btnAceptar(){
        click(btnAceptar);
    }

    public void aceptarPopUp(){
        assertScreen();
        btnAceptar();
    }
}
