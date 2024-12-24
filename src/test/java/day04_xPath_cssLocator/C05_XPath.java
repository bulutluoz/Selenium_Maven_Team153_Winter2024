package day04_xPath_cssLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_XPath {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2. Signin buttonuna tiklayin

        driver.findElement(By.id("signin_button"))
                .click();

        //3. Login alanina  “username” yazdirin
        driver.findElement(By.id("user_login"))
                .sendKeys("username");

        //4. Password alanina “password” yazdirin
        driver.findElement(By.id("user_password"))
                .sendKeys("password");

        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@*='Sign in']"))
                .click();

        //6. Back tusu ile sayfaya donun
        driver.navigate().back();

        //7. Online Banking menusunden
        driver.findElement(By.xpath("//strong[.='Online Banking']"))
                .click();

        // Pay Bills sayfasina gidin
        driver.findElement(By.id("pay_bills_link"))
                .click();

        //8. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.id("sp_amount"))
                .sendKeys("200");

        //9. tarih kismina “2023-09-10” yazdirin
        driver.findElement(By.id("sp_date"))
                .sendKeys("2023-09-10");

        //10. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees"))
                .click();

        //11. “The payment was successfully submitted.” mesajinin ciktigini test edin

        String expectedMesaj = "The payment was successfully submitted.";
        String actualMesaj = driver.findElement(By.id("alert_content")).getText();


        if (expectedMesaj.equalsIgnoreCase(actualMesaj)){
            System.out.println("Odeme testi PASSED");
        } else System.out.println("Odeme testi FAILED");

        Thread.sleep(2000);
        driver.quit();
    }
}
