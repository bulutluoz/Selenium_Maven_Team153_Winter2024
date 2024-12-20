package day02_WebDriverOlusturmaVeKullanma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C06_DriverManageWindowMethodlari {

    public static void main(String[] args) throws InterruptedException {

        // gerekli ayarlari yapip
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // driver.manage().window().maximize();
        // kodumuzun daha saglikli calismasi icin
        // baslangicta yaptigimiz ayarlara window'u maximize yapmayi da ekleyecegiz

        System.out.println("Baslangicta size : " + driver.manage().window().getSize());
        System.out.println("Baslangicta konum : " + driver.manage().window().getPosition());

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        Thread.sleep(2000);

        // browser'i maximize yapin
        driver.manage().window().maximize();

        System.out.println("Maximize size : " + driver.manage().window().getSize());
        System.out.println("Maximize konum : " + driver.manage().window().getPosition());


        Thread.sleep(2000);

        // browser'i fullscreen yapin
        driver.manage().window().fullscreen();

        System.out.println("Fullscreen size : " + driver.manage().window().getSize());
        System.out.println("Fullscreen konum : " + driver.manage().window().getPosition());


        // browser'in baslangic pixel'ini 300,300
        // ve boyutunu 500X500 yapin
        Thread.sleep(2000);
        driver.manage().window().setPosition(new Point(300,300));
        driver.manage().window().setSize(new Dimension(500,500));


        System.out.println("Ozel boyut size : " + driver.manage().window().getSize());
        System.out.println("Ozel boyut konum : " + driver.manage().window().getPosition());


        Thread.sleep(2000);
        driver.quit();



    }
}
