import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SwagLabs {
    public static void main(String[] args) {
        //Instanciar el navegador
        WebDriver driver = new FirefoxDriver();

        //abrir el navegador
        driver.get("https://www.saucedemo.com/v1/");

        //Maximizar la ventana
        driver.manage().window().maximize();

        //Localizadores
        WebElement txtUsername = driver.findElement(By.id("user-name"));
        txtUsername.sendKeys("standard_user");

        WebElement txtPassword = driver.findElement(By.id("password"));
        txtPassword.sendKeys("secret_sauce");

        WebElement btnLogin = driver.findElement(By.id("login-button"));
        btnLogin.click();

        //Agregar al carrito
        //Localizadores elementos de añadir carrito
        List<WebElement> btnAddToCart = driver.findElements(By.xpath("//button[@class='btn_primary btn_inventory']"));

        //Agregar un producto al carrito
        WebElement btnAddToCart1 = btnAddToCart.getFirst();
        btnAddToCart1.click();

        //Ir al carrito
        WebElement btnCart = driver.findElement(By.xpath("//a[@class='shopping_cart_link fa-layers fa-fw']"));
        btnCart.click();

        WebElement btnCheckout = driver.findElement(By.xpath("//a[@class='btn_action checkout_button']"));
        btnCheckout.click();

        WebElement txtFirstName = driver.findElement(By.id("first-name"));
        txtFirstName.sendKeys("Daniela");

        WebElement txtLastName = driver.findElement(By.id("last-name"));
        txtLastName.sendKeys("León");

        WebElement txtPostalCode = driver.findElement(By.id("postal-code"));
        txtPostalCode.sendKeys("540001");

        WebElement btnContinue = driver.findElement(By.xpath("//input[@class='btn_primary cart_button']"));
        btnContinue.click();

        WebElement btnFinish = driver.findElement(By.xpath("//a[@class='btn_action cart_button']"));
        btnFinish.click();

        //Comparar texto esperado
        String textValidate = "THANK YOU FOR YOUR ORDER";
        assertTrue(textValidate.contains("THANK YOU FOR YOUR ORDER"));

        //Cerrar el navegador
        driver.quit();
    }
}
