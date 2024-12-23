package day03_webelement_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_ByClassName {

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
        Thread.sleep(2000);

        // Bulunan urunlerin sayisini , gosterilen urun resim adedine bakarak bulun
        // List<WebElement> bulunanUrunElementleriList  =
                // driver.findElements(By.className("product-box my-2  py-1"));
        // By.className locator'i GENELDE benzer ozellikteki
        // WebElementleri gruplandirmak icin kullanilir
        // AMMMMAAA bir kotu huyu vardir....
        // Eger class attribute'unun degerinde space varsa
        // By.className buyuk ihtimalle HATA VERIR

        List<WebElement> bulunanUrunElementleriList  =
                                            driver.findElements(By.className("prod-img"));


        // ve kac urun bulunabildigini yazdirin
        System.out.println("Bulunan urun sayisi : " + bulunanUrunElementleriList.size());
        // Bulunan urun sayisi : 4


        // urun bulunabildigini test edin
        int actualBulunanUrunSayisi = bulunanUrunElementleriList.size();

        if (actualBulunanUrunSayisi>0){
            System.out.println("Urun arama testi PASSED");
        } else  System.out.println("Urun arama testi FAILED");


        // ? bulunan urunlerin isimlerini yazdirin


        // ilk urunu tiklayin


        // acilan urun sayfasindaki urun isminde
        // case sensitive olmadan "phone" kelimesi gectigini test edin


        // sayfayi kapatin

        Thread.sleep(2000);
        driver.quit();
    }
}
