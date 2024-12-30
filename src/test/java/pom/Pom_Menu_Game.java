package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import util.Base;


public class Pom_Menu_Game extends Base {
    public Pom_Menu_Game(WebDriver driver) {
        super(driver);
    }

    public void play() throws InterruptedException {
        Thread.sleep(5000);
        WebElement canvas= findElement(By.xpath("//iframe[@id='game-iframe']"));
        int width=canvas.getSize().width;
        int height=canvas.getSize().height;
        Actions action =new Actions(chromeDriverConnection());
        action.moveToElement(canvas,50,50).click().perform();
    }
}
