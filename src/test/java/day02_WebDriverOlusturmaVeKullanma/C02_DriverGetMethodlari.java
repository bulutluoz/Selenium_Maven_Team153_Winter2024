package day02_WebDriverOlusturmaVeKullanma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverGetMethodlari {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.testotomasyonu.com");

        System.out.println(driver.getTitle());
        // Test Otomasyonu - Test Otomasyonu


        System.out.println(driver.getCurrentUrl());
        //  https://www.testotomasyonu.com/

        System.out.println("=======Sayfa kaynak kodlari=======");
        System.out.println(driver.getPageSource());


        //
        System.out.println(driver.getWindowHandle());
        // 94DCB5B8A0EEBAF5D4FB9274A023E2A7
        // WebDriver olusturulan herbir window'u takip edebilmek icin
        // ona ozel bir Window handle Degeri atamasi yapar
        // WHD anlamsizdir, unique'dir ve her calistiginda farkli bir deger verir


        System.out.println(driver.getWindowHandles());
        // test sirasinda birden fazla window acilirsa
        // acilan tum window'larin window handle degerlerini bir set olarak getirir
        // [94DCB5B8A0EEBAF5D4FB9274A023E2A7]


        Thread.sleep(3000);
        driver.quit();
    }
}
