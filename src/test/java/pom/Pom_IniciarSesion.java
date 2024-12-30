package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.Base;

public class Pom_IniciarSesion extends Base {

    //Localizadores
    private By screenText=By.xpath("//div[contains(text(), '¿Has olvidado tu contraseña?')]");
    private By email=By.xpath("//input[@type='email']");
    private By pass=By.xpath("//input[@type='password']");
    private By iniciarSesion=By.xpath("//button[@type='button']");

    public Pom_IniciarSesion(WebDriver driver) {
        super(driver);
    }

    private void assertScreen(){
        String text=getText(screenText);
        System.out.println(text);
        Assert.assertTrue("No es la pantalla de Iniciar sesión",text.contains("¿Has olvidado tu contraseña?"));
    }

    private void usuario(){
        inputText(email,"fabiris30@gmail.com");
    }

    private void password(String txtPass){
        inputText(pass, txtPass);
    }
    private void btnIniciarSesion(){
        click(iniciarSesion);
    }

    public void login(String txtPass){
        assertScreen();
        usuario();
        password(txtPass);
        btnIniciarSesion();
    }

}
