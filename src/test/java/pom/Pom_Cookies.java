package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.Base;

public class Pom_Cookies extends Base {
    private By accept= By.xpath("//button[contains(text(), 'I ACCEPT')]");
    public Pom_Cookies(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies(){
        click(accept);
    }


}
