package tests.day09_actions_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_FileExistsTest extends TestBase {
    @Test
    public void test01(){


        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //3. logo.png dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='avatar.png']")).click();
        bekle(3);
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim

        // once dosyanin indirilecegi dosya yolunu dinamik olarak olusturalim.

        String dinamikDosyaYolu = System.getProperty("user.home")      + "/Downloads/avatar.png";
        //                        herkesin bilgisayarinda farkli kisim + herkes icin ayni olan kisim

        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
    }
}
