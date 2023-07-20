package tests.day05_maven_JUnitFramework;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_MavenIlktest {
    public static void main(String[] args) throws InterruptedException {
        /*
        Selenium 4.7.0 ile Selenium kendi WebDriver'ini olusturma ve kullanabilme imkani verdi

        Tum sirketler Selenium WbDriver'i kullanmayabilir

        Sirketlerde eskiden beri kullanilan eski bir webdriver varsa
        onu projemize eklememiz ve kullanmamiz eklememiz istenilebilir.

        Boyle bir durumda istenen WebDriver'i da pom.xml'e eklememiz istenilebilir.
        pom.xlm'e ekledikten sonra her class'da
        WebDriver objesi olusturmadan once
        yukledigimiz WebDriver ile ilgili setup'i calistirmaliyiz.
         */

        WebDriver driver  = new ChromeDriver();
        driver. manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
        Thread.sleep(3000);
        driver.close();
    }
}
