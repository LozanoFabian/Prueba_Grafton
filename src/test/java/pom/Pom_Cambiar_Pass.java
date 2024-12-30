package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Base;

public class Pom_Cambiar_Pass extends Base {
    //Localizadores
    private By assertText= By.xpath("//h2[contains(text(),'Cambiar contraseña')]");
    private By inputPassOld= By.xpath("//input[@id='current']");
    private By inputPassNew= By.xpath("//input[@id='new']");
    private By save= By.xpath("(//span[contains(text(),'Guardar cambios')])[2]");
    public Pom_Cambiar_Pass(WebDriver driver) {
        super(driver);
    }

    private void assertScreen(){
        try {
            // Encuentra el elemento usando el XPath proporcionado
            WebElement element = findElement(assertText);
            System.out.println("Pantalla Cambiar pass se ha encontrado");
        } catch (NoSuchElementException e) {
            // Si no se encuentra el elemento, imprime un mensaje
            System.out.println("No se encuentra pantalla cambiar pass");
            Assert.fail();
        }
    }
    private void inputPassOld(String passOld){
        inputText(inputPassOld,passOld);
    }

    private void inputPassNew(String passNew){
        inputText(inputPassNew,passNew);
    }
    private void save(){
        click(save);
    }

    public void cambiarPass(String passOld, String passNew ){
        assertScreen();
        inputPassOld(passOld);
        inputPassNew(passNew);
        save();
    }
}
