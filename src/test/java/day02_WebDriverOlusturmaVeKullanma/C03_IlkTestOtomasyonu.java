package day02_WebDriverOlusturmaVeKullanma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_IlkTestOtomasyonu {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        //1. testotomasyonu sayfasina gidelim. https://www.testotomasyonu.com/
        driver.get("https://www.testotomasyonu.com/");

        //2. Sayfa basligini(title) yazdirin
        System.out.println(driver.getTitle());

        //3. Sayfa basliginin “Test Otomasyonu” icerdigini test edin
        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Title testi PASSED");
        }else System.out.println("Title testi FAILED");


        //4. Sayfa adresini(url) yazdirin
        System.out.println(driver.getCurrentUrl()); //

        //5. Sayfa url’inin https://testotomasyonu.com/ oldugunu test edin.

        String expectedUrl = "https://testotomasyonu.com/";
        String actualurl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualurl)){
            System.out.println("Url testi PASSED");
        }else System.out.println("Url testi FAILED");

        /*
            expected url  olarak https://testotomasyonu.com/  verilmis
            actual url olarak    https://www.testotomasyonu.com/  degerini aldik

            bu ikisi esit olmadigindan test failed olur

            Tester requirements'a gore testini yapar
            requirements'a uygun olmayan her durum BUG olarak rapor edilir

            Bazi BUG'lar uygulamanin calismasini engeller,
            bazilari ise bu gorevde oldugu gibi onemsiz gibi gorunebilir

            ANNNCCAAAKKK bir tester olarak gorevimiz
            bu farkliligi rapor etmektir.

            biz BUG olarak raporladiktan sonra
            - ya developer'lar buradaki farkliligi duzeltir
            - ya da requirements duzeltilerek bize yeniden verilir
         */


        //6. Sayfa handle degerini yazdirin
        System.out.println(driver.getWindowHandle()); //  E7A5E71ED61AC26EE01B03BFEBE6ED44

        //7. Sayfa HTML kodlarinda “otomasyon” kelimesi gectigini test edin

        String expectedHtmlIcerik = "otomasyon";
        String actualSayfaKaynakKodlari = driver.getPageSource();

        if (actualSayfaKaynakKodlari.contains(expectedHtmlIcerik)){
            System.out.println("sayfa kaynak kodlari testi PASSED");
        } else System.out.println("sayfa kaynak kodlari testi FAILED");

        //8. Sayfayi kapatin.
        Thread.sleep(3000);
        driver.quit();
    }
}
