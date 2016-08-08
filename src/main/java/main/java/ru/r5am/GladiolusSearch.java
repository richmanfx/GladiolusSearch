/**
 * Created by zoer on 31.07.2016.
 */

package main.java.ru.r5am;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
//import static com.codeborne.selenide.Selenide.*;


public class GladiolusSearch {
    public static void main(String[] args) {
        // Драйвер Firefox
        WebDriver driver = new FirefoxDriver();
//        WebDriver driver = new ChromeDriver();

        // Максимизировать размер окна браузера
        driver.manage().window().maximize();

        driver.get("http://www.google.com");

        WebElement element = driver.findElement(By.name("q"));

        element.sendKeys("Cheese!");
        element.submit();
        System.out.println("Page title is: " + driver.getTitle());

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        System.out.println("Page title is: " + driver.getTitle());
        driver.quit();
    }
}
