package day02_WebDriverOlusturmaVeKullanma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_DriverManageImplicitlyWait {

    public static void main(String[] args) throws InterruptedException {


        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        /*
            ImplicitlyWait
            Web sayfasinin yuklenmesi ve
            WebElementlerin bulunmasi icin driver objesine sure tanimlamak icin kullanilir

            ImplicitlyWait esnek bir bekleme suresidir
            Oncelik bekleme degil islemin yapilmasidir
            eger sayfa 0.1 saniyede yuklenirse, hedef gerceklesmis olur
            ve driver yoluna devam eder


         */


        Thread.sleep(2000);
        // Mutlak bekleme suresidir
        // her durumda 2 saniye bekler

        driver.quit();

    }
}
