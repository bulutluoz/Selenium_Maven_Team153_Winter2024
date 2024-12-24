package day04_xPath_cssLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_TextIleXPathKullanimi {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //1- https://testotomasyonu.com/addremove/ adresine gidin
        driver.get("https://testotomasyonu.com/addremove/");
        Thread.sleep(2000);
        //2- Add Element butonuna basin

        driver.findElement(By.xpath("//*[.='Add']"))
                .click();

        //3- Remove butonu’nun gorunur oldugunu test edin
        WebElement removeButonu = driver.findElement(By.xpath("//button[.='Remove']"));

        if (removeButonu.isDisplayed()){
            System.out.println("Remove butonu gorunme testi PASSED");
        }else System.out.println("Remove butonu gorunme testi FAILED");
        Thread.sleep(2000);
        //4- Remove tusuna basin
        removeButonu.click();

        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin

        //WebElement addRemoveYaziElementi = driver.findElement(By.tagName("h2"));

        WebElement addRemoveYaziElementi =
                driver.findElement(By.xpath("//h2[.='Add/Remove Elements']"));


        if (addRemoveYaziElementi.isDisplayed()){
            System.out.println("Add Remove Yazisi gorunme testi PASSED");
        }else System.out.println("Add Remove Yazisi gorunme testi FAILED");

        Thread.sleep(2000);
        driver.quit();

    }
}
