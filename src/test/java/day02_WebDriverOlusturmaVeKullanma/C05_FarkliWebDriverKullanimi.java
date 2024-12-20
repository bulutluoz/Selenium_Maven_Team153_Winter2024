package day02_WebDriverOlusturmaVeKullanma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_FarkliWebDriverKullanimi {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.testotomasyonu.com");


        Thread.sleep(2000);
        driver.quit();
    }
}
