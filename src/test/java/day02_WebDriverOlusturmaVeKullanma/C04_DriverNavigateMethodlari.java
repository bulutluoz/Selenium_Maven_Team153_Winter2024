package day02_WebDriverOlusturmaVeKullanma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverNavigateMethodlari {

    public static void main(String[] args) throws InterruptedException {

        /*
            Thread.sleep() kodlarin calismasini
            verdigimiz sure boyunca durdurur

            Biz ilk defa testi hazirlarken,
            veya testi bir sunumda gostermemiz gerekirse
            test adimlarini gozlemleyebilmek icin
            Thread.sleep() kullanilabilir


            ANNNCCCAAAAKKK  calismamiz bittiginde
            bu beklemeleri silmek daha dogru olacaktir

            toplu calistirmalarda bu beklemelerin
            ciddi zaman kayiplarina yol acacagi unutulmamalidir
         */

        WebDriver driver = new ChromeDriver();

        //1. Youtube ana sayfasina gidin . https://www.youtube.com/
        driver.navigate().to("https://www.youtube.com/");
        // driver.get() ile ayni islemi yapar


        // 2. url’in “youtube” icerdigini test edin.
        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Youtube Url testi PASSED");
        }else System.out.println("Youtube Url testi FAILED");


        //3. Testotomasyonu sayfasina gidin. https://www.testotomasyonu.com/
        driver.get("https://www.testotomasyonu.com/");

        //4. Title’in “Test Otomasyonu” icerdigini test edin.
        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Testotomasyonu title testi PASSED");
        }else  System.out.println("Testotomasyonu title testi FAILED");


        //5. Tekrar YouTube’sayfasina donun.
        driver.navigate().back();

        //6. Title’in “YouTube” oldugunu test edin
        String expectedTitle = "YouTube";
        actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Youtube title testi PASSED");
        }else System.out.println("Youtube title testi FAILED");


        //7. Sayfayi Refresh(yenile) yapin.
        driver.navigate().refresh();


        //8. Sayfayi kapatalim / Tum sayfalari kapattin.
        driver.quit();

    }
}
