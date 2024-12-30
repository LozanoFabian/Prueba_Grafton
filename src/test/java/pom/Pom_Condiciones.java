package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.Base;

public class Pom_Condiciones extends Base {

    private By aceptar= By.xpath("//span[contains(text(), 'ACEPTAR')]");
    private By screenText=By.xpath("//span[contains(text(), 'aceptar nuestros términos y condiciones')]");

    public Pom_Condiciones(WebDriver driver) {
        super(driver);
    }

    private void assertScreen(){
        String text=getText(screenText);
        System.out.println(text);
        Assert.assertTrue("No es la pantalla de Términos y condiciones",text.contains("aceptar nuestros términos y condiciones"));
    }

    private void accept(){
        click(aceptar);
    }

    public void acceptTerminos(){
        assertScreen();
        accept();
    }

}
