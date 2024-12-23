package day03_webelement_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ByClassName {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // arama kutusuna phone yazip aratin
        WebElement aramaKutusu = driver.findElement(By.className("search-input"));

        aramaKutusu.sendKeys("phone" + Keys.ENTER );
        // submit isleminin bir alternatifi de arama kutusuna Keys.ENTER yollamaktir
        Thread.sleep(3000);

        // arama sonucunda bulunan urun sayisini yazdirin
        WebElement aramaSonucYaziElementi = driver.findElement(By.className("product-count-text"));

        System.out.println(aramaSonucYaziElementi);
        // [[ChromeDriver: chrome on mac (d8396ba1ca7e810f0ef1aa966842926f)] -> class name: product-count-text]
        // WebElement direkt yazdirilamaz,
        // WebElement'i yazi olarak yazdirabilmemiz icin getText() kullanmaliyiz

        System.out.println(aramaSonucYaziElementi.getText()); // 4 Products Found

        // arama sonucunda urun bulunabildigini test edin

        String aramaSonucYazisi = aramaSonucYaziElementi.getText(); // "4 Products Found"

        aramaSonucYazisi = aramaSonucYazisi.replaceAll("\\D",""); // "4"

        int aramaSonucSayisi = Integer.parseInt(aramaSonucYazisi);  // 4

        if (aramaSonucSayisi > 0 ){
            System.out.println("Arama testi PASSED");
        } else System.out.println("Arama testi FAILED");

        Thread.sleep(3000);
        // sayfayi kapatin
        driver.quit();


    }
}
