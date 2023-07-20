package tests.day08_iFrame_windows_actionsClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_IFrame extends TestBase {

    @Test
    public void test01(){






        // https://the-internet.herokuapp.com.iframe adresine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");
        //bir method olusturun: iframeTest

        // - "An IFrame containing,,, ." textinin erisilebilir oldugunu test edin ve konsola yazdirin
        WebElement anIframeElementi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(anIframeElementi.isEnabled());

        System.out.println(anIframeElementi.getText());
        // - text Box'a "Merhaba Dunya!" yazin

        /*
        TextBox elementi gozumuzun onunde olmasina
        ve rahatca locate edilebilmesine ragmen
        direkt kullanilamiyir.
        html kodlarini inceleyince textbox'in bir iframe icerisinde oldugunu gorduk
        textbox'i kullanmadan once iframe'e gecis yapmaliyiz.
         */
        WebElement iFrameElementi = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrameElementi);

        WebElement textBoxElementi = driver.findElement(By.tagName("p"));
        textBoxElementi.clear();
        textBoxElementi.sendKeys("Merhaba Dunya!");
        // - textBox'in altinda bulunan"Elemental Selenium" link textinin gorunur oldugunu dogrulayin ve
        //   ve konsola yazdirin
        /*
        Bir iframe'e gecis yapildiysa
        normal sayfada islem yapilamaz
        normal sayfada islem yapmak isterseniz
        iframe'den cikmaniz gerekir.

        default.content(); anasayfaya cikar
        parentFrame(); eger ic ice iFrame'ler varsa bir ust iFrame'e cikar.
         */
        driver.switchTo().defaultContent();
        WebElement elemenalSeleniumElementi = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elemenalSeleniumElementi.isDisplayed());

        System.out.println(elemenalSeleniumElementi.getText());

        elemenalSeleniumElementi.click();

        bekle(13);
    }
}
