package day05_relativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C01_RelativeLocator {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //1 ) https://testotomasyonu.com/relativeLocators adresine gidin
        driver.get("https://testotomasyonu.com/relativeLocators");

        //2 ) DSLR Camera’yi  etrafindaki elementleri kullanarak
        //    3 farkli relative locator ile locate edip tiklayin

        /*
            Relative locator ozel bir durumda kullanilmak uzere olusturulmustur
            Ozel durum yoksa relative locator kullanmaya gerek yok

            OZEL DURUM :
            Web elementi gordugumuz ve HTML kodlarina ulasabildigimiz halde
            o web elementi kullanamiyorsak,
            etrafindaki kullanabilecegimiz web elementler ile tarif edebiliriz

            <li id="dslr-camera">
                <a id="pictext7" class="overlay" href="http://testotomasyonu.com/product/32">
                    <img id="pic7_thumb" src="https://testotomasyonu.com/uploads/product/1688040635pexels-pixabay-274973-removebg-preview.png" alt="">
                    <span>DSLR Camera</span></a>
            </li>

            1- hedef webelementin HTML kodlarini inceleyip
               bir locator belirleyin
               tag==> li  , id==> "dslr-camera" , class==> "overlay"
            2- hedef elementin etrafinda kullanabilecegimiz
               bir web element belirleyin ve kaydedin
            3- gordugumuz ama kullanamadigimiz
               hedef webelementi, etrafindaki webelement ile tanimlayin

         */

        WebElement appleKulaklikElementi = driver.findElement(By.id("pic6_thumb"));

        WebElement dslrCamera1 =
                driver.findElement(RelativeLocator.with(By.id("pic7_thumb")).toRightOf(appleKulaklikElementi));
        Thread.sleep(1000);
        dslrCamera1.click();

        //3 ) Acilan urunun DSLR Camera oldugunu test edin.

        WebElement acilanSayfadakiIsimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));


        String expectedIsim = "DSLR Camera";
        String actualIsim = acilanSayfadakiIsimElementi.getText();

        if (actualIsim.equalsIgnoreCase(expectedIsim)){
            System.out.println("Relative locator 1.test PASSED");
        }else System.out.println("Relative locator 1.test FAILED");

        Thread.sleep(1000);


        // 2.olarak Bat Kulakligin altinda diye tarif edelim

        // yeniden urunlerin oldugu sayfaya gidelim
        driver.get("https://testotomasyonu.com/relativeLocators");

        // bat kulakligi locate edip kaydedelim
        WebElement batKulaklikElementi = driver.findElement(By.id("pic2_thumb"));

        // hedef elementimiz olan DSLR Camera'yi bat kulaklik ile tarif edelim
        WebElement dslrCamera2 =
                driver.findElement(RelativeLocator.with(By.tagName("img")).below(batKulaklikElementi));

        Thread.sleep(1000);
        // locate edip kaydettigimiz hedef elementi click yapalim
        dslrCamera2.click();

        // Acilan urunun DSLR Camera oldugunu test edin.
        // yukarda acilanSayfadakiIsimElementi locate edilip kaydedildigi icin
        // yeniden locate etmedik ama
        // StaleElementReferenceException(bayat element) hatasi aldik
        // BU EXCEPTION daha once kullanilan ANCAK sonrasinda baska sayfalara gidildigi icin
        // bayatlayan web elementler icin kullanilir
        // caresi yeniden locate edip, kaydetmektir

        expectedIsim = "DSLR Camera";
        acilanSayfadakiIsimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));
        actualIsim = acilanSayfadakiIsimElementi.getText();

        if (actualIsim.equalsIgnoreCase(expectedIsim)){
            System.out.println("Relative locator 2.test PASSED");
        }else System.out.println("Relative locator 2.test FAILED");

        Thread.sleep(1000);


        // 3.olarak Motor telefonun solunda diye tarif edelim

        // yeniden urunlerin oldugu sayfaya gidelim
        driver.get("https://testotomasyonu.com/relativeLocators");

        // motor Telefon'u locate edip kaydedelim

        WebElement motorTelefon = driver.findElement(By.id("pic8_thumb"));

        WebElement dslrCamera3 =
                driver.findElement(RelativeLocator.with(By.className("overlay")).toLeftOf(motorTelefon));

        dslrCamera3.click();

        expectedIsim = "DSLR Camera";
        acilanSayfadakiIsimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));
        actualIsim = acilanSayfadakiIsimElementi.getText();

        if (actualIsim.equalsIgnoreCase(expectedIsim)){
            System.out.println("Relative locator 3.test PASSED");
        }else System.out.println("Relative locator 3.test FAILED");

        Thread.sleep(1000);

        driver.quit();

    }
}
