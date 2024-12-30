package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import util.Base;

public class Pom_BarraSuperior extends Base {

    private By btnComprar= By.xpath("//span[contains(text(),'COMPRAR')]");
    private By iconoHamburguesa=By.xpath("//div[@class='side-menu__icon']");

    public Pom_BarraSuperior(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    private void assertScreen(){
        try {
            // Encuentra el elemento usando el XPath proporcionado
            WebElement element = findElement(btnComprar);
            System.out.println("La Barra Superior ha sido encontrada");
        } catch (NoSuchElementException e) {
            // Si no se encuentra el elemento, imprime un mensaje
            System.out.println("No se encuentra la Barra Superior");
            Assert.fail();
        }
    }

    private void pulsarHamburguesa(){
        click(iconoHamburguesa);
    }

    public void abrirMenu(){
        assertScreen();
        pulsarHamburguesa();
    }
}
