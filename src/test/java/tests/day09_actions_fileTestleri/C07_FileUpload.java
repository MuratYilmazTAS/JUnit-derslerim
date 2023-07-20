package tests.day09_actions_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C07_FileUpload extends TestBase {
    @Test
    public void test01(){

        //1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //2.chooseFile butonuna basalim
        /*
        eger choose file butonununa basarsak bilgisayarimizin klasor yapisi acilir
        oradan dosya secmek icin mouse'i kullanamayacagimizdan
        bu yontemle dosya upload mumkun degildir

        Bunun yerine Selenium'un bize su dugu cozumu kullaniyoruz.
        chooseFile butonuna sendKeys ile yuklemek istedigimiz
        dosyanin dosya yolunu donderiyoruz.
         */
        WebElement chooseFileButtonElementi = driver.findElement(By.id("file-upload"));
        String dinamikDosyaYolu = System.getProperty("user.home") + "/Desktop/avatar.png";
        chooseFileButtonElementi.sendKeys(dinamikDosyaYolu);
        bekle(3);
        //3.masaustune kopyaladigimiz avatar.png dosyasini secelim.
        //4.Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        bekle(2);
        //5.“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUploadedElementi = driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));
        Assert.assertTrue(fileUploadedElementi.isDisplayed());
    }
}
