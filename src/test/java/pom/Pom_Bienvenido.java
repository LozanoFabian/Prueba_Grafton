package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.Base;

public class Pom_Bienvenido extends Base {

    //Localizadores
    private By btnEmail= By.xpath("//span[contains(text(), 'Email')]");
    private By screenText=By.xpath("//h1[contains(text(), '¡BIENVENIDO!')]");
    public Pom_Bienvenido(WebDriver driver) {
        super(driver);
    }

    private void assertScreen(){
        //assertText("aceptar nuestros términos y condiciones");
        String text=getText(screenText);
        System.out.println(text);
        Assert.assertTrue("No es la pantalla de Bienvenida",text.contains("¡BIENVENIDO!"));
    }

    private void clickEmail(){
        click(btnEmail);
    }

    public void byEmail(){
        assertScreen();
        clickEmail();
    }
}
