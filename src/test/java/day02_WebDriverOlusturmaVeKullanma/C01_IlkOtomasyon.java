package day02_WebDriverOlusturmaVeKullanma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_IlkOtomasyon {

    public static void main(String[] args) throws InterruptedException {

        // otomasyon yapmak uzere olusturudugumuz bir class'da
        // ilk yapmamiz gereken sey :
        // WebDriver objesi edinmektir

        WebDriver driver = new ChromeDriver();
        // baska hicbirsey yapmasak bile
        // bu satir bir browser olusturur ve bizim emrimizi bekler


        // olusturdugumuz driver objesi
        // bizim elimiz ve gozumuz gibidir,
        // klavye ve mouse kullanarak yaptigimiz islemlerin
        // buyuk bir bolumunu driver objesi ile yapabiliriz


        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        // get() icerisinde Url yazilirken www yazilmasa da olur
        // ANNCCCAAAAKKK https:// yazilmazsa kod calismaz



        Thread.sleep(3000); // Kodlari yazilan milisaniye miktarinca bekletir


        // test sirasinda birden fazla window acilirsa
        //driver.close(); // sadece sonuncu browser'i kapatir
        driver.quit(); // acilan tum browser'lari kapatir.

    }
}
