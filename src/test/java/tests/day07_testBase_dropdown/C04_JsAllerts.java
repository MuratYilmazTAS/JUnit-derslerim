package tests.day07_testBase_dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JsAllerts extends TestBase {
    /*
    bir testi calistirirken web sayfasi bize uyari verebilir.(alert)
    eger bu uyariyi sag click ile inspect yapabiliyorsak
    bu bir html allert'dir ve bu diger tum html web elementler gibi
    locate edilebilir ve kullanilabilirler.
    Ancak
    sag click yapip inspect edemiyorsak bunlar java script allert olabilirler
    java script alletler locate edilemez. sadece driver'imizi o alertlere switch yapip
    o alertlerde istenen islemleri yapabiliriz.
     */
    @Test
    public void test01(){
        // 1. test
        // https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //1. alert'e tiklayin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        //Alert'deki yazinin "I am a JS Alert" oldugunu test edin
       String actualAlertYazisi = driver.switchTo().alert().getText();
       String expectedAlertYazisi = "I am a JS Alert";
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);


        // ok tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();
        bekle(3);

    }

    @Test
    public void test02(){
        //2.Test
        //  - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //  - 2.alert'e tiklayalim
        bekle(2);
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        bekle(2);
        //  - Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        driver.switchTo().alert().dismiss();
        String expectedSonucYazisi = "You clicked: Cancel";
        String actualSonucYazisi = driver.findElement(By.xpath("//*[@id='result']"))
                .getText();
        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);
        bekle(2);
    }
    @Test
    public void test03(){
        //3.Test
        //  - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //  - 3.alert'e tiklayalim
        bekle(2);
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        //  - Cikan prompt ekranina "Abdullah" yazdiralim
        bekle(2);
        driver.switchTo().alert().sendKeys("Abdullah");
        //  - OK tusuna basarak alert'i kapatalim
        bekle(2);
        driver.switchTo().alert().accept();
        //  - Cikan sonuc yazisinin Abdullah icerdigini test edelim
        String expectedSonucIcerik = "Abdullah";
        String actualSonucYazisi = driver.findElement(By.xpath("//*[@id='result']"))
                .getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedSonucIcerik));
        bekle(2);
    }
}


