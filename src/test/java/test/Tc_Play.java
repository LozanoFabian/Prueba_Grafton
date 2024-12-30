package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pom.*;
import util.Config;

public class Tc_Play {
    private WebDriver driver;
    private Config config;
    private Pom_Cookies cookies;
    private Pom_Condiciones condiciones;
    private Pom_Bienvenido bienvenido;
    private Pom_CrearCuenta crearCuenta;
    private Pom_IniciarSesion iniciarSesion;
    private Pom_PosicionGlobal posicionGlobal;
    private Pom_Menu_Game menuGame;
    private Pom_BarraSuperior barraSuperior;
    private Pom_Menu menuHamburguesa;
    private Pom_Perfil perfil;
    private Pom_EditarPerfil editarPerfil;
    private Pom_Cambiar_Pass cambiarPass;
    private Pom_Configuracion configuracion;
    @Before
    public void setUp(){
        config=new Config(driver);
        driver=config.chromeDriverConnection();
        cookies=new Pom_Cookies(driver);
        condiciones=new Pom_Condiciones(driver);
        bienvenido=new Pom_Bienvenido(driver);
        crearCuenta=new Pom_CrearCuenta(driver);
        iniciarSesion=new Pom_IniciarSesion(driver);
        posicionGlobal=new Pom_PosicionGlobal(driver);
        barraSuperior=new Pom_BarraSuperior(driver);
        menuHamburguesa= new Pom_Menu(driver);
        perfil=new Pom_Perfil(driver);
        editarPerfil=new Pom_EditarPerfil(driver);
        cambiarPass=new Pom_Cambiar_Pass(driver);
        configuracion=new Pom_Configuracion(driver);
        menuGame=new Pom_Menu_Game(driver);
        config.visit("https://www.slot.com/es/games");
    }
    @Test
    public void test() throws InterruptedException {

        cookies.acceptCookies();
        condiciones.acceptTerminos();
        bienvenido.byEmail();
        crearCuenta.iniciarSesion();
        iniciarSesion.login("PruebaQa1");
        posicionGlobal.openGame();
        menuGame.play();

    }

    @After
    public void finalizar(){

    }
}
