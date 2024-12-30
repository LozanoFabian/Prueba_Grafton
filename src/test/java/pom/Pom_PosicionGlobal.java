package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Base;

public class Pom_PosicionGlobal extends Base {

    //Localizadores
    private By assertPg= By.xpath("//slotcom-lobby-game-page");
    private By firstGame= By.xpath("//img[@alt='El Tesoro De Java']");
    public Pom_PosicionGlobal(WebDriver driver) {
        super(driver);
    }
    public void assertScreen(){
        try {
            WebElement element = findElement(assertPg);
            System.out.println("La pantalla está en la posición global esperada.");
        } catch (NoSuchElementException e) {
            // Si no se encuentra el elemento, imprime un mensaje
            System.out.println("No es la página de la posición global esperada.");
            Assert.fail();
        }
    }

    public void openFirstGame(){
        click(firstGame);
    }

    public void openGame(){
        assertScreen();
        openFirstGame();
    }

}
