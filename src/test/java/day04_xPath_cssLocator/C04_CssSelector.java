package day04_xPath_cssLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_CssSelector {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2-  https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");

        //3-  Browseri tam sayfa yapin
        driver.manage().window().maximize();

        //4-  Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //5-  Sayfa basliginin “Test Otomasyonu” ifadesi icerdigini test edin
        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Title testi PASSED");
        } else System.out.println("Title testi FAILED");

        //6-  Furniture linkine tiklayin
        driver.findElement(By.xpath("(//li[@class='has-sub'])[5]"))
                .click();

        //7-  price range filtresinde min degere 40, max degere 200 yazip filtreleyin
        /*
            Bir Web sayfasinda asagida kaldigi icin gorunmeyen bir WebElementi
            kullanip kullanamayacagimiz TAMAMEN Web Developer'in yazdigi kodlara baglidir

            Bazi web sayfalarinda gorunmeyen web elementler kullanilabilirken
            bazi web sayfalarinda kullanilamayabilir

            Biz kullanilip kullanilamamasina etki edemeyiz

            sadece kullanmayi deneriz, kullanabiliyorsak sorun yok
            kullanamiyorsak sayfayi asagidaki kodu kullanarak page down yapabiliriz

                    Actions actions = new Actions(driver);
                    actions.sendKeys(Keys.PAGE_DOWN).perform();
         */




        WebElement minTutarKutusu = driver.findElement(By.cssSelector("input[class='form-control minPrice']"));

        WebElement maxTutarKutusu = driver.findElement(By.cssSelector("input[class='form-control maxPrice']"));

        minTutarKutusu.clear();
        minTutarKutusu.sendKeys("40");

        maxTutarKutusu.clear();
        maxTutarKutusu.sendKeys("200");

        // filtreleme icin filtrele butonuna basalim
        driver.findElement(By.cssSelector("button[class='price-range-button']"))
                .click();


        //8-  filtreleme sonucunda urun bulunabildigini test edin

        List<WebElement> bulunanElementlerListesi =
                driver.findElements(By.cssSelector("div[class='product-box mb-2 pb-1']"));

        int actualBulunanUrunSayisi = bulunanElementlerListesi.size();

        if (actualBulunanUrunSayisi > 0 ){
            System.out.println("Filtreleme testi PASSED");
        } else System.out.println("Filtreleme testi FAILED");

        //9-Ilk urunu tiklayin

        bulunanElementlerListesi.get(0)
                .click();

        //10- Urun fiyatinin 40 ile 200 arasinda oldugunu test edin

        WebElement fiyatElementi = driver.findElement(By.id("priceproduct"));

        String urunFiyatiStr = fiyatElementi.getText();  // $50.00

        urunFiyatiStr = urunFiyatiStr.replaceAll("\\D",""); // 5000

        double urunFiyati = Double.parseDouble(urunFiyatiStr) / 100; // 50.00


        if (urunFiyati >=40 && urunFiyati<=200){
            System.out.println("Fiyat filtreleme testi PASSED");
        } else System.out.println("Fiyat filtreleme testi FAILED");

        //11-Sayfayi kapatin
        Thread.sleep(2000);
        driver.quit();
    }
}
