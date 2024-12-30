package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pom.*;
import util.Config;

public class Tc_Cambiar_Pass {
    private WebDriver driver;
    private Config config;
    private Pom_Cookies cookies;
    private Pom_Condiciones condiciones;
    private Pom_Bienvenido bienvenido;
    private Pom_CrearCuenta crearCuenta;
    private Pom_IniciarSesion iniciarSesion;
    private Pom_PosicionGlobal posicionGlobal;
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
        config.visit("https://www.slot.com/es/games");
    }
    @Test
    public void test() throws InterruptedException {

        cookies.acceptCookies();
        condiciones.acceptTerminos();
        bienvenido.byEmail();
        crearCuenta.iniciarSesion();
        iniciarSesion.login("PruebaQa1");
        posicionGlobal.assertScreen();
        barraSuperior.abrirMenu();
        menuHamburguesa.clickPerfil();
        perfil.pulsarEngranaje();
        editarPerfil.clickCambiarPass();
        cambiarPass.cambiarPass("PruebaQa1","PruebaQa2");
        editarPerfil.clickAspa();
        barraSuperior.abrirMenu();
        menuHamburguesa.clickConfiguracion();
        configuracion.cerrarSesion();
        //2.Loguin con pass nueva
        bienvenido.byEmail();
        iniciarSesion.login("PruebaQa2");
        posicionGlobal.assertScreen();
        //3.Se Cambia pass antigua
        barraSuperior.abrirMenu();
        menuHamburguesa.clickPerfil();
        perfil.pulsarEngranaje();
        editarPerfil.clickCambiarPass();
        cambiarPass.cambiarPass("PruebaQa2","PruebaQa1");
    }

    @After
    public void finalizar(){
        driver.quit();
    }
}
