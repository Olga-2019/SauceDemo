import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SauceDemo extends BaseTest {

    @Test
    public void login() {
        String itemPrice = "$29.99";
        String itemName = "Sauce Labs Backpack";
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        WebElement blackpack = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        assertTrue(blackpack.isDisplayed());
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item']//button")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        WebElement cart = driver.findElement(By.xpath("//span[text()='Your Cart']"));
        assertTrue(cart.isDisplayed());
        String itemNameInCart = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
        String itemPriceInCart = driver.findElement(By.xpath("//div[text()='29.99']")).getText();
        Assert.assertEquals(itemNameInCart, itemName);
        Assert.assertEquals(itemPriceInCart, itemPrice);
    }
}
