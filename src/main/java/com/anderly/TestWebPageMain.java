package com.anderly;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWebPageMain {


    public static final String USUARIO_CORRECTO = "tomsmith";
    public static final String USUARIO_INCORRECTO = "SASDASDASD";
    public static final String PASSWORD_CORRECTO = "SuperSecretPassword!";
    public static final String PASSWORD_INCORRECTO = "SPassssInvalid!";
    public static final int TIEMPO_PARA_CERRAR_VENTANA_EN_SEGUNDOS = 3;
    public static final String APP_URL = "http://the-internet.herokuapp.com/login";

    public static void main(String[] args) throws InterruptedException {


        formFlowSubmit(USUARIO_CORRECTO, PASSWORD_INCORRECTO);
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        formFlowSubmit(USUARIO_INCORRECTO, PASSWORD_CORRECTO);


    }

    private static void formFlowSubmit(String usuario, String password) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(APP_URL);
        driver.findElement(By.cssSelector("input#username")).sendKeys(usuario);
        driver.findElement(By.cssSelector("input#password")).sendKeys(password);
        driver.findElement(By.tagName("button")).submit();
        Thread.sleep(TimeUnit.SECONDS.toMillis(TIEMPO_PARA_CERRAR_VENTANA_EN_SEGUNDOS));
        driver.close();
    }

}
