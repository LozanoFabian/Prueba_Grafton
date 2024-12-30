package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pom.*;
import util.Config;

public class Tc_Borrar_Recuperar_Usuario {

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
    private Pom_PopUP_ConfirmarBaja confirmarBaja;
    private Pom_PopUp_ConfirmarBaja_Dos confirmarBajaDos;
    private Pom_PopUp_ConfirmarBaja_Final confirmarFinal;
    private Pom_PopUp_Reactivar popUpReactivar;
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
        confirmarBaja=new Pom_PopUP_ConfirmarBaja(driver);
        confirmarBajaDos=new Pom_PopUp_ConfirmarBaja_Dos(driver);
        confirmarFinal=new Pom_PopUp_ConfirmarBaja_Final(driver);
        popUpReactivar=new Pom_PopUp_Reactivar(driver);
        configuracion=new Pom_Configuracion(driver);
        config.visit("https://www.slot.com/es/games");
    }
    @Test
    public void test() throws InterruptedException {
        //1.Borramos usuario
        cookies.acceptCookies();
        condiciones.acceptTerminos();
        bienvenido.byEmail();
        crearCuenta.iniciarSesion();
        iniciarSesion.login("PruebaQa1");
        posicionGlobal.assertScreen();
        barraSuperior.abrirMenu();
        menuHamburguesa.clickPerfil();
        perfil.pulsarEngranaje();
        editarPerfil.clickBorrar();
        confirmarBaja.clickAceptar();
        confirmarBajaDos.aceptarPopUp();
        confirmarFinal.aceptarPopUp();
        //2. Se loguea dos veces
        for(int i=0;i<2;i++){
            bienvenido.byEmail();
            iniciarSesion.login("PruebaQa1");
            popUpReactivar.aceptarPopUp();
            posicionGlobal.assertScreen();
            barraSuperior.abrirMenu();
            menuHamburguesa.clickConfiguracion();
            configuracion.cerrarSesion();
        }
        //3. Se loguea una tercera vez
        bienvenido.byEmail();
        iniciarSesion.login("PruebaQa1");
        posicionGlobal.assertScreen();

    }

    @After
    public void finalizar(){
        driver.quit();
    }
}
