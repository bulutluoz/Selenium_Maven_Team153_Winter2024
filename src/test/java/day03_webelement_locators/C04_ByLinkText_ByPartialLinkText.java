package day03_webelement_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_ByLinkText_ByPartialLinkText {

    public static void main(String[] args) throws InterruptedException {

        //1- Bir test class’i olusturun ilgili ayarlari yapin
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");
        Thread.sleep(2000);

        //3- Sayfada 147 adet link bulundugunu test edin.
        List<WebElement> linkElementleriList = driver.findElements(By.tagName("a"));

        int expectedLinkSayisi = 147;
        int actualLinkSayisi = linkElementleriList.size();

        if (expectedLinkSayisi == actualLinkSayisi){
            System.out.println("Link sayisi testi PASSED");
        }else System.out.println("Link sayisi testi FAILED");

        //4- Products linkine tiklayin
        // driver.findElement(By.linkText(" Products")).click();
        // bosluk iceren linkText'lerde sorun olabilir,
        // bu durumda partialLinkText() denemekte fayda var

        //driver.findElement(By.partialLinkText("Products")).click();
        //driver.findElement(By.partialLinkText("roducts")).click();
        driver.findElement(By.partialLinkText("ducts")).click();

        //5- special offer yazisinin gorundugunu test edin
        WebElement specialOfferElementi = driver.findElement(By.id("sale_image"));

        if (specialOfferElementi.isDisplayed()){
            System.out.println("Special offer testi PASSED");
        } else System.out.println("Special offer testi FAILED");


        //6- Sayfayi kapatin
        Thread.sleep(2000);
        driver.quit();


    }
}
