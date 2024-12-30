package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Base;

public class Pom_PopUp_ConfirmarBaja_Dos extends Base {
    //Localizadores
    private By inputUser= By.xpath("//input[@formcontrolname='userNickname']");
    private By user=By.xpath("//span[contains(@class,'user-name-deletion')]");
    private By btnAceptar=By.xpath("//span[contains(text(),'ACEPTAR')]");
    public Pom_PopUp_ConfirmarBaja_Dos(WebDriver driver) {
        super(driver);
    }

    private void assertScreen(){
        try {
            // Encuentra el elemento usando el XPath proporcionado
            WebElement element = findElement(inputUser);
            System.out.println("Pop up segunda pantalla de confirmacion se encuentra");
        } catch (NoSuchElementException e) {
            // Si no se encuentra el elemento, imprime un mensaje
            System.out.println("No se encuentra segunda pantalla de confirmacion");
            Assert.fail();
        }
    }

    private String user(){
        return getText(user);
    }

    private void inputUser(){
        inputText(inputUser,user());
    }
    private void btnAceptar(){
        click(btnAceptar);
    }

    public void aceptarPopUp(){
        assertScreen();
        inputUser();
        btnAceptar();
    }
}
